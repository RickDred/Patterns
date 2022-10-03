package decoratorPatterns.secondDecoratorPattern;

import java.util.List;

public class TomatoDecorator extends BurgerDecorator{
    public TomatoDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public double getCost() {
        return super.getCost() + 10;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("tomato");
        return ingredients;
    }
}
