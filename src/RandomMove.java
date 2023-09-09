<<<<<<< HEAD
import java.util.Random;

public interface RandomMove {
    // int moveBotChooses = (new Random()).nextInt(possibleLocs.size());
    // a.setLocation(possibleLocs.get(moveBotChooses));
=======
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
>>>>>>> ae72df6faaf67014102991abcfdf88627f85e5bc
}
