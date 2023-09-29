import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Dog extends Actor {
  public Dog(Cell inLoc, boolean isHuman) {
    super(inLoc, Color.YELLOW, isHuman, 1);
  }

  // Dog design courtesy of Sawyer James Rush
  protected void setPoly() {
    display = new ArrayList<Polygon>();
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 5, loc.y + 5);
    ear1.addPoint(loc.x + 5, loc.y + 15);
    ear1.addPoint(loc.x + 10, loc.y + 10);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 30, loc.y + 5);
    ear2.addPoint(loc.x + 25, loc.y + 10);
    ear2.addPoint(loc.x + 30, loc.y + 15);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 5, loc.y + 5);
    face.addPoint(loc.x + 30, loc.y + 5);
    face.addPoint(loc.x + 20, loc.y + 15);
    face.addPoint(loc.x + 15, loc.y + 15);
    Polygon body = new Polygon();
    body.addPoint(loc.x + 15, loc.y + 10);
    body.addPoint(loc.x + 20, loc.y + 10);
    body.addPoint(loc.x + 30, loc.y + 30);
    body.addPoint(loc.x + 5, loc.y + 30);
    Polygon tail = new Polygon();
    tail.addPoint(loc.x + 28, loc.y + 26);
    tail.addPoint(loc.x + 33, loc.y + 20);
    tail.addPoint(loc.x + 30, loc.y + 30);
    display.add(face);
    display.add(ear1);
    display.add(ear2);
    display.add(body);
    display.add(tail);
  }
}
