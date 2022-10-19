package FirstTask.decoratorPatterns.firstDecoratorPattern;

import java.util.List;

public class FruitICD extends IceCreamDecorator{
    public FruitICD(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double getCost() {
        return super.getCost() + 50;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Fruit");
        return ingredients;
    }
}
