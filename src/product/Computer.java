package product;

import category.Category;
import client.Client;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Product, Notifications{
    private String name;
    private double price;
    private Category category;
    private boolean inStock;
    private final List<Client> subscribers;

    public Computer(String name, Category category) {
        this.name = name;
        this.category = category;
        setInStock(false);
        subscribers = new ArrayList<>();
    }

    public Computer(String name, double price, Category category) {
        this(name, category);
        setPrice(price);
    }

    public Computer(String name, double price, Category category, boolean inStock) {
        this(name, price, category);
        setInStock(true);
    }

    @Override
    public String getName() {
        return name;
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
        this.price = price;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public int addClient(Client client) {
        if(subscribers.contains(client)) return -1;
        subscribers.add(client);
        if(subscribers.contains(client)) return 1;
        return 0;
    }

    @Override
    public int removeClient(Client client) {
        if(!subscribers.contains(client)) return -1;
        subscribers.remove(client);
        if(!subscribers.contains(client)) return 1;
        return 0;
    }

    @Override
    public void notifyAllSubscribers(String message) {
        for (Client client : subscribers) {
            System.out.println(client.getName() + ": " + message);
        }
//        return name + ": " + message;
    }
}
