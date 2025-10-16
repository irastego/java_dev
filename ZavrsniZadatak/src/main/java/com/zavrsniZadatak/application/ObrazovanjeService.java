package com.zavrsniZadatak.application;

import com.zavrsniZadatak.entity.Polaznik;
import com.zavrsniZadatak.entity.ProgramObrazovanja;
import com.zavrsniZadatak.repository.PolaznikRepository;
import com.zavrsniZadatak.repository.ProgramObrazovanjaRepository;

import java.util.List;
import java.util.Scanner;

public class ObrazovanjeService {
    private Scanner scanner;
    private PolaznikRepository polaznikRepository;
    private ProgramObrazovanjaRepository programObrazovanjaRepository;

    public ObrazovanjeService() {
        this.scanner = new Scanner(System.in);
        this.polaznikRepository = new PolaznikRepository();
        this.programObrazovanjaRepository = new ProgramObrazovanjaRepository();
    }

    public void run() {
        while (true) {
            int odabranaOpcija = printMenu();
            if (odabranaOpcija == 0) {
                System.out.println("Doviđenja!");
                break;
            }

            try {
                switch (odabranaOpcija) {
                    case 1: unesiNovogPolaznika(); break;
                    case 2: unesiNoviProgramObrazovanja(); break;
                    case 3: upisiPolaznikaNaProgramObrazovanja(); break;
                    case 4: prebaciPolaznika(); break;
                    case 5: ispisiPolaznikePrograma(); break;
                    default: System.out.println("Nepoznata opcija."); break;
                }
            } catch (Exception ex) {
                System.err.println("Dogodila se neočekivana greška. Pokušajte ponovo.");
                ex.printStackTrace();
            }
        }
    }

    private int printMenu() {
        System.out.println("\n--- GLAVNI IZBORNIK ---");
        System.out.println("1.) Unesi novog polaznika");
        System.out.println("2.) Unesi novi program obrazovanja");
        System.out.println("3.) Upiši polaznika na program obrazovanja");
        System.out.println("4.) Prebaci polaznika iz jednog u drugi program obrazovanja");
        System.out.println("5.) Ispiši polaznike na zadanom programu");
        System.out.println("0.) Izlaz");
        System.out.print("Odaberite opciju: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Neispravan unos. Molimo unesite broj: ");
            scanner.next();
        }
        int odabir = scanner.nextInt();
        clearScanner();
        return odabir;
    }

    private void clearScanner() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    private void unesiNovogPolaznika() {
        System.out.print("Unesite ime polaznika: ");
        String ime = scanner.nextLine();
        System.out.print("Unesite prezime polaznika: ");
        String prezime = scanner.nextLine();

        if (ime.isBlank() || prezime.isBlank()) {
            System.out.println("Greška: Ime i prezime ne smiju biti prazni.");
            return;
        }
        polaznikRepository.dodaj(new Polaznik(ime, prezime));
        System.out.println("Novi polaznik je uspješno dodan.");
    }

    private void unesiNoviProgramObrazovanja() {
        System.out.print("Unesite naziv programa obrazovanja: ");
        String naziv = scanner.nextLine();

        System.out.print("Unesite broj CSVET bodova: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Neispravan unos. Molimo unesite broj: ");
            scanner.next();
        }
        int csvet = scanner.nextInt();
        clearScanner();

        if (naziv.isBlank() || csvet < 0) {
            System.out.println("Greška: Naziv ne smije biti prazan i CSVET bodovi moraju biti pozitivni.");
            return;
        }
        programObrazovanjaRepository.dodaj(new ProgramObrazovanja(naziv, csvet));
        System.out.println("Novi program obrazovanja je uspješno dodan.");
    }

    private void upisiPolaznikaNaProgramObrazovanja() {
        List<Polaznik> polaznici = polaznikRepository.dohvati();
        List<ProgramObrazovanja> programi = programObrazovanjaRepository.dohvati();

        if(polaznici.isEmpty() || programi.isEmpty()){
            System.out.println("Mora postojati barem jedan polaznik i jedan program za izvršavanje upisa.");
            return;
        }

        System.out.println("\n--- Dostupni polaznici ---");
        polaznici.forEach(System.out::println);
        System.out.print("Unesite ID polaznika: ");
        int idPolaznika = scanner.nextInt();
        clearScanner();

        System.out.println("\n--- Dostupni programi ---");
        programi.forEach(System.out::println);
        System.out.print("Unesite ID programa: ");
        int idPrograma = scanner.nextInt();
        clearScanner();

        if (polaznici.stream().anyMatch(p -> p.getId() == idPolaznika) && programi.stream().anyMatch(p -> p.getId() == idPrograma)) {
            programObrazovanjaRepository.upisi(idPolaznika, idPrograma);
            System.out.println("Polaznik je uspješno upisan.");
        } else {
            System.out.println("Greška: Jedan od unesenih ID-jeva nije ispravan.");
        }
    }

    private void prebaciPolaznika() {
        List<Polaznik> polaznici = polaznikRepository.dohvati();
        List<ProgramObrazovanja> programi = programObrazovanjaRepository.dohvati();

        if(polaznici.isEmpty() || programi.size() < 2){
            System.out.println("Mora postojati barem jedan polaznik i dva programa za izvršavanje prebacivanja.");
            return;
        }

        System.out.println("\n--- Dostupni polaznici ---");
        polaznici.forEach(System.out::println);
        System.out.print("Unesite ID polaznika kojeg prebacujete: ");
        int idPolaznika = scanner.nextInt();
        clearScanner();

        System.out.println("\n--- Dostupni programi ---");
        programi.forEach(System.out::println);
        System.out.print("Unesite ID programa S KOJEG prebacujete polaznika: ");
        int idStariProgram = scanner.nextInt();
        clearScanner();

        System.out.print("Unesite ID programa NA KOJI prebacujete polaznika: ");
        int idNoviProgram = scanner.nextInt();
        clearScanner();

        programObrazovanjaRepository.prebaciPolaznika(idPolaznika, idStariProgram, idNoviProgram);
    }

    private void ispisiPolaznikePrograma() {
        List<ProgramObrazovanja> programi = programObrazovanjaRepository.dohvati();
        if(programi.isEmpty()){
            System.out.println("Nema dostupnih programa za prikaz.");
            return;
        }

        System.out.println("\n--- Dostupni programi ---");
        programi.forEach(System.out::println);
        System.out.print("Unesite ID programa za koji želite ispis polaznika: ");
        int idPrograma = scanner.nextInt();
        clearScanner();

        programObrazovanjaRepository.ispisiPolaznike(idPrograma);
    }
}
