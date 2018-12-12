//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//
//
//public class TestSystem {
//    public static void main (String[] args) throws IOException {
//        final int height =800;
//        final int step = height / 20;
//        double leftBorder = 10;
//        double rightBorder = 40;
//        String s = "";
//        BufferedImage bufferedImage = new BufferedImage(height, height, BufferedImage.TYPE_INT_RGB);
//        Graphics2D g2d = bufferedImage.createGraphics();
//        g2d.setColor(Color.white);
//        g2d.fillRect(0, 0, height, height);
//        g2d.setColor(Color.black);
//        for (int i = step; i <= height - step; i += step) {
//            double countX = Math.abs(rightBorder - leftBorder) / 20.0 + i / step + leftBorder;
//            s = String.valueOf(countX);
//            double countY = Math.abs(rightBorder - leftBorder) / 20.0 + i / step + leftBorder;
//            s = String.valueOf(countY);
//            g2d.drawLine(step, i, height - step, i);
//            g2d.drawLine(i, step, i, height - step);
//            g2d.drawString(s, 5, i + 8);
//            g2d.drawString(s, i - 5, height - step + 12);
//        }
//        g2d.setStroke(new BasicStroke(2.0f));
//        g2d.drawLine(height / 2, step / 2, height / 2, height - step);
//        g2d.drawLine(step, height / 2, height - step / 2, height / 2);
//        g2d.drawString("X", height - 10, height / 2 - 5);
//        g2d.drawString("Y", height / 2 + 5, 10);
////        final int nPoint = 100; необходимая нам точность в построении, (угловатость графика)
////        int[nPoint] xArray = {}; Здесь будут параметры, которые мы будем получать из метода интерфейса
////        int[nPoint] yArray = {};
////        g.setColor(Color.blue);
////        g.drawPolyline(xArray, yArray, nPoint);
////        g.setColor(Color.black);
////        g.drawString("y = f(x)",,); хз как подписать график (необходимо узнать позицию постановки надписи)
//        g2d.dispose();
//        File file = new File("ResultImage/PngImage.png");
//        ImageIO.write(bufferedImage, "png", file);
//        file = new File("ResultImage/JpgImage.jpg");
//        ImageIO.write(bufferedImage, "jpg", file);
//    }
//}
