import java.math.BigDecimal;

public class Klavir extends GlazbeniInstrument{
    private String naziv;
    private BigDecimal cijena;

    public Klavir(String naziv, BigDecimal cijena) {
        super(naziv, cijena);
    }
}
