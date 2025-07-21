public class Vozilo {
    private String registarskiBroj;
    private String marka;
    private int godinaProizvodnje;


    public Vozilo(String registarskiBroj, String marka, int godinaProizvodnje) throws NeispravniPodaciException {
        if(godinaProizvodnje < 1933){
            throw new NeispravniPodaciException("Godina proizvodnje ne moze biti manja od 1933.");
        }

        this.registarskiBroj = registarskiBroj;
        this.marka = marka;
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public String getRegistarskiBroj() {
        return registarskiBroj;
    }

    public void setRegistarskiBroj(String registarskiBroj) {
        this.registarskiBroj = registarskiBroj;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) throws NeispravniPodaciException {
        if(godinaProizvodnje < 1933){
            throw new NeispravniPodaciException("Godina proizvodnje ne moze biti manja od 1933.");
        }
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public void prikaziPodatke(){
        System.out.println("Registarski broj: " + this.registarskiBroj);
        System.out.println("Marka: " + this.marka);
        System.out.println("Godina proizvodnje: " + this.godinaProizvodnje);
    }

    public String zaDatoteku() {
        return registarskiBroj + "," + marka + "," + godinaProizvodnje;
    }
}
