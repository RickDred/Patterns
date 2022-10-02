package strategyPatterns.secondStrategyPattern;

public class plushDogToy implements Toy{
    @Override
    public double price() {
        return 5.55;
    }

    @Override
    public int minAge() {
        return 0;
    }
}
