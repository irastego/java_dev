import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite tekst:" );
        String tekst_ivan = scanner.nextLine();

        String[] rijeci = tekst_ivan.split(" ");
        System.out.println("Ukupan broj rijeci: " + rijeci.length);

        System.out.println("Palindromske rijeci: " + dohvatiSvePalindrome(rijeci));
    }

    public static String dohvatiSvePalindrome(String[] rijeci){
        StringBuilder palindromSb = new StringBuilder();
        for (String rijec: rijeci) {
            if (daLiJePalindrom(rijec)){
                palindromSb.append(rijec).append(" ");
            };
        }

        return palindromSb.toString();
    }

    public static boolean daLiJePalindrom(String rijec){
        if (rijec.length() <= 1){
            return true;
        }

        int brojSlova = rijec.length();
        boolean paran = brojSlova % 2 == 0;

        int indexPolovice = brojSlova / 2;

        StringBuilder prviDio = new StringBuilder();

        for(int i = 0; i < indexPolovice; i++){
            prviDio.append(rijec.charAt(i));
        }

        StringBuilder drugiDio = new StringBuilder();

        if (!paran){
            indexPolovice = indexPolovice+1;
        }

        for (int i = indexPolovice; i < rijec.length(); i++){
            drugiDio.append(rijec.charAt(i));
        }

        String drugi = drugiDio.reverse().toString();

        return prviDio.toString().equalsIgnoreCase(drugi);
    }
}