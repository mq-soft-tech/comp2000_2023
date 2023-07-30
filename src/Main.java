<<<<<<< Updated upstream
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Red vs. Blue");
=======
import javax.swing.*;
import java.awt.*;


public class Main extends JFrame
{
    public static void main(String[] args) throws Exception 
    {
        Main window = new Main();

    }

    class Canvas extends JPanel 
    {
        private int width = 720;
        private int height = 720;

        public Canvas()
        {
            setPreferredSize(new Dimension(width, height));
        }

        @Override
        public void paint(Graphics g)
        {
            for(int i = 10; i < 710; i+=35)
            {
                for(int j = 10; j < 710; j+=35)
                {
                    g.setColor(Color.white);
                    g.fillRect(i, j, 35, 35);
                    g.setColor(Color.black);
                    g.drawRect(i, j, 35, 35);
                }
            }
        }
    }

    private Main()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
>>>>>>> Stashed changes
    }
}

