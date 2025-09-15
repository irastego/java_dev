public class Student {
    private String ime;
    private String prezime;
    private String brojIndeksa;
    private double prosjek;

    public Student(String ime, String prezime, String brojIndeksa, double prosjek) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndeksa = brojIndeksa;
        this.prosjek = prosjek;
    }

    public double getProsjek() {
        return prosjek;
    }

    public void setProsjek(double prosjek) {
        if(prosjek >= 2.0 && prosjek <= 5.0){
            this.prosjek = prosjek;
        } else {
            System.out.println("Greška: prosjek mora biti između 2.0 i 5.0");
        }
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString(){
        return ime + " " + prezime + ", " + "(br.indeksa: " + brojIndeksa + "), prosjek: " + prosjek;
    }
}
