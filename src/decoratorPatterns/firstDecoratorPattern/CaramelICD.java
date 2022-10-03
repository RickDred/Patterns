package decoratorPatterns.firstDecoratorPattern;

import java.util.List;

public class CaramelICD extends IceCreamDecorator{
    public CaramelICD(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double getCost() {
        return super.getCost() + 20;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Caramel");
        return ingredients;
    }
}
