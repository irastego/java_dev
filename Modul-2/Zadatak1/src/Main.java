import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Putanja do orginalne datoteke: ");
        String sourcePath = scanner.nextLine();

        System.out.println("Putanja do destinacijske datoteke: ");
        String destinationPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        if(sourceFile.exists()){
            System.out.println("Datoteka ne postoji.");
            return;
        }

       File file = new File(destinationPath);

       if(file.exists()){

           System.out.println("Zelite li obrisati postojecu datoteku? (Y/n)");
           String answer = scanner.nextLine();

           if(!answer.equalsIgnoreCase("n")){
               boolean deleted = file.delete();
               if(deleted){
                   System.out.println("Datoteka je obrisana.");
               } else {
                   System.out.println("Datoteka nije obrisana.");
               }
           }
       }
       copy(sourcePath, destinationPath);

    }

    public static void copy(String source, String destination){
        try(FileInputStream FileInputStream = new FileInputStream(source);
        FileOutputStream FileOutputStream = new FileOutputStream(destination)){

            byte[] buffer = new byte[1024];
            int total;

            while((total = FileInputStream.read(buffer)) != -1) {
                FileOutputStream.write(buffer, 0, total);
            }
        } catch(Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}