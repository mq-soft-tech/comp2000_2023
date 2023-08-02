import java.awt.*;

public class Cell {
    int height; int width;

    public void paint (Graphics g, int xValue, int yValue, double xPosition, double yPosition) {
        if (xValue < xPosition & yValue > yPosition) {
            g.setColor(Color.gray);
        } else {
            g.setColor(Color.white);
        }

        //g.setColor(Color.white);
        g.fillRect(xValue, yValue, width, height);
        g.setColor(Color.black);
        g.drawRect(xValue, yValue, width, height);
    }

    public Cell (int width, int height) {
        this.width = width;
        this.height = height;
    }
}


