import java.util.Iterator;

public class CellIterator implements Iterator<Cell> {
  Cell[][] data;
  int outer;
  int inner;
  boolean runOut;

  public CellIterator(Cell[][] inData) {
    data = inData;
    outer = 0;
    inner = 0;
    runOut = false;
  }

  @Override
  public boolean hasNext() {
    return !runOut;
  }

  @Override
  public Cell next() {
    Cell ret = data[outer][inner];
    inner++;
    if(inner >= data[outer].length) {
      inner = 0;
      outer++;
      if(outer >= data.length) {
        runOut = true;
      }
    }
    return ret;
  }
}
