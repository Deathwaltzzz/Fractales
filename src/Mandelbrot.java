import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Mandelbrot extends JPanel {

    private static final int WIDTH = 800;     // Width of the image
    private static final int HEIGHT = 800;    // Height of the image
    private static final int MAX_ITER = 500; // Maximum number of iterations
    private static final double ZOOM = 300;   // Zoom level

    private BufferedImage image;              // Image buffer

    public Mandelbrot() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        calculateMandelbrot();
    }

    private void calculateMandelbrot() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                double zx, zy, cX, cY;
                zx = zy = 0;
                cX = (x - WIDTH / 2) / ZOOM;
                cY = (y - HEIGHT / 2) / ZOOM;
                int iter = MAX_ITER;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    double tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }
                int color = iter | (iter << 8);
                image.setRGB(x, y, color);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mandelbrot Fractal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new Mandelbrot());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
