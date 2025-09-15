public class Polaznik {
    private String ime;
    private String prezime;
    private String email;

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email.toLowerCase();
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Polaznik)) return false;
        Polaznik other = (Polaznik) obj;
        return email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " (" + email + ")";
    }
}
