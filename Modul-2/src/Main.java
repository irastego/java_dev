import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ucilica ucilica = new Ucilica();
        Scanner scanner = new Scanner(System.in);

        String nastavak = "";

        do{
            System.out.println("Unesi geometrijski oblik:");
            String input = scanner.nextLine();

            switch (input){
                case "Krug":
                    System.out.println("Unesite radijus:");
                    double radijus = scanner.nextDouble();
                    scanner.nextLine();
                    Krug krug = new Krug(radijus);
                    ucilica.add(krug);
                    break;

                case "Trokut":
                    System.out.println("Unesite stranicu A:");
                    double stranicaA = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Unesite stranicu B:");
                    double stranicaB = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Unesite stranicu C:");
                    double stranicaC = scanner.nextDouble();
                    scanner.nextLine();
                    Trokut trokut = new Trokut(stranicaA, stranicaB, stranicaC);
                    ucilica.add(trokut);
                    break;

                case "Pravokutnik":
                    System.out.println("Unesite stranicu A:");
                    double a = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Unesite stranicu B:");
                    double b = scanner.nextDouble();
                    scanner.nextLine();
                    Pravokutnik pravokutnik = new Pravokutnik(a, b);
                    ucilica.add(pravokutnik);
                    break;
                default:
                    System.out.println("Nemam taj lik. Mozete li probati opet?");
                continue;
            }

            System.out.println("Da li zelite ispis geometrijskih likova (Y/n)");
            String ispis = scanner.nextLine();

            if(!ispis.equalsIgnoreCase("n")){
                ucilica.sort();
                System.out.println(ucilica.get());
            }

            System.out.println("Da li zelite nastaviti?");
            nastavak = scanner.nextLine();
            nastavak = nastavak.toLowerCase();
        } while(!nastavak.equals("n"));
    }
}