import javax.swing.*;
import java.awt.*;

public class Stage extends JPanel {
    Grid grid;
    Actor bird;
    Actor cat;
    Actor dog;
  

    
    
  


    //constrcutor
    public Stage() {
        grid = new Grid();
        bird = new Bird(grid.cells[15][9]);
        cat = new Cat(grid.cells[0][0]);
        dog = new Dog(grid.cells[0][15]);
        


    }

    

    // paint
    public void paint(Graphics g, Point mousPos) {
        grid.paint(g, mousPos);
        bird.paint(g);
        cat.paint(g);
        dog.paint(g);
      }

}


