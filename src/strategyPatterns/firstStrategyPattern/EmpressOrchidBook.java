package strategyPatterns.firstStrategyPattern;

public class EmpressOrchidBook implements Book{
    @Override
    public String getName() {
        return "Empress Orchid";
    }

    @Override
    public String getAuthor() {
        return "Anchee Min";
    }

    @Override
    public String getDescription() {
        return "Empress Orchid (2004) is a novel by Anchee Min which was first published in Great Britain in 2004. It is written in first person and is a sympathetic account of the life of Empress Dowager Cixi - from her humble beginnings to her rise as the Empress Dowager.";
    }

    @Override
    public int getPageCount() {
        return 368;
    }

    public String isBasedOn() {
        return "true story";
    }
}
