public class Automobil extends Vozilo{
    private int brojVrata;

    public Automobil(String registarskiBroj, String marka, int godinaProizvodnje, int brojVrata) throws NeispravniPodaciException {
        super(registarskiBroj, marka, godinaProizvodnje);
        if(brojVrata < 1 || brojVrata > 7){
            throw new NeispravniPodaciException("Unesi ispravan broj vrata.");
        }
        this.brojVrata = brojVrata;
    }

    public int getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(int brojVrata) throws NeispravniPodaciException {
        if (brojVrata < 1 || brojVrata > 7) {
            throw new NeispravniPodaciException("Broj vrata mora biti između 1 i 7.");
        }
        this.brojVrata = brojVrata;
    }

    @Override
    public void  prikaziPodatke(){
        super.prikaziPodatke();
        System.out.println("Broj vrata: " + this.brojVrata);
    }

    @Override
    public String zaDatoteku() {
        return "Automobil," + super.zaDatoteku() + "," + getBrojVrata();
    }
}
