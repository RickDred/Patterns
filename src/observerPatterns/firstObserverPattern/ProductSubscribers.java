package observerPatterns.firstObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class ProductSubscribers {
    Product product;
    private final List<Client> subscribers = new ArrayList<>();

    public ProductSubscribers(Product product) {
        this.product = product;
    }

    public boolean addSubscriber(Client client) {
        subscribers.add(client);
        return subscribers.contains(client);
    }

    public boolean removeSubscriber(Client client) {
        subscribers.remove(client);
        return !subscribers.contains(client);
    }

    public void notifyClients(String message) {
        for (Client client : subscribers) {
            System.out.println(client.getEmail() + "\n" + message + "\n");
        }
    }
}
