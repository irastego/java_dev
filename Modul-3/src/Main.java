import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  broj = -1;

        try{
            System.out.println("Unesi cijeli broj:");
            broj = scanner.nextInt();

            if(broj < 0 ){
                throw new IllegalArgumentException("Faktorijel nije definiran za negativne brojeve");
            }

            long faktorijel = izracunajFaktorijel(broj);
            System.out.println("Faktorijel broja " + broj + " je: " + faktorijel);

        } catch (InputMismatchException e){
            System.out.println("Greska. Unesite cijeli broj");
        } catch (IllegalArgumentException e){
            System.out.println("Greska: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Dogodila se neocekivana greska: " + e.getMessage());
        } finally {
            System.out.println("Program je zavrsen");
        }
    }

    public static long izracunajFaktorijel(int n){
        long rezultat = 1;
        for (int i = 2; i <= n; i++) {
            rezultat *= i;
        }
        return rezultat;
    }

}