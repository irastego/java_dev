import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Vozilo> vozila = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Unesite tip vozila za unos: (1) Automobil, (2) Kamion, (0) Izlaz");
            String unos = scanner.nextLine().trim();

            if (unos.equals("0")) {
                System.out.println("Kraj unosa");
                break;
            } else if (unos.equals("1")) {
                Automobil auto = unosAutomobila(scanner);
                vozila.add(auto);
            } else if (unos.equals("2")) {
                Kamion kamion = unosKamiona(scanner);
                vozila.add(kamion);
            } else {
                System.out.println("Nepoznata opcija. Pokusajte ponovno.");
            }
        }
    }

        private static Automobil unosAutomobila(Scanner scanner){
            System.out.println("Unos automobila:");

            int godina = unosCijelogBroja(scanner, "Unesite godinu proizvodnje (1950-2025): ", 1950, 2025);

            String proizvodjac;
            do{
                System.out.print("Unesite proizvodaca: ");
                proizvodjac = scanner.nextLine().trim();
                if(proizvodjac.isEmpty()){
                    System.out.println("Proizvodjac ne smije biti prazan!");
                }
            } while(proizvodjac.isEmpty());

            String registracija;
            do{
                System.out.print("Unesite registraciju: ");
                registracija = scanner.nextLine().trim();
                if(registracija.isEmpty()){
                    System.out.println("Registracija ne smije biti prazna!");
                }
            } while(registracija.isEmpty());

            int brojVrata = unosCijelogBroja(scanner, "Unesite broj vrata: ", 1, 10);

            String tipGoriva;
            do{
                System.out.print("Unesite tip goriva: ");
                tipGoriva = scanner.nextLine().trim();
                if(tipGoriva.isEmpty()){
                    System.out.println("Tip goriva ne smije biti prazan!");
                }
            }while(tipGoriva.isEmpty());


            return new Automobil(godina, proizvodjac, registracija, brojVrata, tipGoriva);
        }

        private static Kamion unosKamiona(Scanner scanner){
            System.out.println("Unos kamiona:");
            int godina = unosCijelogBroja(scanner, "Unesite godinu proizvodnje(1950-2025): ", 1950, 2025);

            String proizvodjac;
            do{
                System.out.print("Unesite proizvodaca: ");
                proizvodjac = scanner.nextLine().trim();
                if(proizvodjac.isEmpty()){
                    System.out.println("Proizvodjac ne smije biti prazan!");
                }
            } while (proizvodjac.isEmpty());

            String registracija;
            do{
                System.out.println("Unesite registraciju: ");
                registracija = scanner.nextLine().trim();
                if(registracija.isEmpty()){
                    System.out.println("Registracija ne smije biti prazna!");
                }
            } while(registracija.isEmpty());

            double nosivost;
            while(true){
                System.out.print("Unesite nosivost (u tonama, npr. 10.5): ");
                String unos = scanner.nextLine().trim();
                try{
                    nosivost = Double.parseDouble(unos);
                    if (nosivost > 0) break;
                    else System.out.println("Nosivost mora biti pozitivan broj.");
                } catch (NumberFormatException e){
                    System.out.println("Neispravan unos, unesite broj.");
                }
            }

            boolean imaPrikolicu = false;
            while(true){
                System.out.print("Ima li prikolicu? (da/ne): ");
                String odgovor = scanner.nextLine().trim().toLowerCase();
                if(odgovor.equals("da")){
                    imaPrikolicu = true;
                    break;
                } else if(odgovor.equals("ne")) {
                    imaPrikolicu = false;
                    break;
                } else{
                    System.out.println("Molimo unesite 'da' ili 'ne'.");
                }
            }
            return new Kamion(godina, proizvodjac, registracija, nosivost, imaPrikolicu);
        }

        private static int unosCijelogBroja(Scanner scanner, String poruka, int min, int max){
            int broj;
            while(true){
                System.out.print(poruka);
                String unos = scanner.nextLine().trim();
                try{
                    broj = Integer.parseInt(unos);
                    if(broj >= min && broj <= max) break;
                    else System.out.println("Broj mora biti između " + min + " i " + max + ".");
                } catch (NumberFormatException e){
                    System.out.println("Molimo unesite ispravan cijeli broj.");
                }

            }
            return broj;
        }

        private static void spremiVozilaUDatoteku(List<Vozilo> vozila, String autiKamioni){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(autiKamioni))){
                for(Vozilo v : vozila){
                    if(v instanceof Automobil){
                        Automobil a = (Automobil) v;
                        bw.write("A," + a.godinaProizvodnje + "," + a.proizvodjac + "," + a.registracija + "," + a.brojVrata + "," + a.tipGoriva);
                    } else if(v instanceof Kamion){
                        Kamion k = (Kamion) v;
                        bw.write("K," + k.godinaProizvodnje + "," + k.proizvodjac + "," + k.registracija + "," + k.nosivost + "," + k.imaPrikolicu);
                    }
                    bw.newLine();
                }
                System.out.println("Podaci o vozilima su spremljeni.");
            } catch (IOException e){
                System.out.println("Pogreska kod spremanja: " + e.getMessage());
            }
        }

}