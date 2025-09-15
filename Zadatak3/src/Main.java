import java.io.*;
import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> listaStudenata = new ArrayList<>();

    public static void main(String[] args) {
        unosStudenata();

        boolean running = true;
        while(running){
            System.out.println("\n===== MENI =====");
            System.out.println("1 - Uredi studenta");
            System.out.println("2 - Izbriši studenta");
            System.out.println("3 - Sortiraj studente");
            System.out.println("4 - Ispis svih studenata");
            System.out.println("5 - Spremi u datoteku");
            System.out.println("0 - Izlaz");
            System.out.print("Odaberite opciju: ");

            String izbor = scanner.nextLine();

            switch (izbor){
                case "1":
                    urediStudenta();
                    break;
                case "2":
                    izbrisiStudenta();
                    break;
                case "3":
                    sortirajStudente();
                    break;
                case "4":
                    ispisiStudente();
                    break;
                case "5":
                    spremiUDatoteku();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Nepoznata opcija!");
            }
        }
        scanner.close();
    }

    private static void unosStudenata(){
        System.out.print("Unesite broj studenata: ");
        int brojStudenata =  scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < brojStudenata; i++ ){
            System.out.println("Unos studenta " + (i + 1) + ":");

            String ime;
            do{
                System.out.print("Unesite ime: ");
                ime = scanner.nextLine().trim();
                if(ime.isEmpty()){
                    System.out.print("Greska! Ime ne smije biti prazno.");
                }
            } while(ime.isEmpty());

            String prezime;
            do{
                System.out.print("Unesite prezime: ");
                prezime = scanner.nextLine().trim();
                if(prezime.isEmpty()){
                    System.out.print("Greska! Prezime ne smije biti prazno.");
                }
            } while(prezime.isEmpty());

            String brojIndeksa;
            do{
                System.out.print("Unesite broj indeksa: ");
                brojIndeksa = scanner.nextLine().trim();
                if(!brojIndeksa.matches("\\d+")){
                    System.out.print("Greska! Broj indeksa smije sadrzavati samo brojeve!");
                    brojIndeksa = "";
                }
            } while(brojIndeksa.isEmpty());

            double prosjek = 0;
            boolean validProsjek = false;
            while(!validProsjek){
                System.out.print("Unesite prosjek: ");
                try{
                    prosjek = Double.parseDouble(scanner.nextLine().trim());
                    if(prosjek >= 2.0 && prosjek <= 5.0){
                        validProsjek = true;
                    }
                    else {
                        System.out.print("Greska! Prosjek mora biti izmedu 2.0 i 5.0.");
                    }
                } catch(NumberFormatException e){
                    System.out.print("Greska! Unesite broj (npr 4.5).");
                }
            }

            System.out.print("\nUnijeli ste: ");
            System.out.print(ime + " " + prezime + " (br.indeksa: " + brojIndeksa + "), prosjek: " + prosjek);

            listaStudenata.add(new Student(ime, prezime, brojIndeksa, prosjek));
        }
    }

    private static void ispisiStudente(){
        if(listaStudenata.isEmpty()){
            System.out.println("Nema studenata.");
            return;
        }
        System.out.println("\nLista studenata: ");{
            for(int i=0; i < listaStudenata.size(); i++){
                System.out.println((i + 1) + ". " + listaStudenata.get(i));
            }
        }
    }

    public static void urediStudenta(){
        ispisiStudente();
        System.out.println("Odaberite broj studenata za uredivanje: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index < 0 || index >= listaStudenata.size()) {
            System.out.println("Pogrešan odabir!");
            return;
        }

        Student s = listaStudenata.get(index);

        System.out.println("Novo ime (" + s.getIme() + "): ");
        String novoIme = scanner.nextLine().trim();
        if(!novoIme.isEmpty()) s.setIme(novoIme);

        System.out.println("Novo prezime (" + s.getPrezime() + "): ");
        String novoPrezime = scanner.nextLine().trim();
        if(!novoPrezime.isEmpty()) s.setPrezime(novoPrezime);

        System.out.println("Novi broj indeksa (" + s.getBrojIndeksa() + "): ");
        String noviIndeks = scanner.nextLine().trim();
        if (!noviIndeks.isEmpty() && noviIndeks.matches("\\d+")) s.setBrojIndeksa(noviIndeks);

        System.out.println("Novi prosjek (" + s.getProsjek() + "): ");
        String noviProsjekInput = scanner.nextLine().trim();
        if(!noviProsjekInput.isEmpty()){
            try{
                double noviProsjek = Double.parseDouble(noviProsjekInput);
                s.setProsjek(noviProsjek);
            } catch (NumberFormatException e){
                System.out.println("Prosjek nije promijenjen (krivi format).");
            }
        } s.setIme(noviProsjekInput);

    }

    private static void izbrisiStudenta(){
        ispisiStudente();
        System.out.print("Unesite broj studenta za brisanje: ");
        int index = Integer.parseInt((scanner.nextLine())) - 1;
        if(index < 0 || index >= listaStudenata.size()){
            System.out.println("Pogresan odabir!");
            return;
        }
        listaStudenata.remove(index);
        System.out.println("Stundent obrisan.");
    }

    private static void sortirajStudente(){
        System.out.println("Sortiraj po:");
        System.out.println("1 - Ime");
        System.out.println("2 - Prezime");
        System.out.println("3 - Prosjek");
        String izbor = scanner.nextLine();

        switch(izbor){
            case "1":
                listaStudenata.sort(Comparator.comparing(Student::getIme));
                break;
            case "2":
                listaStudenata.sort(Comparator.comparing(Student::getPrezime));
                break;
            case "3":
                listaStudenata.sort(Comparator.comparing(Student::getProsjek).reversed());
                break;
            default:
                System.out.println("Nepoznata opcija.");
        }
        System.out.println("Sortiranje zavrseno.");
    }

    private static void spremiUDatoteku(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("studenti.txt"))){
            for (Student student : listaStudenata){
                bw.write(student.toString());
                bw.newLine();
            }
            System.out.println("Podaci su spremljeni u 'studenti.txt'.");
        } catch (IOException e){
            System.out.println("Greska kod spremanja: " + e.getMessage());
        }
    }

/*    try(BufferedWriter bw = new BufferedWriter(new FileWriter("studenti.txt"))){
        for(Student student: listaStudenata){
            bw.write((student.toString()));
            bw.newLine();
        }
        System.out.println("\nPodaci zapisani u 'studenti.txt'.");
    } catch (IOException e){
        System.out.println("Dogodila se greska kod pisanja u datoteku " + e.getMessage());
    }

        System.out.println("\nSvi studenti (iz datoteke): ");
        try(BufferedReader br = new BufferedReader(new FileReader("studenti.txt"))){
        String linija;
        while((linija = br.readLine()) != null){
            System.out.println(linija);
        }
    } catch (IOException e){
        System.out.println("Dogodila se greska kod citanja iz datoteke: " + e.getMessage());
    }
        scanner.close();*/
}