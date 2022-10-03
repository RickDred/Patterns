package decoratorPatterns.secondDecoratorPattern;

import java.util.ArrayList;
import java.util.List;

public class Cheeseburger implements Burger{
    @Override
    public double getCost() {
        return 900;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("bun");
        ingredients.add("onion");
        ingredients.add("patty");
        ingredients.add("tomatoes");
        ingredients.add("cheese");
        return ingredients;
    }
}
