import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

//    Napiši program koji za korisnički unos brojeva sprema sve unose u HashSet.
//    Na kraju ispiši sve unikatne brojeve u rastućem redoslijedu.
//    Ako broj već postoji, ispiši poruku da je već unesen.
//

    public static void main(String[] args) {
        Set<Integer> brojevi = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Unesi broj ili 'kraj' za izlaz: ");
            String unos = scanner.nextLine();

            if(unos.equalsIgnoreCase("kraj")){
                break;
            }

            try{
                int broj = Integer.parseInt(unos);
                if(brojevi.contains(broj)){
                    System.out.println("Broj " + broj + " je vec unesen!");
                } else{
                    brojevi.add(broj);
                    System.out.println("Broj dodan.");
                }

            } catch (NumberFormatException e){
                System.out.println("Neispravan unos. Pokusaj ponovno.");
            }
        }

        Set<Integer> sortirani = new TreeSet<>(brojevi);
        System.out.println("\nUnikatni brojevi u rastućem redoslijedu:");
        for(int broj : sortirani){
            System.out.println(broj);
        }
    }
}