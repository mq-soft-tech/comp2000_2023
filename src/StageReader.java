import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StageReader {
  public static Stage readStage(String path) {
    Stage stage = new Stage();
    Properties props = (new Properties());
    try {
      props.load(new FileInputStream(path));
      for(String key: props.stringPropertyNames()) {
        String value = props.getProperty(key);
        Pattern cell = Pattern.compile("(.)(\\d+)");
        List<Cell> cellsInQuestion = new ArrayList<Cell>();
        Matcher cellMatcher = cell.matcher(key);
        if(cellMatcher.matches()) {
          char col = cellMatcher.group(1).charAt(0);
          int row = Integer.parseInt(cellMatcher.group(2));
          stage.grid.cellAtColRow(col, row).ifPresent(cellsInQuestion::add);
        } else {
          System.out.println("no match " + key);
        }
        for(Cell c: cellsInQuestion) {
          boolean human = true;
          String suffix = " bot";
          if(value.endsWith(suffix)) {
            human = false;
            value = value.substring(0, value.length()-suffix.length());
          }
          if(value.equals("cat")) {
            stage.actors.add(new Cat(c, human));
          } else if(value.equals("dog")) {
            stage.actors.add(new Dog(c, human));
          } else if(value.equals("bird")) {
            stage.actors.add(new Bird(c, human));
          }
        }
      }
    } catch(IOException e) {
      System.out.println("Unable to read stage file, using builtin stage.");
      stage.actors.add(new Cat(stage.grid.cellAtColRow(0, 0).get(), true));
      stage.actors.add(new Dog(stage.grid.cellAtColRow(0, 15).get(), false));
      stage.actors.add(new Bird(stage.grid.cellAtColRow(12, 9).get(), false));
    }
    return stage;
  }
}
