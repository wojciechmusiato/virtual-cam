import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.Collections;

public class Operations {
    private View view;
    public static double focal = 300;
    public final static int sceneWidth = 500;
    public final static int sceneHeight = 500;
    public ArrayList<MyPolygon> polygons;

    public Operations(View view, ZBuffer b) {
        this.polygons = new ArrayList<MyPolygon>();
        this.view = view;
        view.buffer= b;
        view.buffer.operations=this;
    }

    public void moveUp() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, (-1) * Vcam.TRANSLATION_MOVE}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void moveDown() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, Vcam.TRANSLATION_MOVE}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void moveLeft() {
        double[][] d = {{1, 0, 0, Vcam.TRANSLATION_MOVE}, {0, 1, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void moveRight() {
        double[][] d = {{1, 0, 0, (-1) * Vcam.TRANSLATION_MOVE}, {0, 1, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void moveForward() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, (-1) * Vcam.TRANSLATION_MOVE}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void moveBackwards() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, Vcam.TRANSLATION_MOVE}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void leanLeft() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), Math.sin(Vcam.ROTATION_MOVE), 0, 0},
                {(-1) * Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0, 0},
                {0, 0, 1, 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void leanRight() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), (-1) * Math.sin(Vcam.ROTATION_MOVE), 0, 0},
                {Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0, 0},
                {0, 0, 1, 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void rotateRight() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), 0, (-1) * Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, 1, 0, 0},
                {Math.sin(Vcam.ROTATION_MOVE), 0, Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void rotateLeft() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), 0, Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, 1, 0, 0},
                {(-1) * Math.sin(Vcam.ROTATION_MOVE), 0, Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void rotateForward() {
        double[][] d = {{1, 0, 0, 0}, {0, Math.cos(Vcam.ROTATION_MOVE), (-1) * Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
            }
        }
        draw();
    }

    public void rotateBackwards() {
        double[][] d = {{1, 0, 0, 0}, {0, Math.cos(Vcam.ROTATION_MOVE), Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, (-1) * Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (MyPolygon pol : polygons) {
            for (int i = 0; i < pol.getList().size(); i++) {
                RealMatrix w1 = m.multiply(pol.getPoint(i).getM());
                pol.getList().set(i, new Point(w1));
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

        int k=0;
        ArrayList<MyPolygon> tmppol = new ArrayList<>();
        for (int i = 0; i < Vcam.data.length; i++) {
            tmppol.add(new MyPolygon());
            for (int j = 0; j < Vcam.data[i].length ; j += 3) {

                //System.out.println(j);
                tmppol.get(i).setPoint((new Point(Vcam.data[i][j], Vcam.data[i][j + 1], Vcam.data[i][j + 2])));
            }
        }
        System.out.println(tmppol.size());
        //System.out.println(tmppol.get(0).getList().size());
        for (int i = 0; i < tmppol.size(); i++) {
            for (int j = 1; j < tmppol.get(i).getList().size()-2;j++) {
                polygons.add(new MyPolygon());
                polygons.get(k).setPoint(tmppol.get(i).getPoint(0));
                polygons.get(k).setPoint(tmppol.get(i).getPoint(j));
                polygons.get(k).setPoint(tmppol.get(i).getPoint(j+1));
                polygons.get(k).setPoint(tmppol.get(i).getPoint(tmppol.get(i).getList().size()-1));
                polygons.get(k).sortVertices();
                k++;
            }
        }

        System.out.println(polygons.size());
    }

    public ArrayList<MyPolygon> projectScene() {
        /*painter*/
        ArrayList<MyPolygon> space = new ArrayList<MyPolygon>();
        for (MyPolygon pol : polygons) {
            MyPolygon p = new MyPolygon();
            pol.sortVertices();
            for (int i = 0; i < pol.getList().size()-1; i++) {
                if (checkIfVisible(pol)) {
                    p.setPoint(projectPoint(pol.getPoint(i)));
                }
            }
            space.add(p);
        }
        return space;
    }

    public Point projectPoint(Point p) {
        double d = focal;
        int x = (int) (p.getX() * d / (p.getZ() ) + (sceneWidth / 2));
        int y = (int) ((sceneHeight / 2) - p.getY() * d / (p.getZ() ));
        int z = (int) d;

        return new Point(x, y, 1);
    }

    public boolean checkIfVisible(MyPolygon pol) {
        for (int i = 0; i < pol.getList().size(); i++) {
            if (pol.getPoint(i).getZ() < 0) {
                return false;
            }
        }
        return true;
    }


    public void draw() {
        view.setMyPolygons(this.projectScene());
        view.repaint();
    }
}
