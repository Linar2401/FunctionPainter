

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

    public CartesianSystem(int leftBorder, int sizeOfCube) {
        this.leftBorder = leftBorder;
        this.rightBorder = leftBorder+sizeOfCube;
        this.upBorder = sizeOfCube/2;
        this.downBorder = (-1)*upBorder;
        this.size = 880;
        this.points = (int)(size/2.5);

        String s = "";
        this.numbersOfStep = rightBorder-leftBorder;
        this.step = size /(this.numbersOfStep +2);
        this.bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        this.g2d = bufferedImage.createGraphics();
        g2d.setFont(new Font("SansSerif", Font.BOLD, step /2));
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, size, size);
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(size / 400));
        for (int i = step; i <= size - step; i += step) {
            double countX = Math.abs(rightBorder - leftBorder) / 20.0 + i / step + leftBorder;
//            g2d.drawString(s, 5, i + 8);
            double countY = Math.abs(rightBorder - leftBorder) / 20.0 + i / step + leftBorder;
//            g2d.drawString(s, i - 5, size - step + 12);
            s = String.valueOf(countX);
            g2d.drawLine(step, i, size - step, i);
            g2d.drawLine(i, step, i, size - step);
        }
        g2d.drawString("X", size - (int)(step *0.8), (this.leftBorder*(-1)+1)*step - step/4);
        g2d.drawString("Y", (this.leftBorder*(-1)+1)*step + step/4, (int)(step *0.8));
        if (this.leftBorder<=0 && this.rightBorder>=0){
            g2d.setStroke(new BasicStroke(size / 200));
            g2d.drawLine((this.leftBorder*(-1)+1)*step, step / 2, (this.leftBorder*(-1)+1)*step, size - step);
            g2d.drawLine(step, (this.leftBorder*(-1)+1)*step, size - step / 2, (this.leftBorder*(-1)+1)*step);
        }
    }

    public void drawFunction(IFunction function) {
        double[] xArray = new double[points + 1];
        double[] yArray = new double[points + 1];
        g2d.setColor(Color.red);
        for (int j = 0; j <= points; j++) {
            xArray[j] = this.leftBorder + j * (float) numbersOfStep / points;
            yArray[j] = function.calculate(xArray[j]);
        }
        for (int i = 0; i < points; i++) {
            if (Double.isNaN(yArray[i + 1]) || Double.isNaN(yArray[i]) || yArray[i] > upBorder || yArray[i+1] > upBorder
                    || yArray[i] < downBorder || yArray[i + 1] < downBorder) {
                continue;
            } else {
                g2d.drawLine((int) (xArray[i] * step + (this.leftBorder * (-1) + 1) * step), (int) ((-1) * yArray[i] * step + (this.leftBorder * (-1) + 1) * step),
                        (int) (xArray[i + 1] * step + (this.leftBorder * (-1) + 1) * step), (int) ((-1) * yArray[i + 1] * step + (this.leftBorder * (-1) + 1) * step));
            }
        }
    }
    public void safe(String path,String format){
        File file = new File(path);
        try {
            ImageIO.write(bufferedImage,format,file);
        }
        catch (IOException e){
            System.out.println("ImageIO.write error"+e.getMessage());}
            }
    }

