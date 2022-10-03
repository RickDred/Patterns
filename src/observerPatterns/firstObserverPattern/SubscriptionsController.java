package observerPatterns.firstObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionsController {
    private final Client client;
    private final List<Product> products = new ArrayList<>();

    public SubscriptionsController(Client client) {
        this.client = client;
    }

    public boolean addSubscription(Product product) {
        if(product.getSubscribers().addSubscriber(client)) {
            products.add(product);
            return products.contains(product);
        }
        return false;
    }

    public String getSubscriptions() {
        StringBuilder subs = new StringBuilder(client.getEmail() + " subscriptions: { \n");
        for (Product product: products) {
            subs.append(product.toString()).append("\n");
        }
        subs.append("} \n");
        return subs.toString();
    }

    public boolean removeSubscription(Product product) {
        if(product.getSubscribers().removeSubscriber(client)) {
            products.remove(product);
            return !products.contains(product);
        }
        return false;
    }
}
