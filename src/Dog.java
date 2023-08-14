import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;


public class Dog extends Actor {
 
  Actor Dog;
   static ArrayList <Polygon> dogs = new ArrayList<Polygon>();

  public Dog(Cell inLoc) {
    loc = inLoc;
    color = Color.YELLOW;
   
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 11, loc.y + 5);
    ear1.addPoint(loc.x + 15, loc.y + 15);
    ear1.addPoint(loc.x + 7, loc.y + 15);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 22, loc.y + 5);
    ear2.addPoint(loc.x + 26, loc.y + 15);
    ear2.addPoint(loc.x + 18, loc.y + 15);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 5, loc.y + 15);
    face.addPoint(loc.x + 29, loc.y + 15);
    face.addPoint(loc.x + 17, loc.y + 30);
    dogs.add(ear1);
    dogs.add(ear2);
    dogs.add(face);
    Dog.addPolygon(dogs);
  }

  public static void main(String[] args) {
    for (Polygon p : dogs) {
      System.out.println(p);
    }
  }
  
  
  

 
}
