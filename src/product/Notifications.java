package product;

import client.Client;

import java.util.ArrayList;
import java.util.List;

public abstract class Notifications {
    private final ArrayList<Client> subscribers;

    public Notifications() {
        subscribers = new ArrayList<>();
    }

    public ArrayList<Client> getSubscribers() {
        return subscribers;
    }

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
    //     product.Notifications

    public void notifyAllSubscribers(String message) {
        for (Client client : subscribers) {
            System.out.println(client.getName() + ": " + message);
        }
//        return name + ": " + message;
    }
}
