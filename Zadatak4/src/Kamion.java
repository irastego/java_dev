public class Kamion extends Vozilo{
   double nosivost;
   boolean imaPrikolicu;

    public Kamion(int godinaProizvodnje, String proizvodjac, String registracija, double nosivost, boolean imaPrikolicu) {
        super(godinaProizvodnje, proizvodjac, registracija);
        this.nosivost = nosivost;
        this.imaPrikolicu = imaPrikolicu;
    }

    @Override
    public int izracunajStarost() {
        return java.time.Year.now().getValue() - this.godinaProizvodnje;
    }

    @Override
    public String toString() {
        return "Kamion: " + registracija + ", " + proizvodjac + ", " + godinaProizvodnje +
                ", nosivost: " + nosivost + "t" +
                ", ima prikolicu: " + (imaPrikolicu ? "DA" : "NE");
    }


}
