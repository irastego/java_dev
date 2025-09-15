import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Unesite velicinu matrice: ");
        int unos = scanner.nextInt();
        scanner.close();

        int[][] matrica = new int [unos][unos];

        for(int i = 0; i < unos; i++){
            for(int j = 0; j < unos; j++){
                matrica[i][j] = j + 1;
            }
        }

        System.out.println("\nPopunjavanje matrice " + unos + "x" + unos + ":");

        for(int i = 0; i < unos; i++){
            for(int j = 0; j < unos; j++){
                matrica[i][j] = j + 1;
                System.out.print(matrica[i][j] + " ");
            }
            System.out.println();
        }
    }
}