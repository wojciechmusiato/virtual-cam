import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.Collections;

public class Operations {
    private View view;
    private double focal = 300;
    private final static int sceneWidth = 500;
    private final static int sceneHeight = 500;
    private ArrayList<Polygon> polygons;

    public Operations(View view) {
        this.polygons = new ArrayList<Polygon>();
        this.view = view;
    }

    public void moveUp() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, (-1) * Vcam.TRANSLATION_MOVE}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void moveDown() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, Vcam.TRANSLATION_MOVE}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void moveLeft() {
        double[][] d = {{1, 0, 0, Vcam.TRANSLATION_MOVE}, {0, 1, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void moveRight() {
        double[][] d = {{1, 0, 0, (-1) * Vcam.TRANSLATION_MOVE}, {0, 1, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void moveForward() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, (-1) * Vcam.TRANSLATION_MOVE}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void moveBackwards() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, Vcam.TRANSLATION_MOVE}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void leanLeft() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), Math.sin(Vcam.ROTATION_MOVE), 0, 0},
                {(-1) * Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0, 0},
                {0, 0, 1, 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void leanRight() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), (-1) * Math.sin(Vcam.ROTATION_MOVE), 0, 0},
                {Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0, 0},
                {0, 0, 1, 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void rotateRight() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), 0, (-1) * Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, 1, 0, 0},
                {Math.sin(Vcam.ROTATION_MOVE), 0, Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void rotateLeft() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), 0, Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, 1, 0, 0},
                {(-1) * Math.sin(Vcam.ROTATION_MOVE), 0, Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void rotateForward() {
        double[][] d = {{1, 0, 0, 0}, {0, Math.cos(Vcam.ROTATION_MOVE), (-1) * Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();
    }

    public void rotateBackwards() {
        double[][] d = {{1, 0, 0, 0}, {0, Math.cos(Vcam.ROTATION_MOVE), Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, (-1) * Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Polygon pol : polygons) {
            for(int i = 0 ;i<pol.getList().size();i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i,new Point(w1));
            }
        }
        draw();

    }

    public void zoomIn() {
        focal += Vcam.FOCAL_MOVE;
        draw();
    }

    public void zoomOut() {
        focal -= Vcam.FOCAL_MOVE;
        draw();
    }

    public void loadData() {
        for (int i = 0; i < Vcam.data.length; i++) {
            polygons.add(new Polygon());
            for (int j = 0; j < Vcam.data[i].length-3; j+=3) {
                polygons.get(i).setPoint((new Point(Vcam.data[i][j], Vcam.data[i][j+1], Vcam.data[i][j+2])));
            }
        }
    }

    public ArrayList<Polygon> projectScene() {
        /*painter*/
        Collections.sort(polygons);
        checkOverlapping(polygons);
        ArrayList<Polygon> space = new ArrayList<Polygon>();
        for (Polygon pol : polygons) {
            Polygon p = new Polygon();
            for(int i = 0;i<pol.getList().size();i++) {
                if(checkIfVisible(pol)){
                    p.setPoint(projectPoint(pol.getPoint(i)));
                    space.add(p);
                }
            }
        }


        return space;
    }

    private void checkOverlapping(ArrayList<Polygon> polygons) {
        for (int i = 0 ; i < polygons.size();i++){
            for(int j = 0;j< polygons.get(i).getList().size();j++){
                //todo
            }
        }
    }

    public Point projectPoint(Point p) {
        double d = focal;
        int x = (int) (p.getX() * d / (p.getZ() + d) + (sceneWidth / 2));
        int y = (int) ((sceneHeight / 2) - p.getY() * d / (p.getZ() + d));
        int z = (int) d;

        return new Point(x, y, 1);
    }

    public boolean checkIfVisible(Polygon pol) {
        for(int i =0;i<pol.getList().size();i++) {
            if (pol.getPoint(i).getZ() < 0) {
                return false;
            }
        }
        return true;
    }

    public void setPolygons(ArrayList<Polygon> polygons) {
        this.polygons = polygons;
    }

    public void draw() {
        view.setPolygons(this.projectScene());
        view.repaint();
    }
}
