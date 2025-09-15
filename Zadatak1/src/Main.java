import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Koliko ocjena zelite unijeti?");
        int brojOcjena = scanner.nextInt();

        int[] ocjene = new int[brojOcjena];

        for(int i = 0; i < brojOcjena; i++){
            System.out.println("Unesite " + (i + 1) + ". ocjenu: ");
            ocjene[i] = scanner.nextInt();
        }
            scanner.close();

        System.out.println("Broj unesenih ocjena: " + brojOcjena);

        int zbrojOcjena = 0;

        for(int i = 0; i < ocjene.length; i++){
            zbrojOcjena = zbrojOcjena + ocjene[i];
        }
        System.out.println("Zbroj unesenih ocjena: " + zbrojOcjena);

        double prosjek = (double) zbrojOcjena / brojOcjena;
        System.out.println("Prosjek ocjena je: " + prosjek);

        int brojIznadProsjecnihOcjena = 0;

        for(int trenutnaOcjena : ocjene){
            if(trenutnaOcjena > prosjek){
                brojIznadProsjecnihOcjena++;
            }
        }
        System.out.println("Broj iznadprosjecnih ocjena: " + brojIznadProsjecnihOcjena);
    }
}