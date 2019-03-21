import java.awt.*;
import java.util.ArrayList;

public class Polygon  {
    private ArrayList<Vector> vec;

    public Polygon() {
        this.vec = new ArrayList<Vector>();
    }

    public void setVector(Vector vector) {
        this.vec.add(vector);
    }
    public Vector getVector(int i) {
        return this.vec.get(i);
    }
}
