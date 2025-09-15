import java.util.ArrayList;
import java.util.Scanner;

public class EvidencijaPolaznika {
    private static ArrayList<Polaznik> polaznici = new ArrayList<>();
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
                    dodajPolznika();
                    break;
                case 2:
                    ispisiPolaznike();
                    break;
                case 3:
                    pretraziPoEmailu();
                    break;
                case 4: {
                    System.out.println("Kraj programa.");
                    return;
                }
                default:
                    System.out.println("Nevazeci unos!");
            }
        }
    }

    private static void dodajPolznika(){
        System.out.print("Unesi ime: ");
        String ime = scanner.nextLine();
        System.out.print("Unesi prezime: ");
        String prezime = scanner.nextLine();
        System.out.print("Unesi email: ");
        String email = scanner.nextLine();

        polaznici.add(new Polaznik(ime, prezime, email));
        System.out.println("Polaznik dodan");
    }

    private static void ispisiPolaznike(){
        if(polaznici.isEmpty()){
            System.out.println("Nema polaznika");
        } else {
            System.out.println("Popis polaznika: ");
            for(Polaznik p: polaznici){
                System.out.println(p);
            }
        }
    }

    private static void pretraziPoEmailu(){
        System.out.println("Unesi email za pretragu: ");
        String email = scanner.nextLine();

        for(Polaznik p : polaznici){
            if(p.getEmail().equalsIgnoreCase(email)){
                System.out.println("Pronadjen: " + p);
                return;
            }
        }
        System.out.println("Polaznik s tim emailom nije pronadjen.");
    }
}