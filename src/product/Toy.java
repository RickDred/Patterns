package product;

import category.Category;
import client.Client;

import java.util.ArrayList;
import java.util.List;

public class Toy implements Product {
    private String name;
    private double price;
    private Category category;
    private boolean inStock;
    private final List<Client> subscribers;

    public Toy(String name, Category category) {
        setName(name);
        setCategory(category);
        setInStock(false);
        subscribers = new ArrayList<>();
    }

    public Toy(String name, double price, Category category) {
        this(name, category);
        setPrice(price);
    }

    public Toy(String name, double price, Category category, boolean inStock) {
        this(name, price, category);
        setInStock(true);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        notifyAllSubscribers("price is lower now! Hurry up");
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    private void setCategory(Category category) {
        this.category = category;
    }

    // Subscribers
    public int addClient(Client client) {
        if(subscribers.contains(client)) return -1;
        subscribers.add(client);
        if(subscribers.contains(client)) return 1;
        return 0;
    }

    public int removeClient(Client client) {
        if(!subscribers.contains(client)) return -1;
        subscribers.remove(client);
        if(!subscribers.contains(client)) return 1;
        return 0;
    }

//     Notifications
    public void notifyAllSubscribers(String message) {
        for (Client client : subscribers) {
            System.out.println(client.getName() + ": " + message);
        }
//        return name + ": " + message;
    }

//    public String notifyOneSubscriber(String message) {
//
//        return message;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", inStock=" + inStock +
                ", subscribers=" + subscribers +
                '}';
    }
}
