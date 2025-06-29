public class Trokut extends GeometrijskiLik {
    private double a;
    private double b;
    private double c;

    public Trokut(double a, double b, double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isValid() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    @Override
    public String getNaziv() {
        return "Trokut";
    }

    @Override
    public double getPovrsina() {
        if (!isValid()) {
            System.out.println("Neispravan trokut s danim stranicama!");
            return 0;
        }
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getOpseg() {
        return a + b + c;
    }
}
