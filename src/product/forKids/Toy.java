package product.forKids;

import category.Category;
import client.Client;
import product.Notifications;
import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Toy extends Notifications implements Product {
    private String name;
    private double price;
    private Category category;
    private boolean inStock;

    public Toy(String name) {
        super();
        setName(name);
        setCategory(new Category("forKids"));
        setInStock(false);
    }

    public Toy(String name, double price) {
        this(name);
        setPrice(price);
    }

    public Toy(String name, double price, boolean inStock) {
        this(name, price);
        setInStock(true);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isInStock() {
        return inStock;
    }

    @Override
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        notifyAllSubscribers("price is lower now! Hurry up");
        this.price = price;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    private void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", inStock=" + inStock +
                ", subscribers=" + getSubscribers().size() +
                '}';
    }
}
