package decoratorPatterns.firstDecoratorPattern;

import java.util.List;

public class ChocolateICD extends IceCreamDecorator{
    public ChocolateICD(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double getCost() {
        return super.getCost() + 25;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Chocolate");
        return ingredients;
    }
}
