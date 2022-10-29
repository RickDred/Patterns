package product.decorator;

import category.Category;
import client.Client;
import product.Product;
import product.decorator.Decorator;

public class DeliveryDecorator extends Decorator {
    public DeliveryDecorator(Product product) {
        super(product);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isInStock() {
        return false;
    }

    @Override
    public void setInStock(boolean inStock) {

    }

    @Override
    public double getPrice() {
        return super.getPrice()*1.1;
    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public int addClient(Client client) {
        return 0;
    }

    @Override
    public int removeClient(Client client) {
        return 0;
    }
}
