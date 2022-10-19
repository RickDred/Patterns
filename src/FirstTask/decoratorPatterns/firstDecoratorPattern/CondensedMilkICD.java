package FirstTask.decoratorPatterns.firstDecoratorPattern;

import java.util.List;

public class CondensedMilkICD extends IceCreamDecorator{
    public CondensedMilkICD(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double getCost() {
        return super.getCost() + 15;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Condensed Milk");
        return ingredients;
    }
}
