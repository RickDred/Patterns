package strategyPatterns.firstStrategyPattern;

public class Fahrenheit451Book implements Book{
    @Override
    public String getName() {
        return "Fahrenheit 451";
    }

    @Override
    public String getAuthor() {
        return "Ray Bradbury";
    }

    @Override
    public String getDescription() {
        return "Fahrenheit 451 is a 1953 dystopian novel by American writer Ray Bradbury. Often regarded as one of his best works, Fahrenheit 451 presents an American society where books have been outlawed and \"firemen\" burn any that are found.";
    }

    @Override
    public int getPageCount() {
        return 256;
    }

    public String getMainCharacterName() {
        return "Guy Montag";
    }
}
