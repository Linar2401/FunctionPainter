import java.awt.*;

/**
 * @version 1.0
 */
public class Main {

    /**
     * Program entry point.
     * Example of using
     * @param args comand line args
     */
    public static void main(String[] args) {
        CartesianSystem system = new CartesianSystem(-10, 20, 880);
        system.drawFunction((x) -> (x * x), Color.red);
        system.safe("ResultImages/Image.png","png");
    }
}