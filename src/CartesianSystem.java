import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class CartesianSystem {
    public static void main(String[] args) throws IOException {
        final int width = 800;
        final int height = 800;
        final int step = width/20;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.black);
        for (int i = 0; i < width; i += step) {
            g2d.drawLine(i, 0, i, height);
        }
        for (int i = 0; i < width; i += step) {
            g2d.drawLine(0, i, width, i);
        }
        g2d.setStroke(new BasicStroke(2.0f));
        g2d.drawLine(width / 2, 0, width / 2, height);
        g2d.drawLine(0, height / 2, width, height / 2);
        g2d.drawString("X", width - 10, height / 2 - 5);
        g2d.drawString("Y", width / 2 + 5, 10);
//        int[] xArray = {}; Здесь будут параметры, которые мы будем получать из метода интерфейса
//        int[] yArray = {};
//        int nPoint = eps; необходимая нам точность в построении, (угловатость графика)
//        g.setColor(Color.blue);
//        g.drawPolyline(xArray, yArray, nPoint);
//        g.setColor(Color.black);
//        g.drawString("y = f(x)",,); хз как подписать график (необходимо узнать позиуию постановки надписи)
        g2d.dispose();
        File file = new File("D://Projects/FunctionsPainter/ResultImage/PngImage.png");
        ImageIO.write(bufferedImage, "png", file);
        file = new File("D://Projects/FunctionsPainter/ResultImage/JpgImage.jpg");
        ImageIO.write(bufferedImage, "jpg", file);
    }
}
