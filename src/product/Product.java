package product;

import category.Category;
import client.Client;

public interface Product {
    String getName();

    boolean isInStock();

    void setInStock(boolean inStock);

    double getPrice();

    void setPrice(double price);

    Category getCategory();

    // Subscribers
    int addClient(Client client);

    int removeClient(Client client);

}
