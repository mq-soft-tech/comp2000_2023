import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Bird extends Actor {
  public Bird(Cell inLoc, boolean isHuman) {
    super(inLoc, Color.GREEN, isHuman, 3);
  }

  // Bird design courtesy of Sawyer James Rush
  protected void setPoly() {
    display = new ArrayList<Polygon>();
    Polygon body = new Polygon();
    body.addPoint(loc.x + 7, loc.y + 7);
    body.addPoint(loc.x + 15, loc.y + 5);
    body.addPoint(loc.x + 22, loc.y + 30);
    body.addPoint(loc.x + 10, loc.y + 13);
    body.addPoint(loc.x + 12, loc.y + 7);
    Polygon wing1 = new Polygon();
    wing1.addPoint(loc.x + 13, loc.y + 12);
    wing1.addPoint(loc.x + 17, loc.y + 18);
    wing1.addPoint(loc.x + 29, loc.y + 10);
    Polygon wing2 = new Polygon();
    wing2.addPoint(loc.x + 13, loc.y + 12);
    wing2.addPoint(loc.x + 17, loc.y + 18);
    wing2.addPoint(loc.x + 24, loc.y + 7);
    Polygon tail = new Polygon();
    tail.addPoint(loc.x + 21, loc.y + 26);
    tail.addPoint(loc.x + 22, loc.y + 30);
    tail.addPoint(loc.x + 27, loc.y + 32);
    tail.addPoint(loc.x + 26, loc.y + 20);
    display.add(body);
    display.add(wing1);
    display.add(wing2);
    display.add(tail);
  }
}
