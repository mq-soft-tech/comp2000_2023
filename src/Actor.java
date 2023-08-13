import java.awt.Color;
import java.awt.Graphics;

public abstract class Actor {

Color color; // color variable
Cell Location; // cell location

public void paint(Graphics g){
    g.setColor(Color.GRAY);
    g.fillRect(Location.x + 5, Location.y + 5, Location.width -10, Location.height -10);
    g.setColor(color);
    g.fillRect(Location.x + 5, Location.y + 5, Location.width -10, Location.height -10);
}

}