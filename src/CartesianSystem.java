

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class, which contains a constructor, and methods : "drawFunction", "safe".
 */
public class CartesianSystem {
    private int points;
    private int size;
    private int numbersOfStep;
    private int step;
    private int leftBorder;
    private int rightBorder;
    private int upBorder;
    private int downBorder;
    private BufferedImage bufferedImage;
    private Graphics2D g2d;

    /**
     * This constructor draws coordinate grid
     *
     * @param leftBorder defines left border
     * @param sizeOfCube defines the size of the square
     * @param size defines the size of the coordinate grid
     */
    public CartesianSystem(int leftBorder, int sizeOfCube, int size) {
        this.leftBorder = leftBorder;
        this.rightBorder = leftBorder + sizeOfCube;
        this.upBorder = sizeOfCube / 2;
        this.downBorder = (-1) * upBorder;
        this.size = size;
        this.points = (int) (size / 2);
        this.numbersOfStep = sizeOfCube + 2;

        String sx = "";
        String sy = "";
        step = size / (numbersOfStep);
        bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        g2d = bufferedImage.createGraphics();
        g2d.setFont(new Font("SansSerif", Font.BOLD, step / 2));
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, size, size);
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(size / 400));
        int countX = leftBorder;
        int countY = upBorder;
        for (int i = step; i <= size - step; i += step) {
            sx = String.valueOf(countX);
            sy = String.valueOf(countY);
            g2d.drawString(sx, i - 40, size - step + 12);
            countX ++;
            g2d.drawString(sy, 15, i + 8);
            countY --;
            g2d.drawLine(step, i, size - step, i);
            g2d.drawLine(i, step, i, size - step);
        }

        g2d.drawString("X", size - (int) (step * 0.8), (upBorder + 1) * step - step / 2);
        g2d.drawString("Y", (leftBorder * (-1) + 1) * step + step / 4, (int) (step * 0.8));
        if (leftBorder <= 0 && rightBorder >= 0 && upBorder > 0 && downBorder < 0) {
            g2d.setStroke(new BasicStroke(size / 200));
            g2d.drawLine((leftBorder * (-1) + 1) * step, step / 2, (leftBorder * (-1) + 1) * step, size - step);
            g2d.drawLine(step, (upBorder + 1) * step, size - step / 2, (upBorder + 1) * step);
            g2d.drawLine(size - step / 2, (upBorder + 1) * step, size - step * 3 / 4, (int) ((upBorder + 1 - 0.3) * step));
        }
    }

    /**
     * This method draws graph by x and y coordinates
     *
     * @param function functional interface
     * @param color defines graph color
     */
    public void drawFunction(IFunction function, Color color) {
        double[] xArray = new double[points + 1];
        double[] yArray = new double[points + 1];
        g2d.setColor(color);
        for (int j = 0; j <= points; j++) {
            xArray[j] = this.leftBorder + j * (float) numbersOfStep / points;
            yArray[j] = function.calculate(xArray[j]);
            if (yArray[j] > upBorder || yArray[j] < downBorder) {
                yArray[j] = 0.0 / 0.0;
            }
        }
        for (int i = 0; i < points; i++) {
            if (Double.isNaN(yArray[i + 1]) || Double.isNaN(yArray[i]) ||
                    Double.isInfinite(yArray[i + 1]) || Double.isInfinite(yArray[i])) {
                continue;
            } else {
                g2d.drawLine((int) (xArray[i] * step + (this.leftBorder * (-1) + 1) * step),
                        (int) ((-1) * yArray[i] * step + (upBorder + 1) * step),
                        (int) (xArray[i + 1] * step + (this.leftBorder * (-1) + 1) * step),
                        (int) ((-1) * yArray[i + 1] * step + (upBorder + 1) * step));
            }
        }
    }

    /**
     * This method saves image
     *
     * @param path specifies the path to image files
     * @param format defines the format of the graphic file
     * @throws IOException if can not find file of this type
     */
    public void safe(String path, String format) {
        File file = new File(path);
        try {
            ImageIO.write(bufferedImage, format, file);
        } catch (IOException e) {
            System.out.println("ImageIO.write error" + e.getMessage());
        }
    }
}

