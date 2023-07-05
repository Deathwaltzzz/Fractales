import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    private static final int WIDTH = 800;       // Width of the drawing area
    private static final int HEIGHT = 600;      // Height of the drawing area
    private static final double TRUNK_LENGTH = 100;     // Length of the initial trunk
    private static final double ANGLE = Math.PI / 4;    // Angle of the branches
    private static final double LENGTH_FACTOR = 0.7;    // Length scaling factor for each recursive call
    private static final int RECURSION_DEPTH = 25;       // Number of recursive calls

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFractalTree(g, WIDTH / 2, HEIGHT - 20, -Math.PI / 2, TRUNK_LENGTH, RECURSION_DEPTH);
    }

    private void drawFractalTree(Graphics g, int x, int y, double angle, double length, int depth) {
        if (depth == 0) {
            return;
        }

        int x2 = x + (int) (Math.cos(angle) * length);
        int y2 = y + (int) (Math.sin(angle) * length);

        g.drawLine(x, y, x2, y2);

        drawFractalTree(g, x2, y2, angle - ANGLE, length * LENGTH_FACTOR, depth - 1);
        drawFractalTree(g, x2, y2, angle + ANGLE, length * LENGTH_FACTOR, depth - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.getContentPane().add(new FractalTree());
        frame.setVisible(true);
    }
}
