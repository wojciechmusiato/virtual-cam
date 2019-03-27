import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JPanel {
    ArrayList<Polygon> polygons;

    public View() {
        setPreferredSize(new Dimension(639, 402));
        this.setBackground(Color.GRAY);
    }

    public void setPolygons(ArrayList<Polygon> polygons) {
        this.polygons = polygons;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(polygons != null) {
            for (Polygon pol : polygons) {
                    g.setColor(pol.getRandomColor());
                    g2d.fillPolygon(pol.getXPoints(),pol.getYPoints(),pol.getList().size()+1);
                }

        }
    }
}
