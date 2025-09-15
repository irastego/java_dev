public class Automobil extends Vozilo{
    int brojVrata;
    String tipGoriva;

    public Automobil(int godinaProizvodnje, String proizvodjac, String registracija, int brojVrata, String tipGoriva) {
        super(godinaProizvodnje, proizvodjac, registracija);
        this.brojVrata = brojVrata;
        this.tipGoriva = tipGoriva;
    }

    @Override
    public int izracunajStarost() {
        int trenutnaGodina = java.time.Year.now().getValue();
        return trenutnaGodina - godinaProizvodnje;
    }


    @Override
    public String toString() {
        return "Automobil: " + registracija + ", " + proizvodjac + ", " + godinaProizvodnje +
                ", broj vrata: " + brojVrata +
                ", tip goriva: " + tipGoriva;
    }


}
