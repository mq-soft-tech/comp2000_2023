import javax.swing.*;
import java.awt.*;

import java.util.Random;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
    }

    class Cell {
        private int x;
        private int y;
        private int size;
        private Color color;

        public Cell(int x, int y, int size, Color color) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = color;
        }

        public void paint(Graphics g) {
            g.setColor(color.white);
            g.fillRect(x, y, size, size);
            g.setColor(Color.black);
            g.drawRect(x, y, size, size);
        }
    }

    class Grid extends JPanel {
        private int width = 720;
        private int height = 720;
        private int cellSize = 35;
        private Cell[][] cells;
        int padding = 10;

        private Cell mouseOverCell = null;

        private int xAmount = 20, yAmount = 20;

        public Grid() {
            setPreferredSize(new Dimension(width, height));
            createGrid();
            addMouseListener(new MouseListen());
            addMouseMotionListener(new MouseListen());
        }

        public void createGrid() {
            cells = new Cell[xAmount][yAmount];
            Random randomCol = new Random();
            int cMin = 0;
            int cMax = 256;
            for (int i = 0; i < xAmount; i++) {
                for (int j = 0; j < yAmount; j++) {
                    int r = randomCol.nextInt(cMax - cMin) + cMin;
                    int g = randomCol.nextInt(cMax - cMin) + cMin;
                    int b = randomCol.nextInt(cMax - cMin) + cMin;
                    cells[i][j] = new Cell(padding + i * cellSize, padding + j * cellSize, cellSize,
                            new Color(r, g, b));
                }
            }
        }

        @Override
        public void paint(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < xAmount; i++) {
                for (int j = 0; j < yAmount; j++) {
                    cells[i][j].paint(g);
                }
            }

            if (mouseOverCell != null) {
                g.setColor(Color.black);
                g.fillRect(mouseOverCell.x, mouseOverCell.y, mouseOverCell.size, mouseOverCell.size);
            }
        }

        private class MouseListen extends MouseAdapter {

            @Override
            public void mouseMoved(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                mouseOverCell = MouseOverCell(mouseX, mouseY);
                repaint();
            }
        }

        private Cell MouseOverCell(int x, int y) {
            for (int i = 0; i < xAmount; i++) {
                for (int j = 0; j < yAmount; j++) {
                    Cell cell = cells[i][j];
                    if (x >= cell.x && x < cell.x + cell.size && y >= cell.y && y < cell.y + cell.size) {
                        return cell;
                    }
                }
            }
            return null;
        }
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Grid grid = new Grid();
        this.setContentPane(grid);
        this.pack();
        this.setVisible(true);
    }
}