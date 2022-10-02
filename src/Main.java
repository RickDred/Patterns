import strategyPatterns.firstStrategyPattern.*;
import strategyPatterns.secondStrategyPattern.*;
import observerPatterns.firstObserverPattern.*;

public class Main {

    public static void main(String[] args) {
        checkFirstObserverPattern();
    }
    public static void checkFirstObserverPattern() {
        Client client1 = new Client("client1@gmail.com");
        Client client2 = new Client("client2@gmail.com");
        Client client3 = new Client("client3@gmail.com");
        Product product1 = new Product("plush toy",5.45, true);
        Product product2 = new Product("car", 10, false);
        Product product3 = new Product("barbie",100);

        client1.subscribe(product1);
        client1.subscribe(product2);
        client1.subscribe(product3);
        client2.subscribe(product2);
        client3.subscribe(product3);

        client1.mySubscriptions();

        product1.setPrice(6);
        product1.setInStock(false);
        product2.setPrice(9.99);
        product2.setInStock(true);

        client3.unSubscribe(product3);
    }
}
