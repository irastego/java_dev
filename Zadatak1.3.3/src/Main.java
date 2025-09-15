import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite temperaturu u Celzijusima: ");
        double tempCelz = scanner.nextDouble();
        scanner.close();

        double tempFah = (tempCelz * 9/5) + 32;
        System.out.println("Temperatura u Faherneitima: " + tempFah);

        double tempKel = tempCelz + 273.15;
        System.out.println("Temperatura u Kelvinima: " + tempKel);
    }
}