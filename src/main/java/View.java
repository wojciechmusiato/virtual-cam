import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JPanel {
    private ZBuffer buffer;
    private ArrayList<MyPolygon> polygons;

    public View() {
        setPreferredSize(new Dimension(639, 402));
        this.setBackground(Color.GRAY);

    }

    public void setMyPolygons(ArrayList<MyPolygon> polygons) {
        this.polygons = polygons;
    }


    @Override
    protected void paintComponent(Graphics g) {
        int i = 0;
        int j = 0;
        for (i = 0; i < 639; i++) {
            for (j = 0; j < 602; j++) {
                buffer.zdepth[i][j]= -99999.0;
                buffer.colormap[i][j]= Color.WHITE;
            }
        }
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        i = 0;
        int k = 0;
        if (polygons != null) {
            for (MyPolygon pol : polygons) {
                buffer.czarymary(pol,k);
                k++;
            }
            for (i = 0; i < 639; i++) {
                for (j = 0; j < 602; j++) {
                    g2d.setColor(buffer.colormap[i][j]);
                    g2d.fillRect(i,j,1,1);
                }
            }

        }
    }
}
