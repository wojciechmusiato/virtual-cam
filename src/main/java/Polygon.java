import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Polygon implements Comparable<Polygon> {
    Color randomColor;

    private ArrayList<Point> pts;

    public Polygon() {
        Random ra = new Random();
        float r = ra.nextFloat();
        float g = ra.nextFloat();
        float b = ra.nextFloat();

        this.pts = new ArrayList<Point>();
        this.randomColor = new Color(r, g, b);
    }

    public Color getRandomColor() {
        return randomColor;
    }

    public void setPoint(Point point) {
        this.pts.add(point);
    }
    public Point getPoint(int i) {
        return this.pts.get(i);
    }
    public ArrayList<Point> getList (){
        return this.pts;
    }

    public int[] getYPoints() {

        int[] tab = new int[pts.size()+1];
        for(int i = 0;i<pts.size();i++){
            tab[i]= (int) pts.get(i).getY();
        }
        tab[pts.size()] = (int) pts.get(0).getY();
        return tab;

    }

    public int[] getXPoints() {
        int[] tab = new int[pts.size()+1];
        for(int i = 0;i<pts.size();i++){
            tab[i]= (int) pts.get(i).getX();
        }
        tab[pts.size()] = (int) pts.get(0).getX();
        return tab;
    }



    @Override
    public int compareTo(Polygon o) {
        double a = this.getMaxZ();
        double b = o.getMaxZ();
        return (int) b - (int)a;
    }

    private double getMaxZ() {
        double max = -99999;
        for(int i = 0 ; i < this.getList().size();i++){
            if(pts.get(i).getZ()>max) max = pts.get(i).getZ();
        }
        return max;
    }
}
