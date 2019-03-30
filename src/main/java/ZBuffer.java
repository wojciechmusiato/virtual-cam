import java.awt.*;
import java.util.Random;

public class ZBuffer {
    public Operations operations;
    public double [][] zdepth;
    public Color [][]  colormap;

    public ZBuffer() {
        zdepth = new double[639][602];
        colormap = new Color[639][602];
    }

    public void czarymary(MyPolygon p, int index) {

        int i,j;
        Random r = new Random();
        int rand = r.nextInt(255);
        //Color color = new Color(rand,rand,rand);
        MyPolygon orig = operations.polygons.get(index);
        Polygon poly = new Polygon(p.getXPoints(), p.getYPoints(), p.getList().size());
        double  x1, y1, z1,
                x2, y2, z2,
                x3, y3, z3,
                a, b, c, d;
        x1 = orig.getList().get(1).getX();
        y1 = orig.getList().get(1).getY();
        z1 = orig.getList().get(1).getZ();
        x2 = orig.getList().get(0).getX();
        y2 = orig.getList().get(0).getY();
        z2 = orig.getList().get(0).getZ();
        x3 = orig.getList().get(2).getX();
        y3 = orig.getList().get(2).getY();
        z3 = orig.getList().get(2).getZ();
        double a1 = x2 - x1;
        double b1 = y2 - y1;
        double c1 = z2 - z1;
        double a2 = x3 - x1;
        double b2 = y3 - y1;
        double c2 = z3 - z1;
        a = b1 * c2 - b2 * c1;
        b = a2 * c1 - a1 * c2;
        c = a1 * b2 - b1 * a2;
        d = (-a * x1 - b * y1 - c * z1);

        for ( i = (int) p.getMinX(); i < (int) p.getMaxX(); i++) {
            for ( j = (int) p.getMinY(); j < (int) p.getMaxY(); j++) {
                if (poly.contains(i, j)) {
                    double x=i;
                    double y=j;
                    x = (x-Operations.sceneWidth/2)/Operations.focal;
                    y = (y-Operations.sceneHeight/2)/Operations.focal*(-1);
                    double gowno = a/d * x + b/d *  y + c/d;
                    double z = 1/gowno;
                    if((i>0&&j>0 && i<639&&j<602)) {
                        if (zdepth[i][j] < z ) {
                            zdepth[i][j] = z;
                            colormap[i][j] = orig.randomColor;
                        }
                    }
                }
            }
        }
    }
}

