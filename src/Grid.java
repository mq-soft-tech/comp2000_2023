import java.awt.*;

public class Grid {
    Cell cell = new Cell(35, 35);

    public void paint (Graphics g, Point coordinates) {
        for(int i = 10; i < 710; i += 35) {
            for (int j = 10; j < 710; j+= 35) {
                    cell.paint(g, i, j, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
                }
            }
        }
    }
    
