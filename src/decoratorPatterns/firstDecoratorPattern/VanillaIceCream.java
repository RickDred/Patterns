package decoratorPatterns.firstDecoratorPattern;

import java.util.ArrayList;
import java.util.List;

public class VanillaIceCream implements IceCream{
    @Override
    public double getCost() {
        return 100;
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<String>();
    }
}
