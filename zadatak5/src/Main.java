import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> imena = new ArrayList<>();

        for(int i=0; i<5; i++){
            System.out.println("Unesite ime " + (i + 1) + ": ");
            String ime = scanner.nextLine();
            imena.add(ime);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("imena.txt"))){
            for(String ime : imena){
                bw.write(ime);
                bw.newLine();
            }
            System.out.println("Podaci su spremljeni");
        } catch (IOException e){
            System.out.println("Greska kod spremanja: " + e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader("imena.txt"))){
            String linija;
            while((linija = br.readLine()) != null){
                System.out.println("Procitano ime: " + linija
                );
            }
        } catch (IOException e){
            System.out.println("Greska kod citanja: " + e.getMessage());
        }

    }
}