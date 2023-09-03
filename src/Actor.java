import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;
import java.util.function.Function;
import java.util.Random;

public abstract class Actor {
  Color color;
  Cell loc;
  List<Polygon> display;
  boolean humanPlayer;
  int moves;
  int turns;
  Function<List<Cell>,Cell> strat;

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
      strat = (List<Cell> possibleLocs) -> {
                int i = (new Random()).nextInt(possibleLocs.size());
                return possibleLocs.get(i);
              };
    } else {
      strat = (List<Cell> possibleLocs) -> {
                Cell currLM = possibleLocs.get(0);
                for(Cell c: possibleLocs) {
                  if(c.leftOfComparison(currLM) < 0) {
                    currLM = c;
                  }
                }
                return currLM;
              };  
    }
    setPoly();
  }
}
