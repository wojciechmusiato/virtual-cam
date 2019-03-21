import org.apache.commons.math3.linear.RealMatrix;

public class Vector {
    private Point a;
    private Point b;

    public Vector(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }
    public void setA(RealMatrix m) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "a=" + a.toString() +
                ", b=" + b.toString() +
                '}';
    }
}
