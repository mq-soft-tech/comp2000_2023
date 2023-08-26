import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StageReader {
  public static Stage readStage(String path) throws IOException {
    Stage stage = new Stage();
    Properties props = (new Properties());
    props.load(new FileInputStream(path));
    for(String key: props.stringPropertyNames()) {
      String value = props.getProperty(key);
      Pattern cell = Pattern.compile("(.)(\\d+)");
      List<Cell> cellsInQuestion = new ArrayList<Cell>();
      Matcher cellMatcher = cell.matcher(key);
      if(cellMatcher.matches()) {
        char col = cellMatcher.group(1).charAt(0);
        int row = Integer.parseInt(cellMatcher.group(2));
        stage.grid.cellAtColRowO(col, row).ifPresent(cellsInQuestion::add);
        cellsInQuestion.add(stage.grid.cellAtColRow(col, row));
      } else {
        System.out.println("no match " + key);
      }
      for(Cell c: cellsInQuestion) {
        if(value.equals("cat")) {
          stage.actors.add(new Cat(c));
        } else if(value.equals("dog")) {
          stage.actors.add(new Dog(c));
        } else if(value.equals("bird")) {
          stage.actors.add(new Bird(c));
        }
      }
    }
    return stage;
  }
}
