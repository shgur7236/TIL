public class KrwCaculator implements ICalculator{

    private int price = 1;
    @Override
    public int sum(int x, int y) {
        x = x * price;
        y = y * price;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x = x * price;
        y = y * price;
        return x - y;
    }
}
