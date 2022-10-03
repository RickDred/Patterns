package decoratorPatterns.firstDecoratorPattern;

import java.util.ArrayList;
import java.util.List;

public class ChocolateIceCream implements IceCream{
    @Override
    public double getCost() {
        return 111;
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<String>();
    }
}
