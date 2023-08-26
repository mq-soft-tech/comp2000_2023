import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;
import java.util.function.Consumer;


public class Grid {
  Cell[][] cells = new Cell[20][20];

  public Grid() {
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[i].length; j++) {
        cells[i][j] = new Cell(colToLabel(i), j, 10 + Cell.size * i, 10 + Cell.size * j);
      }
    }
  }

  private char colToLabel(int col) {
    return (char) (col + Character.valueOf('A'));
  }

  private int labelToCol(char col) {
    return (int) (col - Character.valueOf('A'));
  }

  public Optional<Cell> cellAtPoint(Point p) {
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[i].length; j++) {
        if(cells[i][j].contains(p)) return Optional.of(cells[i][j]);
      }
    }
    return Optional.empty();
  }

  public void doToEachCell(Consumer<Cell> func) {
    for (int i = 0; i < cells.length; i++) {
        for (int j = 0; j < cells[i].length; j++) {
            func.accept(cells[i][j]);
        }
    }
}


  public void paint(Graphics g, Point mousePos) {
    doToEachCell(cell -> cell.paint(g, mousePos));
  }

  public Cell cellAtColRow(int c, int r) {
    return cells[c][r];
  }

  public Optional<Cell> cellAtColRowO(int c, int r) {
    return cellAtPoint(new Point(c,r));
  }


  public Cell cellAtColRow(char c, int r) {
    return cellAtColRow(labelToCol(c), r);
  }
}
