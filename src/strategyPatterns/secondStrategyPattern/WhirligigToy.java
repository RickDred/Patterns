package strategyPatterns.secondStrategyPattern;

public class WhirligigToy implements Toy{
    @Override
    public double price() {
        return 4.45;
    }

    @Override
    public int minAge() {
        return 3;
    }

    public String[] colors() {
        return new String[]{"red", "yellow", "green"};
    }
}
