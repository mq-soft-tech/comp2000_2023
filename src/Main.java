/* 
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Red vs Blue");
    }
}
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
    }

    /*public void run() {
        while (true) {
            repaint();
        }
    }*/

    class Canvas extends JPanel {
        private int width = 720; private int height = 720;
        Grid grid = new Grid();

        public Canvas() {
            setPreferredSize(new Dimension(width, height));
        }

        @Override
        public void paint(Graphics g) {
            grid.paint(g, MouseInfo.getPointerInfo().getLocation());
            repaint();
        }
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }
}
 