import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unesite duljinu niza:");

        Scanner scanner = new Scanner(System.in);

        int duljinaNiza = scanner.nextInt();

        System.out.println("Unesite " + duljinaNiza + " cijelih brojeva: ");

        int[] brojevi = new int[duljinaNiza];

        for(int i = 0; i < duljinaNiza; i++){
            brojevi[i] = scanner.nextInt();
        }
        scanner.close();

        int najveci = brojevi[0];
        int najmanji = brojevi[0];

        for(int i = 0; i < brojevi.length; i++){
            if(najveci < brojevi[i]){
                najveci = brojevi[i];
            }

            if(najmanji > brojevi[i]){
                najmanji = brojevi[i];
            }
        }

        System.out.println("Najveci broj u nizu je: " + najveci);
        System.out.println("Najmanji broj u nizu je: " + najmanji);

        // [15, 43, 23, 45, -32]
    }
}