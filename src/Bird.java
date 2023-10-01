import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Bird extends Actor {
  public Bird(Cell inLoc, boolean isHuman) {
    initActor(inLoc, Color.GREEN, isHuman, 3);
  }

  // Bird design courtesy of Sawyer James Rush
  protected void setPoly() {
    display = new ArrayList<Polygon>();
    Polygon body = new Polygon();
    body.addPoint(getLocation().x + 7, getLocation().y + 7);
    body.addPoint(getLocation().x + 15, getLocation().y + 5);
    body.addPoint(getLocation().x + 22, getLocation().y + 30);
    body.addPoint(getLocation().x + 10, getLocation().y + 13);
    body.addPoint(getLocation().x + 12, getLocation().y + 7);
    Polygon wing1 = new Polygon();
    wing1.addPoint(getLocation().x + 13, getLocation().y + 12);
    wing1.addPoint(getLocation().x + 17, getLocation().y + 18);
    wing1.addPoint(getLocation().x + 29, getLocation().y + 10);
    Polygon wing2 = new Polygon();
    wing2.addPoint(getLocation().x + 13, getLocation().y + 12);
    wing2.addPoint(getLocation().x + 17, getLocation().y + 18);
    wing2.addPoint(getLocation().x + 24, getLocation().y + 7);
    Polygon tail = new Polygon();
    tail.addPoint(getLocation().x + 21, getLocation().y + 26);
    tail.addPoint(getLocation().x + 22, getLocation().y + 30);
    tail.addPoint(getLocation().x + 27, getLocation().y + 32);
    tail.addPoint(getLocation().x + 26, getLocation().y + 20);
    display.add(body);
    display.add(wing1);
    display.add(wing2);
    display.add(tail);
  }
}
