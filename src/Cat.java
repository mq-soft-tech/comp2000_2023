import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Cat extends Actor {
  public Cat(Cell inLoc, boolean isHuman) {
    super(inLoc, Color.BLUE, isHuman, 2);
  }

  // Cat design courtesy of Sawyer James Rush
  protected void setPoly() {
    display = new ArrayList<Polygon>();
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 10, loc.y);
    ear1.addPoint(loc.x + 7, loc.y + 5);
    ear1.addPoint(loc.x + 13, loc.y + 5);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 25, loc.y);
    ear2.addPoint(loc.x + 22, loc.y + 5);
    ear2.addPoint(loc.x + 28, loc.y +5);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 7, loc.y + 5);
    face.addPoint(loc.x + 28, loc.y + 5);
    face.addPoint(loc.x + 20, loc.y + 15);
    face.addPoint(loc.x + 15, loc.y + 15);
    Polygon body = new Polygon();
    body.addPoint(loc.x + 20, loc.y + 15);
    body.addPoint(loc.x + 15, loc.y + 15);
    body.addPoint(loc.x + 10, loc.y + 30);
    body.addPoint(loc.x + 25, loc.y + 30);
    Polygon tail = new Polygon();
    tail.addPoint(loc.x + 25, loc.y + 30);
    tail.addPoint(loc.x + 30, loc.y + 15);
    tail.addPoint(loc.x + 25, loc.y + 10);
    tail.addPoint(loc.x + 28, loc.y + 15);
    display.add(face);
    display.add(ear1);
    display.add(ear2);
    display.add(body);
    display.add(tail);
  }
}
