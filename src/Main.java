import strategyPatterns.firstStrategyPattern.*;
import strategyPatterns.secondStrategyPattern.*;
import observerPatterns.firstObserverPattern.*;

public class Main {

    public static void main(String[] args) {
    }

    public static void checkFirstStrategyPattern() {
        EmpressOrchidBook book1 = new EmpressOrchidBook();
        Book book2 = new Fahrenheit451Book();
        Book book3 = new MartinEdenBook();

        System.out.println(book1.name());
        System.out.println((book1.isBasedOn()) + "\n");
        System.out.println(book2.name());
        System.out.println(book2.author() + "\n");
        System.out.println(book3.name());
        System.out.println(book3.description());
        System.out.println(((MartinEdenBook)book3).getMainCharacterName());
    }

    public static void checkSecondStrategyPattern() {
        Toy toy1 = new PlushDogToy();
        RubiksCubeToy toy2 = new RubiksCubeToy();
        Toy toy3 = new WhirligigToy();

        System.out.println(toy1.price() + "\n");
        System.out.println(toy2.minAge());
        System.out.println(toy2.size());
        System.out.println(toy2.type() + "\n");
        for(int i = 0; i < ((WhirligigToy)toy3).colors().length; i++) {
            System.out.println(((WhirligigToy)toy3).colors()[i]);
        }
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
