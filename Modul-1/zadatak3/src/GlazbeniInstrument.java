import java.math.BigDecimal;

public abstract class GlazbeniInstrument {
    private String naziv;
    private BigDecimal cijena;

    public GlazbeniInstrument(String naziv, BigDecimal cijena) {
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

}
