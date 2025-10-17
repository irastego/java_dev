package com.zavrsniZadatak.application;

import com.zavrsniZadatak.entity.Polaznik;
import com.zavrsniZadatak.entity.ProgramObrazovanja;
import com.zavrsniZadatak.entity.Upis;
import com.zavrsniZadatak.repository.PolaznikRepository;
import com.zavrsniZadatak.repository.ProgramObrazovanjaRepository;
import com.zavrsniZadatak.repository.utility.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class ObrazovanjeService {
    private final Scanner scanner;
    private final PolaznikRepository polaznikRepository;
    private final ProgramObrazovanjaRepository programObrazovanjaRepository;

    public ObrazovanjeService() {
        this.scanner = new Scanner(System.in);
        this.polaznikRepository = new PolaznikRepository();
        this.programObrazovanjaRepository = new ProgramObrazovanjaRepository();
    }

    public void run() {
        while (true) {
            int odabranaOpcija = printMenu();
            if (odabranaOpcija == 0) {
                System.out.println("Zatvaranje konekcije i izlaz iz programa.");
                HibernateUtil.shutdown();
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
        System.out.println("\n--- GLAVNI IZBORNIK (Hibernate) ---");
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

        Polaznik noviPolaznik = new Polaznik();
        noviPolaznik.setIme(ime);
        noviPolaznik.setPrezime(prezime);
        polaznikRepository.dodaj(noviPolaznik);
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

        ProgramObrazovanja noviProgram = new ProgramObrazovanja();
        noviProgram.setNaziv(naziv);
        noviProgram.setCsvet(csvet);
        programObrazovanjaRepository.dodaj(noviProgram);
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

        Polaznik polaznikZaUpis = polaznikRepository.dohvatiPoId(idPolaznika);
        ProgramObrazovanja programZaUpis = programObrazovanjaRepository.dohvatiPoId(idPrograma);

        if (polaznikZaUpis != null && programZaUpis != null) {
            Upis noviUpis = new Upis(polaznikZaUpis, programZaUpis);
            programObrazovanjaRepository.upisi(noviUpis);
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

        List<Upis> upisi = programObrazovanjaRepository.dohvatiUpiseZaProgram(idPrograma);

        if (upisi.isEmpty()) {
            System.out.println("Nema upisanih polaznika na odabranom programu.");
        } else {
            System.out.println("\n--- Polaznici na odabranom programu ---");
            for (Upis upis : upisi) {
                Polaznik p = upis.getPolaznik();
                ProgramObrazovanja po = upis.getProgramObrazovanja();
                System.out.printf(" - %s %s, Program: %s, CSVET bodovi: %d%n",
                        p.getIme(), p.getPrezime(), po.getNaziv(), po.getCsvet());
            }
            System.out.println("----------------------------------------\n");
        }
    }
}