import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File destination = new File("destination.txt");
        File source = new File("source.txt");

        System.out.println("Directory: " + System.getProperty("user.dir"));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter((destination)));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {

            int character = bufferedReader.read();
            while(character != -1){
                bufferedWriter.write(character);
            }

        } catch (Exception e) {
            System.out.println("Desio se neki exeption");
        }

        System.out.println();
    }
}