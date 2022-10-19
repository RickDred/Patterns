package FirstTask.strategyPatterns.firstStrategyPattern;

public class EmpressOrchidBook implements Book{
    @Override
    public String name() {
        return "Empress Orchid";
    }

    @Override
    public String author() {
        return "Anchee Min";
    }

    @Override
    public String description() {
        return "Empress Orchid (2004) is a novel by Anchee Min which was first published in Great Britain in 2004. It is written in first person and is a sympathetic account of the life of Empress Dowager Cixi - from her humble beginnings to her rise as the Empress Dowager.";
    }

    @Override
    public int pageCount() {
        return 368;
    }

    public String isBasedOn() {
        return "true story";
    }
}
