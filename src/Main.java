
public class Main {

    public static void main(String[] args) {
        CartesianSystem system = new CartesianSystem(-10, 10);
        system.drawFunction((x) -> (x * x));
    }
}