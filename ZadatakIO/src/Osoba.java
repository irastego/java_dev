public abstract class Osoba {
    private String ime;
    private String prezime;
    private String titula;
    private String oib;

    public Osoba(String ime, String prezime, String titula, String oib) {
        this.ime = ime;
        this.prezime = prezime;
        this.titula = titula;
        this.oib = oib;
    }

    public String getOib() {
        return oib;
    }

    public String getPunoIme(){
        return ime + " " + prezime;
    }
}
