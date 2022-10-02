package strategyPatterns.firstStrategyPattern;

public class Fahrenheit451Book implements Book{
    @Override
    public String name() {
        return "Fahrenheit 451";
    }

    @Override
    public String author() {
        return "Ray Bradbury";
    }

    @Override
    public String description() {
        return "Fahrenheit 451 is a 1953 dystopian novel by American writer Ray Bradbury. Often regarded as one of his best works, Fahrenheit 451 presents an American society where books have been outlawed and \"firemen\" burn any that are found.";
    }

    @Override
    public int pageCount() {
        return 256;
    }

    public String getMainCharacterName() {
        return "Guy Montag";
    }
}
