public class Caculator {

    private ICalculator iCalculator;

    public Caculator(ICalculator iCalculator){
        this.iCalculator = iCalculator;
    }

    public int sum(int x, int y){
        return this.iCalculator.sum(x, y);
    }

    public int minus(int x, int y){
        return this.iCalculator.minus(x, y);
    }
}
