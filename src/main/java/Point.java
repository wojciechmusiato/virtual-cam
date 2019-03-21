import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Point {
    private double x;
    private double y;
    private double z;
    private double d;
    private RealMatrix m;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = 1;
        double[][] matrix = {{x}, {y}, {z}, {d}};
        m = new Array2DRowRealMatrix(matrix);

    }

    public Point(RealMatrix m) {
        this.x = m.getEntry(0, 0);
        this.y = m.getEntry(1, 0);
        this.z = m.getEntry(2, 0);
        this.d = 1;
        this.m = m;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public RealMatrix getM() {
        return m;
    }

    public void setM(RealMatrix m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", d=" + d +
                '}';
    }

}
