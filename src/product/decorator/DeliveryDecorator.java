package product.decorator;

import product.Product;
import product.decorator.Decorator;

public class DeliveryDecorator extends Decorator {
    public DeliveryDecorator(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return super.getPrice()*1.1;
    }
}
