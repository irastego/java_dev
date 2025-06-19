import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesi tekst:");
        String input = sc.nextLine();

        zadatak1(input);
    }

    public static void zadatak1(String tekst) {
        int counterLetters = 0;
        int counterNumbers = 0;
        int counterRest = 0;

        for(int i = 0; i < tekst.length(); i++){
            char znak = tekst.charAt(i);
            if(Character.isDigit(znak)){
                counterNumbers++;
            } else if (Character.isLetter(znak)){
                counterRest++;
            } else{
                counterRest++;
            }

        }
        System.out.println("Slova: " + counterLetters);
        System.out.println("Brojevi: " + counterNumbers);
        System.out.println("Ostalo: " + counterRest);
    }
}