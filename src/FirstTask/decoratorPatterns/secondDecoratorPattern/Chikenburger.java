package FirstTask.decoratorPatterns.secondDecoratorPattern;

import java.util.ArrayList;
import java.util.List;

public class Chikenburger implements Burger{
    @Override
    public double getCost() {
        return 600;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("bun");
        ingredients.add("onion");
        ingredients.add("chicken patty");

        return ingredients;
    }
}
