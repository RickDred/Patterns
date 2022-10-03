package observerPatterns.firstObserverPattern;

public class Client {
    private String email;
    private final SubscriptionsController subscriptions = new SubscriptionsController(this);

    public Client(String email){
        setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void subscribe(Product product) {
        if(subscriptions.addSubscription(product)) System.out.println(email + " thank you to subscribe to " + product.getName());
        else System.out.println("Something get wrong");
    }

    public void mySubscriptions() {
        System.out.println(subscriptions.getSubscriptions());
    }

    public void unSubscribe(Product product) {
        if(subscriptions.removeSubscription(product)) System.out.println(email + " you have unsubscribed from " + product.getName());
        else System.out.println("Something get wrong");
    }
}
