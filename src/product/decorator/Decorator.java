package product.decorator;

import product.Product;

public abstract class Decorator implements Product {
    Product product;

    public Decorator(Product product) {
        this.product = product;
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }
}
