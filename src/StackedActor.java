import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public class StackedActor extends Actor {

  List<Actor> stack;

  public StackedActor(Actor top, Actor bottom) {
    stack = new ArrayList<Actor>();
    stack.add(top);
    stack.add(bottom);
    setPoly();
  }

  @Override
  protected void setPoly() {
    stack.get(0).setPoly();
  }

  @Override
  protected List<Polygon> getPoly() {
    return stack.get(0).getPoly();
  }

  public void add(Actor a) {
    stack.add(a);
  }

  @Override
  public boolean isHuman() {
    return stack.get(0).isHuman();
  }

  public void setLocation(Cell inLoc) {
    stack.get(0).setLocation(inLoc);
    if(getLocation().row % 2 == 0) {
      strat = new RandomMove();
    } else {
      strat = new LeftMostMove();
    }
    setPoly();
  }

  @Override
  public int getMoves() {
    int curr = stack.get(0).getMoves();
    for(Actor a: stack) {
      curr = curr + a.getMoves(); //Math.max(curr, a.getMoves());
    }
    return curr;
  }

  public Color getColor() {
    return stack.get(0).getColor();
  }

  public Cell getLocation() {
    return stack.get(0).getLocation();
  }
}
