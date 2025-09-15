import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String NAZIV_DATOTEKE = "vozila.txt";

    public static void main(String[] args) {
        EvidencijaVozila evidencija = new EvidencijaVozila();
        Scanner scanner = new Scanner(System.in);

        try {
            evidencija.ucitajPodatkeIzDatoteke(NAZIV_DATOTEKE);
            System.out.println("Podaci uspješno učitani iz datoteke: " + NAZIV_DATOTEKE);
        } catch (IOException e) {
            System.out.println("Datoteka '" + NAZIV_DATOTEKE + "' nije pronađena, kreće se s praznom evidencijom.");
        } catch (NeispravniPodaciException e) {
            System.out.println("Greška u podacima unutar datoteke: " + e.getMessage());
        }

        int odabir = -1;
        while (odabir != 0) {
            prikaziMeni();
            System.out.print("Vaš odabir: ");

            try {
                odabir = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("\nGreška! Molimo unesite broj iz menija.");
                scanner.nextLine();
                odabir = -1;
                continue;
            }

            switch (odabir) {
                case 1:
                    dodajAutomobil(scanner, evidencija);
                    break;
                case 2:
                    dodajMotocikl(scanner, evidencija);
                    break;
                case 3:
                    evidencija.prikaziSvaVozila();
                    break;
                case 0:
                    spremiPodatke(evidencija);
                    System.out.println("Doviđenja!");
                    break;
                default:
                    System.out.println("\nNepoznata opcija. Molimo pokušajte ponovo.");
                    break;
            }
        }
        scanner.close();
    }

    private static void prikaziMeni() {
        System.out.println("\nGLAVNI MENI");
        System.out.println("1. Dodaj novi automobil");
        System.out.println("2. Dodaj novi motocikl");
        System.out.println("3. Prikaži sva vozila");
        System.out.println("0. Spremi i izađi");
        System.out.println("--------------------");
    }

    private static void dodajAutomobil(Scanner scanner, EvidencijaVozila evidencija) {
        try {
            System.out.println("\nDodavanje novog automobila");
            System.out.print("Unesite registarski broj: ");
            String registracija = scanner.nextLine();

            System.out.print("Unesite marku: ");
            String marka = scanner.nextLine();

            System.out.print("Unesite godinu proizvodnje: ");
            int godina = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Unesite broj vrata: ");
            int brojVrata = scanner.nextInt();
            scanner.nextLine();

            Automobil noviAuto = new Automobil(registracija, marka, godina, brojVrata);
            evidencija.dodajVozilo(noviAuto);

            System.out.println("Automobil uspješno dodan u evidenciju!");

        } catch (NeispravniPodaciException e) {
            System.out.println("GREŠKA: " + e.getMessage() + " Vozilo nije dodano.");
        } catch (InputMismatchException e) {
            System.out.println("GREŠKA: Unesen je neispravan format za broj. Vozilo nije dodano.");
            scanner.nextLine();
        }
    }

    private static void dodajMotocikl(Scanner scanner, EvidencijaVozila evidencija) {
        try {
            System.out.println("\nDodavanje novog motocikla");
            System.out.print("Unesite registarski broj: ");
            String registracija = scanner.nextLine();

            System.out.print("Unesite marku: ");
            String marka = scanner.nextLine();

            System.out.print("Unesite godinu proizvodnje: ");
            int godina = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Unesite tip motora (npr. benzinski, dizel, električni): ");
            String tipMotora = scanner.nextLine();

            Motocikl noviMoto = new Motocikl(registracija, marka, godina, tipMotora);
            evidencija.dodajVozilo(noviMoto);

            System.out.println("Motocikl uspješno dodan u evidenciju!");

        } catch (NeispravniPodaciException e) {
            System.out.println("GREŠKA: " + e.getMessage() + " Vozilo nije dodano.");
        } catch (InputMismatchException e) {
            System.out.println("GREŠKA: Unesen je neispravan format za broj. Vozilo nije dodano.");
            scanner.nextLine();
        }
    }

    private static void spremiPodatke(EvidencijaVozila evidencija) {
        try {
            evidencija.spremiPodatkeUDatoteku(NAZIV_DATOTEKE);
            System.out.println("Podaci su uspješno spremljeni u datoteku: " + NAZIV_DATOTEKE);
        } catch (IOException e) {
            System.out.println("Došlo je do greške prilikom spremanja podataka: " + e.getMessage());
        }
    }
}