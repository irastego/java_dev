import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Osoblje fakultetskoOsoblje = new Osoblje();

        try {
            fakultetskoOsoblje.ucitajIzDatoteke("fakultet.txt");
        } catch (IOException e) {
            System.out.println("Greška prilikom čitanja datoteke: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        int odabir = -1;

        while (odabir != 0){
            prikaziMeni();
            System.out.print("Vas odabir: ");

            try{
                odabir = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("\nGreska! Molimo unesite broj iz menija.");
                odabir = -1;
                continue;
            }

            switch (odabir) {
                case 1:
                    dodajProfesora(scanner, fakultetskoOsoblje);
                    break;
                case 2:
                    dodajStudenta(scanner, fakultetskoOsoblje);
                    break;
                case 3:
                    System.out.println(fakultetskoOsoblje.ispisi());
                    break;
                case 0:
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
        System.out.println("1. Dodaj novog profesora");
        System.out.println("2. Dodaj novog studenta");
        System.out.println("3. Ispiši sve osobe");
        System.out.println("0. Izlaz");
    }

    private static void dodajStudenta(Scanner scanner, Osoblje osoblje){
        try{
            System.out.print("Unesite OIB studenta: ");
            String oib = scanner.nextLine();
            osoblje.isOibValidan(oib);

            System.out.print("Unesite ime studenta: ");
            String ime = scanner.nextLine();

            System.out.print("Unesite prezime studenta: ");
            String prezime = scanner.nextLine();

            Student noviStudent = new Student(ime, prezime, "Student", oib);
            osoblje.dodaj(noviStudent);
            System.out.println("Student " + ime + " " + prezime + " uspješno dodan!");
        } catch (OibVecPostojiException e){
            System.out.println("Greška: " + e.getMessage());
        }
    }

    private static void dodajProfesora(Scanner scanner, Osoblje osoblje){
        try{
            System.out.print("Unesite OIB profesora: ");
            String oib = scanner.nextLine();
            osoblje.isOibValidan(oib);

            System.out.print("Unesite ime profesora: ");
            String ime = scanner.nextLine();

            System.out.print("Unesite prezime profesora: ");
            String prezime = scanner.nextLine();

            Profesor noviProfesor = new Profesor(ime, prezime, "Profesor", oib);
            osoblje.dodaj(noviProfesor);
            System.out.println("Profesor " + ime + " " + prezime + " uspješno dodan!");
        } catch (OibVecPostojiException e){
            System.out.println("Greška: " + e.getMessage());
        }
    }
}