package decoratorPatterns.secondDecoratorPattern;

import java.util.List;

public class BeefDecorator extends BurgerDecorator{
    public BeefDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public double getCost() {
        return super.getCost() + 50;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("beef");
        return ingredients;
    }
}
