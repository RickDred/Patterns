package decoratorPatterns.secondDecoratorPattern;

import java.util.List;

public class BurgerDecorator implements Burger{
    Burger burger;

    public BurgerDecorator(Burger burger) {
        this.burger = burger;
    }

    @Override
    public double getCost() {
        return burger.getCost();
    }

    @Override
    public List<String> getIngredients() {
        return burger.getIngredients();
    }
}
