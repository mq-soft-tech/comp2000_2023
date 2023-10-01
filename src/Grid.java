import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

public class Grid implements Iterable<Cell> {
  Cell[][] cells = new Cell[20][20];
  
  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j] = new Cell(colToLabel(i), j, 10+Cell.size*i, 10+Cell.size*j);
      }
    }
  }

  private char colToLabel(int col) {
    return (char) (col + Character.valueOf('A'));
  }

  private int labelToCol(char col) {
    return (int) (col - Character.valueOf('A'));
  }

  public void paint(Graphics g, Point mousePos) {
    doToEachCell( (Cell c) -> c.paint(g, mousePos) );
  }

  public Optional<Cell> cellAtColRow(int c, int r) {
    if(c >= 0 && c < cells.length && r >=0 && r < cells[c].length) {
      return Optional.of(cells[c][r]);
    } else {
      return Optional.empty();
    }
  }

  public Optional<Cell> cellAtColRow(char c, int r) {
    return cellAtColRow(labelToCol(c), r);
  }

  public Optional<Cell> cellAtPoint(Point p) {
    for(Cell c: this) {
      if(c.contains(p)) {
        return Optional.of(c);
      }
    }
    return Optional.empty();
  }

  /**
   * Takes a cell consumer (i.e. a function that has a single `Cell` argument and
   * returns `void`) and applies that consumer to each cell in the grid.
   * @param func The `Cell` to `void` function to apply at each spot.
   */
  public void doToEachCell(Consumer<Cell> func) {
    for(Cell c: this) {
      func.accept(c);
    }
  }

  public List<Cell> getRadius(Cell from, int size) {
    int i = labelToCol(from.col);
    int j = from.row;
    Set<Cell> inRadius = new HashSet<Cell>();
    if (size > 0) {
        cellAtColRow(colToLabel(i), j - 1).ifPresent(inRadius::add);
        cellAtColRow(colToLabel(i), j + 1).ifPresent(inRadius::add);
        cellAtColRow(colToLabel(i - 1), j).ifPresent(inRadius::add);
        cellAtColRow(colToLabel(i + 1), j).ifPresent(inRadius::add);
    }

    for(Cell c: inRadius.toArray(new Cell[0])) {
        inRadius.addAll(getRadius(c, size - 1));
    }
    return new ArrayList<Cell>(inRadius);
  }

  public void paintOverlay(Graphics g, List<Cell> cells, Color color) {
    g.setColor(color);
    for(Cell c: cells) {
      g.fillRect(c.x+2, c.y+2, c.width-4, c.height-4);
    }
  }

  @Override
  public CellIterator iterator() {
    return new CellIterator(cells);
  }
}
