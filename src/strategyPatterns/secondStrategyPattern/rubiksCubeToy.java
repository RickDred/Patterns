package strategyPatterns.secondStrategyPattern;

public class rubiksCubeToy implements Toy{
    @Override
    public double price() {
        return 49.99;
    }

    @Override
    public int minAge() {
        return 8;
    }

    public double size() {
        return 5.6;
    }

    public String type() {
        return "3x3x3";
    }
}
