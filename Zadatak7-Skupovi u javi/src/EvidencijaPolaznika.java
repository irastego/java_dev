import java.util.*;

public class EvidencijaPolaznika {
    private static Set<Polaznik> polaznici = new TreeSet<>(Comparator.comparing(Polaznik::getPrezime));
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("\n1. Dodaj polaznika");
            System.out.println("2. Ispis svih polaznika");
            System.out.println("3. Pretraga po emailu");
            System.out.println("4. Izlaz");
            System.out.println("Odaberi opciju: ");

            int izbor = scanner.nextInt();
            scanner.nextLine();
            switch(izbor){
                case 1:
                    dodajPolaznika();
                    break;
                case 2:
                    ispisiPolaznike();
                    break;
                case 3:
                    pretraziPoEmailu();
                    break;
                case 4:
                    System.out.println("Kraj programa.");
                    return;
                default:
                    System.out.println("Nevažeći unos!");
            }
        }
    }

    private static void dodajPolaznika() {
        System.out.print("Unesi ime: ");
        String ime = scanner.nextLine();
        System.out.print("Unesi prezime: ");
        String prezime = scanner.nextLine();
        System.out.print("Unesi email: ");
        String email = scanner.nextLine();

        Polaznik novi = new Polaznik(ime, prezime, email);
        if (polaznici.contains(novi)) {
            System.out.println("Polaznik s tim emailom već postoji!");
        } else {
            polaznici.add(novi);
            System.out.println("Polaznik dodan!");
        }
    }

    private static void ispisiPolaznike() {
        if (polaznici.isEmpty()) {
            System.out.println("Nema polaznika");
        } else {
            System.out.println("Popis polaznika:");
            for (Polaznik p : polaznici) {
                System.out.println(p);
            }
        }
    }

    private static void pretraziPoEmailu() {
        System.out.print("Unesi email za pretragu: ");
        String email = scanner.nextLine().toLowerCase();
        Polaznik trazeni = new Polaznik("", "", email);
        if (polaznici.contains(trazeni)) {
            for (Polaznik p : polaznici) {
                if (p.getEmail().equals(email)) {
                    System.out.println("Pronađen: " + p);
                    return;
                }
            }
        } else {
            System.out.println("Polaznik s tim emailom nije pronađen.");
        }
    }
}
