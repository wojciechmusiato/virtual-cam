import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;

public class Operations {
    private View view;
    private ArrayList<Vector> vectors;
    private double focal = 300;
    private final static int sceneWidth = 500;
    private final static int sceneHeight = 500;
    private ArrayList<Polygon> polygons;

    public Operations(View view) {
        this.polygons = new ArrayList<Polygon>();
        this.vectors = new ArrayList<Vector>();
        this.view = view;
    }

    public void moveUp() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, (-1) * Vcam.TRANSLATION_MOVE}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void moveDown() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, Vcam.TRANSLATION_MOVE}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void moveLeft() {
        double[][] d = {{1, 0, 0, Vcam.TRANSLATION_MOVE}, {0, 1, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void moveRight() {
        double[][] d = {{1, 0, 0, (-1) * Vcam.TRANSLATION_MOVE}, {0, 1, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void moveForward() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, (-1) * Vcam.TRANSLATION_MOVE}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void moveBackwards() {
        double[][] d = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, Vcam.TRANSLATION_MOVE}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void leanLeft() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), Math.sin(Vcam.ROTATION_MOVE), 0, 0},
                {(-1) * Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0, 0},
                {0, 0, 1, 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void leanRight() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), (-1) * Math.sin(Vcam.ROTATION_MOVE), 0, 0},
                {Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0, 0},
                {0, 0, 1, 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void rotateRight() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), 0, (-1) * Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, 1, 0, 0},
                {Math.sin(Vcam.ROTATION_MOVE), 0, Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void rotateLeft() {
        double[][] d = {{Math.cos(Vcam.ROTATION_MOVE), 0, Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, 1, 0, 0},
                {(-1) * Math.sin(Vcam.ROTATION_MOVE), 0, Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void rotateForward() {
        double[][] d = {{1, 0, 0, 0}, {0, Math.cos(Vcam.ROTATION_MOVE), (-1) * Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
        }
        draw();
    }

    public void rotateBackwards() {
        double[][] d = {{1, 0, 0, 0}, {0, Math.cos(Vcam.ROTATION_MOVE), Math.sin(Vcam.ROTATION_MOVE), 0},
                {0, (-1) * Math.sin(Vcam.ROTATION_MOVE), Math.cos(Vcam.ROTATION_MOVE), 0}, {0, 0, 0, 1}};
        RealMatrix m = new Array2DRowRealMatrix(d);
        for (Vector vec : vectors) {
            RealMatrix w1 = m.multiply(vec.getA().getM());
            RealMatrix w2 = m.multiply(vec.getB().getM());
            vec.setA(new Point(w1));
            vec.setB(new Point(w2));
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
        int k;
        for (int i = 0; i < Vcam.data.length; i++) {
            System.out.println(Vcam.data.length+" " +i);
            polygons.add(new Polygon());
            k=0;
            for (int j = 0; j < Vcam.data[i].length-3; j+=3) {
                polygons.get(i).setVector((new Vector(
                        new Point(Vcam.data[i][j], Vcam.data[i][j+1], Vcam.data[i][j+2]),
                        new Point(Vcam.data[i][j+3], Vcam.data[i][j+4], Vcam.data[i][j+5])

                )));
                vectors.add(polygons.get(i).getVector(k));
                k++;
            }
        }
    }

    public ArrayList<Vector> projectScene() {
        ArrayList<Vector> space = new ArrayList<Vector>();
        Point A, B;
        for (Vector vec : vectors) {
            A = vec.getA();
            B = vec.getB();
            if (checkIfVisible(vec)) {
                Vector vector2D = new Vector(projectPoint(A),
                        projectPoint(B));
                space.add(vector2D);
            }
        }

        return space;
    }

    public Point projectPoint(Point p) {
        double d = focal;
        int x = (int) (p.getX() * d / (p.getZ() + d) + (sceneWidth / 2));
        int y = (int) ((sceneHeight / 2) - p.getY() * d / (p.getZ() + d));
        int z = (int) d;

        return new Point(x, y, 1);
    }

    public boolean checkIfVisible(Vector vec) {
        if (vec.getA().getZ() < 0 || vec.getB().getZ() < 0) {
            return false;
        }
        return true;
    }

    public ArrayList<Vector> getVectors() {
        return this.vectors;
    }

    public void draw() {
        view.setVectors(this.projectScene());
        view.repaint();
    }
}
