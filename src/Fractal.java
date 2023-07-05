import javax.swing.*;
import java.awt.*;

public class Fractal extends JPanel {

    private int depth;  // Depth of recursion

    public Fractal(int depth) {
        this.depth = depth;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFractal(g, depth, 10, 10, getWidth() - 20, getHeight() - 20);
    }

    private void drawFractal(Graphics g, int depth, int x, int y, int width, int height) {
        if (depth == 0) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, width, height);
        } else {
            int newWidth = width / 2;
            int newHeight = height / 2;
            drawFractal(g, depth - 1, x, y, newWidth, newHeight);
            drawFractal(g, depth - 1, x + newWidth, y, newWidth, newHeight);
            drawFractal(g, depth - 1, x + newWidth / 2, y + newHeight, newWidth, newHeight);
        }
    }

    public static void main(String[] args) {
        int depth = 7; // Specify the desired depth of recursion
        Fractal fractal = new Fractal(depth);

        JFrame frame = new JFrame("Fractal Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().add(fractal);
        frame.setVisible(true);
    }

}
