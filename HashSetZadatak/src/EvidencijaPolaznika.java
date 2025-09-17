import java.util.*;

public class EvidencijaPolaznika {
    private static Map<String, Polaznik> polaznici = new HashMap<>();
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
        String email = scanner.nextLine().toLowerCase();

        if (polaznici.containsKey(email)) {
            System.out.println("Polaznik s tim emailom već postoji!");
        } else {
            Polaznik novi = new Polaznik(ime, prezime, email);
            polaznici.put(email, novi);
            System.out.println("Polaznik dodan!");
        }
    }

    private static void ispisiPolaznike() {
        if (polaznici.isEmpty()) {
            System.out.println("Nema polaznika");
        } else {
            System.out.println("Popis polaznika:");
            List<Polaznik> randomListaPolaznika = new ArrayList<>(polaznici.values());
            // primjer sa collections
            Collections.shuffle(randomListaPolaznika);
            for(Polaznik p : randomListaPolaznika){
                System.out.println(p);
            }
        }
    }

    private static void pretraziPoEmailu() {
        System.out.print("Unesi email za pretragu: ");
        String email = scanner.nextLine().toLowerCase();

        Polaznik p = polaznici.get(email);
        if (p != null) {
            System.out.println("Pronađen: " + p);
        } else {
            System.out.println("Polaznik s tim emailom nije pronađen.");
        }
    }

}
