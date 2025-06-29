import java.math.BigDecimal;

public class Violoncelo extends GlazbeniInstrument{
    private String naziv;
    private BigDecimal cijena;

    public Violoncelo(String naziv, BigDecimal cijena) {
        super(naziv, cijena);
    }
}
