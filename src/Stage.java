import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Stage {
  Grid grid;
  List<Actor> actors;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for (Actor a : actors) {
      a.paint(g);
    }
  }

}
