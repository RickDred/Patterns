package strategyPatterns.firstStrategyPattern;

public class MartinEdenBook implements Book{
    @Override
    public String getName() {
        return "Martin Eden";
    }

    @Override
    public String getAuthor() {
        return "Jack London";
    }

    @Override
    public String getDescription() {
        return "The semiautobiographical Martin Eden is the most vital and original character Jack London ever created. Set in San Francisco, this is the story of Martin Eden, an impoverished seaman who pursues, obsessively and aggressively, dreams of education and literary fame.";
    }

    @Override
    public int getPageCount() {
        return 482;
    }

    public String getMainCharacterName() {
        return "Martin Eden";
    }
}
