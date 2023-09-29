import java.util.List;
import java.util.Random;

public class RandomMove implements MoveStrategy {
  @Override
  public Cell chooseNextLoc(List<Cell> possibleLocs) {
    int i = (new Random()).nextInt(possibleLocs.size());
    return possibleLocs.get(i);
  }

  public String toString() {
    return "random movement";
  }
}
