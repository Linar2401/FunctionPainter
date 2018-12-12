

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CartesianSystem {
    private final int SIZE = 880;
    private int step;
    private final int POINTS = 100;
    private int NumbersOfStep;

    private int leftBorder;
    private int rightBorder;

    public CartesianSystem(int leftBorder, int rightBorder) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.NumbersOfStep = rightBorder-leftBorder;
        this.step = SIZE/(this.NumbersOfStep+2);
    }

    public void drawSystem(ISystem function) {
        String s = "";
        BufferedImage bufferedImage = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setFont(new Font("SansSerif", Font.BOLD, step /2));
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, SIZE, SIZE);
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(SIZE / 400));
        for (int i = step; i <= SIZE - step; i += step) {
            double countX = Math.abs(rightBorder - leftBorder) / 20.0 + i / step + leftBorder;
//            g2d.drawString(s, 5, i + 8);
            double countY = Math.abs(rightBorder - leftBorder) / 20.0 + i / step + leftBorder;
//            g2d.drawString(s, i - 5, SIZE - step + 12);
            s = String.valueOf(countX);
            g2d.drawLine(step, i, SIZE - step, i);
            g2d.drawLine(i, step, i, SIZE - step);
        }
            g2d.drawString("X", SIZE - (int)(step *0.8), (this.leftBorder*(-1)+1)*step - step/4);
            g2d.drawString("Y", (this.leftBorder*(-1)+1)*step + step/4, (int)(step *0.8));
            if (this.leftBorder<0&&this.rightBorder>0){
                g2d.setStroke(new BasicStroke(SIZE / 200));
                g2d.drawLine((this.leftBorder*(-1)+1)*step, step / 2, (this.leftBorder*(-1)+1)*step, SIZE - step);
                g2d.drawLine(step, (this.leftBorder*(-1)+1)*step, SIZE - step / 2, (this.leftBorder*(-1)+1)*step);
            }
            double[] xArray = new double[POINTS+1];
            double[] yArray = new double[POINTS+1];
            g2d.setColor(Color.red);
            for (int j =0; j <= POINTS; j++ ) {
                xArray [j] = this.leftBorder+j*(float)NumbersOfStep/POINTS;
                yArray [j] = function.Calculate(xArray[j]);
            }
            for (int i = 0; i < POINTS; i++){
                g2d.drawLine((int)(xArray[i]* step +(this.leftBorder*(-1)+1)*step),(int)((-1)*yArray[i]* step +(this.leftBorder*(-1)+1)*step),
                        (int)(xArray[i+1]* step +(this.leftBorder*(-1)+1)*step),(int)((-1)*yArray[i+1]* step +(this.leftBorder*(-1)+1)*step));
            }
            File file = new File("ResultImage/image.bmp");
            try {
                ImageIO.write(bufferedImage,"bmp",file);
            }
            catch (IOException e){
                System.out.println("ImageIO.write error"+e.getMessage());
            }
        }
    }

