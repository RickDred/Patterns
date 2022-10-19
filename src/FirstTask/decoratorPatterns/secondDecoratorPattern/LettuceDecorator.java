package FirstTask.decoratorPatterns.secondDecoratorPattern;

import java.util.List;

public class LettuceDecorator extends BurgerDecorator{
    public LettuceDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public double getCost() {
        return super.getCost() + 15;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("lettuce");
        return ingredients;
    }
}
