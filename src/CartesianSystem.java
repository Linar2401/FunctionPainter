import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CartesianSystem {
    private final int SIZE = 800;
    private final int STEP = SIZE / 20;
    private final int POINTS = 100;

    private int leftBorder;
    private int rightBorder;

    public CartesianSystem(int leftBorder, int rightBorder) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
    }

    public void drawSystem(Function function) {
        String s = "";
        BufferedImage bufferedImage = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, SIZE, SIZE);
        g2d.setColor(Color.black);
        for (int i = STEP; i <= SIZE - STEP; i += STEP) {
            double countX = Math.abs(rightBorder - leftBorder) / 20.0 + i / STEP + leftBorder;
//            g2d.drawString(s, 5, i + 8);
            double countY = Math.abs(rightBorder - leftBorder) / 20.0 + i / STEP + leftBorder;
//            g2d.drawString(s, i - 5, SIZE - STEP + 12);
            s = String.valueOf(countX);
            g2d.drawLine(STEP, i, SIZE - STEP, i);
            g2d.drawLine(i, STEP, i, SIZE - STEP);
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.drawLine(SIZE / 2, STEP / 2, SIZE / 2, SIZE - STEP);
            g2d.drawLine(STEP, SIZE / 2, SIZE - STEP / 2, SIZE / 2);
            g2d.drawString("X", SIZE - 10, SIZE / 2 - 5);
            g2d.drawString("Y", SIZE / 2 + 5, 10);
            int [] xArray = new int[POINTS];
            int [] yArray = new int[POINTS];
            for (int j = 1; j <= SIZE; ++j) {
                xArray [j] = j;
                yArray [j] = function.Calculate(j);
            }
        }
    }
}
