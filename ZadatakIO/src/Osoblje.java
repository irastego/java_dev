import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Osoblje {

    private List<Osoba> osobe;
    private final String DELIMITER = "\\|";
    private final String NOVI_RED = "\n";

    public Osoblje(){
        this.osobe = new ArrayList<>();
    }

    public void dodaj(Osoba osoba){
        this.osobe.add(osoba);
    }

    public void isOibValidan(String oib) throws OibVecPostojiException{
        for(Osoba osoba : osobe){
            if(osoba.getOib() != null && osoba.getOib().equals(oib)){
                throw new OibVecPostojiException();
            }
        }
    }

    public void ucitajIzDatoteke(String putanjaDoDatoteke) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(putanjaDoDatoteke))){
            String redak;
            while((redak = br.readLine()) != null){
                if(redak.trim().isEmpty()) continue;

                String[] stupci = redak.split(DELIMITER);

                String titula = stupci[0];
                String ime = stupci[1];
                String prezime = stupci[2];
                String oib = stupci[3];

                try{
                    isOibValidan(oib);

                    if(titula.equalsIgnoreCase("Student")){
                        this.osobe.add(new Student(ime, prezime, titula, oib));
                    } else if (titula.equalsIgnoreCase("Profesor")){
                        this.osobe.add(new Profesor(ime, prezime, titula, oib));
                    }

                } catch (OibVecPostojiException e){
                    System.out.println("Dogodila se pogreška! Osoba s OIB-om " + " vec postoji.");
                }
                }

            }
    }

    public String ispisi(){
        int brojProfesora = 0;
        int brojStudenata = 0;

        StringBuilder sbProfesori = new StringBuilder();
        StringBuilder sbStudenti = new StringBuilder();
        StringBuilder ispis = new StringBuilder();
        for(Osoba osoba : osobe){
            if(osoba instanceof Profesor){
                brojProfesora++;
                sbProfesori.append(osoba.getPunoIme()).append(NOVI_RED);
            } else if (osoba instanceof Student){
                brojStudenata++;
                sbStudenti.append(osoba.getPunoIme()).append(NOVI_RED);
            }
        }

        ispis.append("Profesori(").append(brojProfesora).append("):\n");
        ispis.append(NOVI_RED);
        ispis.append(sbProfesori);
        ispis.append(NOVI_RED);
        ispis.append("Studenti (").append(brojStudenata).append("):\n");
        ispis.append(NOVI_RED);
        ispis.append(sbStudenti);

        return ispis.toString();
    }

}
