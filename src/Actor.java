import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;

public abstract class Actor {
  private Color color;
  private Cell loc;
  protected List<Polygon> display;
  private boolean humanPlayer;
  private int moves;
  int turns;
  MoveStrategy strat;

  protected void initActor(Cell inLoc, Color inColor, Boolean isHuman, int inMoves) {
    setLocation(inLoc);
    color = inColor;
    humanPlayer = isHuman;
    moves = inMoves;
    turns = 1;
    setPoly();
  }

  public void paint(Graphics g) {
    for(Polygon p: getPoly()) {
      g.setColor(getColor());
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
    }
  }

  protected abstract void setPoly();

  protected List<Polygon> getPoly() {
    return display;
  }

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

  public int getMoves() {
    return moves;
  }

  public Color getColor() {
    return color;
  }

  public Cell getLocation() {
    return loc;
  }
}
