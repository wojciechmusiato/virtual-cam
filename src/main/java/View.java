import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JPanel {
    ArrayList<Vector> vectors;

    public View() {
        setPreferredSize(new Dimension(639, 402));
        this.setBackground(Color.GRAY);
    }

    public void setVectors(ArrayList<Vector> vectors) {
        this.vectors = vectors;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        if(vectors != null) {
            for (Vector vec : vectors) {

                    System.out.println(vec.getA().getX()+ " " + vec.getA().getY()+ " " +vec.getB().getX()+ " " +vec.getB().getY());
                    g2d.drawLine((int) vec.getA().getX(),
                            (int) vec.getA().getY(), (int) vec.getB().getX(),
                            (int) vec.getB().getY());
                }

        }
    }
}
