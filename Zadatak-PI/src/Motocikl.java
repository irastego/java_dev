public class Motocikl extends Vozilo{
    private String tipMotora;

    public Motocikl(String registarskiBroj, String marka, int godinaProizvodnje, String tipMotora) throws NeispravniPodaciException {
        super(registarskiBroj, marka, godinaProizvodnje);

        if(tipMotora == null || tipMotora.trim().isEmpty()) {
            throw new NeispravniPodaciException("Tip motora ne smije biti prazan string.");
        }
        this.tipMotora = tipMotora;
    }

    public String getTipMotora() {
        return tipMotora;
    }

    public void setTipMotora(String tipMotora) throws NeispravniPodaciException {
        if(tipMotora == null || tipMotora.trim().isEmpty()) {
            throw new NeispravniPodaciException("Tip motora ne smije biti prazan string.");
        }
        this.tipMotora = tipMotora;
    }

    @Override
    public void prikaziPodatke() {
        super.prikaziPodatke();
        System.out.println("Tip motora: " + this.tipMotora);
    }

    @Override
    public String zaDatoteku() {
        return "Motocikl," + super.zaDatoteku() + "," + getTipMotora();
    }
}
