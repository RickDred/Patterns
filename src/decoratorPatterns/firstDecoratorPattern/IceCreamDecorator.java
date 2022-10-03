package decoratorPatterns.firstDecoratorPattern;

import java.util.List;

public class IceCreamDecorator implements IceCream{
    IceCream iceCream;

    public IceCreamDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public double getCost() {
        return iceCream.getCost();
    }

    @Override
    public List<String> getIngredients() {
        return iceCream.getIngredients();
    }
}
