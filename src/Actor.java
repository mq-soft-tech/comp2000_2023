import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;

public abstract class Actor {
  Color color;
  Cell loc;
  List<Polygon> display;
  boolean humanPlayer;
  int moves;
  int turns;
  MoveStrategy strat;

  protected Actor(Cell inLoc, Color inColor, Boolean isHuman, int inMoves) {
    setLocation(inLoc);
    color = inColor;
    humanPlayer = isHuman;
    moves = inMoves;
    turns = 1;
    setPoly();
  }

  public void paint(Graphics g) {
    for(Polygon p: display) {
      g.setColor(color);
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
    }
  }

  protected abstract void setPoly();

  public boolean isHuman() {
    return humanPlayer;
  }

  public void setLocation(Cell inLoc) {
    loc = inLoc;
    if(loc.row % 2 == 0) {
      strat = new RandomMove();
    } else {
      strat = new LeftMostMove();
    }
    setPoly();
  }
}
