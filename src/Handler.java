public class Handler {
    private CartesianSystem cartesianSystem = new CartesianSystem();
    private double[] arrayOfX = new double[100];
    private double[] arrayOfY = new double[100];
    private double step;
    public void Handler(int left, int right, Function f){
        this.step = Math.abs(right-left)/100;
        for (int i = 0; i < 100; i++){
            this.arrayOfX[i] = left + step*i;
            this.arrayOfY[i] = f.calculate(arrayOfX[i]);
        }
        // Вызов cartesianSystem(arrayOfX,arrayOfY,left,right)
    }

}
