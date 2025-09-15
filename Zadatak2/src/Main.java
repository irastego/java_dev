import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite broj za tablicu mnozenja: ");
        int broj = scanner.nextInt();
        scanner.close();

        System.out.println("Tablica mnozenja do " + broj + ":");
        System.out.println("----------------------------------");

        for(int i = 1; i <= broj; i++){
            for(int j = 1; j <= broj; j++){
                int umnozak = i * j;
                System.out.println(i + "*" + j + " = " + umnozak);
            }
        }
        System.out.println("-----------------");
    }
}