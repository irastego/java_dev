import java.math.BigDecimal;

public class Gitara extends GlazbeniInstrument {
    private String naziv;
    private BigDecimal cijena;

    public Gitara(String naziv, BigDecimal cijena) {
        super(naziv, cijena);
    }
}
