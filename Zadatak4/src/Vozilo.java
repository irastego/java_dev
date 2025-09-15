public abstract class Vozilo {
    String registracija;
    String proizvodjac;
    int godinaProizvodnje;

    public Vozilo(int godinaProizvodnje, String proizvodjac, String registracija) {
        this.godinaProizvodnje = godinaProizvodnje;
        this.proizvodjac = proizvodjac;
        this.registracija = registracija;
    }


    public abstract int izracunajStarost();

}
