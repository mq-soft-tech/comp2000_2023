import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Cat extends Actor {
  public Cat(Cell inLoc, boolean isHuman) {
    initActor(inLoc, Color.BLUE, isHuman, 2);
  }

  // Cat design courtesy of Sawyer James Rush
  protected void setPoly() {
    display = new ArrayList<Polygon>();
    Polygon ear1 = new Polygon();
    ear1.addPoint(getLocation().x + 10, getLocation().y);
    ear1.addPoint(getLocation().x + 7, getLocation().y + 5);
    ear1.addPoint(getLocation().x + 13, getLocation().y + 5);
    Polygon ear2 = new Polygon();
    ear2.addPoint(getLocation().x + 25, getLocation().y);
    ear2.addPoint(getLocation().x + 22, getLocation().y + 5);
    ear2.addPoint(getLocation().x + 28, getLocation().y +5);
    Polygon face = new Polygon();
    face.addPoint(getLocation().x + 7, getLocation().y + 5);
    face.addPoint(getLocation().x + 28, getLocation().y + 5);
    face.addPoint(getLocation().x + 20, getLocation().y + 15);
    face.addPoint(getLocation().x + 15, getLocation().y + 15);
    Polygon body = new Polygon();
    body.addPoint(getLocation().x + 20, getLocation().y + 15);
    body.addPoint(getLocation().x + 15, getLocation().y + 15);
    body.addPoint(getLocation().x + 10, getLocation().y + 30);
    body.addPoint(getLocation().x + 25, getLocation().y + 30);
    Polygon tail = new Polygon();
    tail.addPoint(getLocation().x + 25, getLocation().y + 30);
    tail.addPoint(getLocation().x + 30, getLocation().y + 15);
    tail.addPoint(getLocation().x + 25, getLocation().y + 10);
    tail.addPoint(getLocation().x + 28, getLocation().y + 15);
    display.add(face);
    display.add(ear1);
    display.add(ear2);
    display.add(body);
    display.add(tail);
  }
}
