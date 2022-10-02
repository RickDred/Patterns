package strategyPatterns.secondStrategyPattern;

public class PlushDogToy implements Toy{
    @Override
    public double price() {
        return 5.55;
    }

    @Override
    public int minAge() {
        return 0;
    }
}
