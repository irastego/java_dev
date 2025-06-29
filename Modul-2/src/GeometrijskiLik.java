public abstract class GeometrijskiLik implements Comparable<GeometrijskiLik> {

    public abstract String getNaziv();
    public abstract double getPovrsina();
    public abstract double getOpseg();

    public int compareTo(GeometrijskiLik drugi) {
        return Double.compare(this.getPovrsina(), drugi.getPovrsina());
    }
}
