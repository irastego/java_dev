public class Pravokutnik extends GeometrijskiLik{
    private double a;
    private double b;

    public Pravokutnik(double a, double b) {
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public String getNaziv() {
        return "Pravokutnik";
    }

    @Override
    public double getPovrsina() {
        return a * b;
    }

    @Override
    public double getOpseg() {
        return 2 * a + 2 * b;
    }
}
