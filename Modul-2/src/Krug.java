public class Krug extends GeometrijskiLik {
    private double radijus;

    public Krug(double radijus) {
        super();
        this.radijus = radijus;
    }

    @Override
    public String getNaziv() {
        return "Krug";
    }

    @Override
    public double getPovrsina() {
        return Math.PI * (radijus * radijus);
    }

    @Override
    public double getOpseg() {
        return 2 * radijus * Math.PI;
    }
}
