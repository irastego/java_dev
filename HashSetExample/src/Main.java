import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> kolicinaVoca = new HashMap<>();

        kolicinaVoca.put("Ananas", 17);
        kolicinaVoca.put("Jabuka", 47);
        kolicinaVoca.put("Banana", 24);

        System.out.println("Upisi voce za koje te zanima");
        Scanner sc = new Scanner(System.in);

        String naziv = sc.nextLine();

        if(kolicinaVoca.containsKey(naziv)){
            Integer kolicina = kolicinaVoca.get(naziv);
            System.out.println("Imam " + kolicina.toString() + " " + naziv + ". Wanna buy?");
        } else {
            System.out.println("Nemam to voce. ");
        }
    }
}