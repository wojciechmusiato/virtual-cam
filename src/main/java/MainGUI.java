import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

public class MainGUI extends JFrame implements KeyListener {
    View view;
    Operations operations;

    public MainGUI() {
        setSize(new Dimension(785, 504));
        setPreferredSize(new Dimension(760, 480));
        setTitle("Vcam");
        setBackground(Color.LIGHT_GRAY);


        view = new View();
        view.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
                TitledBorder.TOP, null, null));
        view.setBackground(Color.WHITE);

        operations = new Operations(view);
        operations.loadData();
        JPanel panel = new JPanel();

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addContainerGap()
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(view, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(3)));
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup()
                        .addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                .addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                                .addComponent(view, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)).addContainerGap()));

        JLabel labelMove = new JLabel("Ruch:");
        labelMove.setFont(new Font("Arial", Font.BOLD, 11));
        JLabel labelMoveLeft = new JLabel("Lewo - strzałka w lewo");
        JLabel labelMoveRight = new JLabel("Prawo - strzałka w prawo");
        JLabel labelMoveForward = new JLabel("Do przodu - strzałka do góry");
        JLabel labelMoveBack = new JLabel("Do tyłu - strzałka do tyłu");
        JLabel labelRotation = new JLabel("Obrót:");
        labelRotation.setFont(new Font("Arial", Font.BOLD, 11));
        JLabel labelRotateLeft = new JLabel("Lewo - A");
        JLabel labelRotateRight = new JLabel("Prawo - D");
        JLabel labelRotateUp = new JLabel("Do góry - W");
        JLabel labelRotateDown = new JLabel("Do dołu - S");
        JLabel labelMoveUp = new JLabel("Ruch do góry - O");
        JLabel labelMoveDown = new JLabel("Ruch do dołu - P");
        JLabel labelLeaning = new JLabel("Pochylenie:");
        labelLeaning.setFont(new Font("Arial", Font.BOLD, 11));
        JLabel labelLeanLeft = new JLabel("Lewo - Q");
        JLabel labelLeanRight = new JLabel("Prawo - E");
        JLabel labelZoom = new JLabel("Przybliżanie:");
        labelZoom.setFont(new Font("Arial", Font.BOLD, 11));
        JLabel labelZoomIn = new JLabel("Zoom - 1");
        JLabel labelZoomOut = new JLabel("Zoom out - 2");
        
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                        .addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(labelMove)
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelMoveLeft))
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelMoveRight))
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelMoveForward))
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelMoveBack))
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelMoveUp))
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().
                                        addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(labelRotateUp).
                                                addComponent(labelRotateDown))).addComponent(labelRotation)
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelRotateRight))
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelRotateLeft))
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelMoveDown)).addComponent(labelLeaning)
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelLeanLeft))
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelLeanRight)).addComponent(labelZoom)
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelZoomIn))
                                .addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(labelZoomOut)))
                        .addContainerGap(3, Short.MAX_VALUE)));
        gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_panel.createSequentialGroup().addContainerGap()
                        .addComponent(labelMove).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelMoveLeft).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelMoveRight).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelMoveForward).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelMoveBack).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelMoveUp).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelMoveDown).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelRotation).addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(labelRotateLeft).addGap(4)
                        .addComponent(labelRotateRight).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelRotateUp).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelRotateDown).addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(labelLeaning).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelLeanLeft).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelLeanRight).addGap(18)
                        .addComponent(labelZoom).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelZoomIn).addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(labelZoomOut).addContainerGap(GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));
        panel.setLayout(gl_panel);
        getContentPane().setLayout(groupLayout);
        operations.draw();
        addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        switch (keycode) {
            case KeyEvent.VK_O:
                operations.moveUp();
                break;
            case KeyEvent.VK_P:
                operations.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                operations.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                operations.moveRight();
                break;
            case KeyEvent.VK_UP:
                operations.moveForward();
                break;
            case KeyEvent.VK_DOWN:
                operations.moveBackwards();
                break;
            case KeyEvent.VK_1:
                operations.zoomIn();
                break;
            case KeyEvent.VK_2:
                operations.zoomOut();
                break;
            case KeyEvent.VK_A:
                operations.rotateLeft();
                break;
            case KeyEvent.VK_S:
                operations.rotateBackwards();
                break;
            case KeyEvent.VK_W:
                operations.rotateForward();
                break;
            case KeyEvent.VK_D:
                operations.rotateRight();
                break;
            case KeyEvent.VK_Q:
                operations.leanLeft();
                break;
            case KeyEvent.VK_E:
                operations.leanRight();
                break;


        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
