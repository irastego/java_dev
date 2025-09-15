import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite duljinu pravokutnika: ");
        double duljina = scanner.nextDouble();

        System.out.println("Unesite sirinu pravokutnika: ");
        double sirina = scanner.nextDouble();
        scanner.close();

        if(duljina > 0  && sirina > 0){
            double povrsina = duljina * sirina;
            System.out.println("Povrsina pravokutnika je: " + povrsina);
        } else {
            System.out.println("Greska! Duljina i sirina moraju biti pozitivni brojevi.");
        }
    }
}