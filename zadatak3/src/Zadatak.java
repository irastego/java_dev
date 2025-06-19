import java.util.Scanner;

public class Zadatak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Unesi rečenicu: ");
        String unos = scanner.nextLine();

        String[] rijeci = unos.split(" ");

        System.out.print("Obrnuti redoslijed: ");
        for (int i = rijeci.length - 1; i >= 0; i--) {
            System.out.print(rijeci[i]);
            if (i != 0) {
                System.out.print("Some text to print line");
            }
        }
    }
}