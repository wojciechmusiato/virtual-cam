import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class MyPolygon implements Comparable<MyPolygon> {
    Color randomColor;
    private ArrayList<Point> pts;

    public MyPolygon() {
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
        if(!pts.isEmpty())
            tab[pts.size()] = (int) pts.get(0).getY();
        return tab;

    }

    public int[] getXPoints() {
        int[] tab = new int[pts.size()+1];
        for(int i = 0;i<pts.size();i++){
            tab[i]= (int) pts.get(i).getX();
        }
        if(!pts.isEmpty())
            tab[pts.size()] = (int) pts.get(0).getX();
        return tab;
    }



    @Override
    public int compareTo(MyPolygon o) {
        double a = this.getMaxZ();
        double b = o.getMaxZ();
        return (int) b - (int)a;
    }

    public double getMaxZ() {
        double max = -99999;
        for(int i = 0 ; i < this.getList().size();i++){
            if(pts.get(i).getZ()>max) max = pts.get(i).getZ();
        }
        return max;
    }
    public double getMinZ() {
        double min = 99999;
        for(int i = 0 ; i < this.getList().size();i++){
            if(pts.get(i).getZ()<min) min = pts.get(i).getZ();
        }
        return min;
    }
    public double getMaxX() {
        double max = -99999;
        for(int i = 0 ; i < this.getList().size();i++){
            if(pts.get(i).getX()>max) max = pts.get(i).getX();
        }
        return max;
    }
    public double getMinX() {
        double min = 99999;
        for(int i = 0 ; i < this.getList().size();i++){
            if(pts.get(i).getX()<min) min = pts.get(i).getX();
        }
        return min;
    }
    public double getMaxY() {
        double max = -99999;
        for(int i = 0 ; i < this.getList().size();i++){
            if(pts.get(i).getY()>max) max = pts.get(i).getY();
        }
        return max;
    }
    public double getMinY() {
        double min = 99999;
        for(int i = 0 ; i < this.getList().size();i++){
            if(pts.get(i).getY()<min) min = pts.get(i).getY();
        }
        return min;
    }
    public int getMinZIndex() {
        double min = 99999;
        int i;
        int ind=0;
        for(i= 0 ; i < this.getList().size();i++){
            if(pts.get(i).getZ()<min) {min = pts.get(i).getZ();
            ind = i;};
        }
        return ind;
    }

    public void sortVertices(){
        double min = 99999;
        int i;
        int ind=0;
        for(i= 0 ; i < this.getList().size()-2;i++){
            for(int j = i+1;j<this.getList().size()-1;j++){
                if(pts.get(i).getY()>pts.get(j).getY()) {
                    Collections.swap(pts,i,j);
                }
                if(pts.get(i).getY()==pts.get(j).getY()) {
                    if(pts.get(i).getX()>pts.get(j).getX())
                        Collections.swap(pts,i,j);
                }
            }

        }

    }

}
