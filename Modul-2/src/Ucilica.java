import java.util.ArrayList;
import java.util.Collections;

public class Ucilica {
    private ArrayList<GeometrijskiLik> geometrijskiLikovi;

    public Ucilica() {
        this.geometrijskiLikovi = new ArrayList<>();
    }

    public void add(GeometrijskiLik lik){
        geometrijskiLikovi.add(lik);
    }

    public void sort(){
        Collections.sort(geometrijskiLikovi);
    }

    public String get() {
        StringBuilder sb = new StringBuilder();
        for (GeometrijskiLik lik : geometrijskiLikovi) {
            sb.append(lik.getNaziv())
                    .append(" Povrsina: ")
                    .append(lik.getPovrsina())
                    .append(" Opseg: ")
                    .append(lik.getOpseg())
                    .append("\n");
        }
        return sb.toString();
    }
}
