import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//    Napiši program koji omogućuje korisniku unos neograničenog broja imena (String)
//    u ArrayList, ispisuje sva imena i zatim omogućuje brisanje određenog imena po unosu korisnika.

    public static void main(String[] args) {
        ArrayList<String> imena = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n1. Dodaj ime");
            System.out.println("2. Ispisi sva imena");
            System.out.println("3. Obrisi ime");
            System.out.println("4. Izlaz");
            System.out.print("Odaberi opciju: ");

            int izbor = scanner.nextInt();
            scanner.nextLine();

            switch (izbor){
                case 1:
                    System.out.print("Unesi ime: ");
                    String novoIme = scanner.nextLine();
                    imena.add(novoIme);
                    break;
                case 2:
                    if(imena.isEmpty()){
                        System.out.println("Lista imena je prazna.");
                    } else {
                        System.out.println("Sva imena: ");
                        for(String ime : imena){
                            System.out.println(ime);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Unesi ime za brisanje:");
                    String imeZaBrisanje = scanner.nextLine();

                    if(imena.remove(imeZaBrisanje)){
                        System.out.println("Ime obrisano!");
                    } else {
                        System.out.println("Ime nije pronadjeno.");
                    }
                    break;
                case 4:
                    System.out.println("Izlaz iz programa.");
                    return;
                default:
                    System.out.println("Nepoznata opcija!");
            }
        }
    }
}