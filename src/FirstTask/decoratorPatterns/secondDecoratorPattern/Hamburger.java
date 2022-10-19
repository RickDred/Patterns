package FirstTask.decoratorPatterns.secondDecoratorPattern;

import java.util.ArrayList;
import java.util.List;

public class Hamburger implements Burger{
    @Override
    public double getCost() {
        return 800;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("bun");
        ingredients.add("onion");
        ingredients.add("patty");
        ingredients.add("tomatoes");
        return ingredients;
    }
}
