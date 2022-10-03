import strategyPatterns.firstStrategyPattern.*;
import strategyPatterns.secondStrategyPattern.*;
import observerPatterns.firstObserverPattern.*;
import observerPatterns.secondObserverPattern.*;
import decoratorPatterns.firstDecoratorPattern.*;

public class Main {

    public static void main(String[] args) {
    }

    public static void checkFirstStrategyPattern() {
        Book book1 = new EmpressOrchidBook();
        Book book2 = new Fahrenheit451Book();
        Book book3 = new MartinEdenBook();
        BookPrinter bookPrinter = new BookPrinter(book1);

        bookPrinter.Print();

        bookPrinter.setBook(book2);

        bookPrinter.Print();

        bookPrinter.Print(book3);

//        System.out.println(book1.name());
//        System.out.println((book1.isBasedOn()) + "\n");
//        System.out.println(book2.name());
//        System.out.println(book2.author() + "\n");
//        System.out.println(book3.name());
//        System.out.println(book3.description());
//        System.out.println(((MartinEdenBook)book3).getMainCharacterName());
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

    public static void checkSecondObserverPattern() {
        Employee employee1 = new Employee("ERick");
        Employee employee2 = new Employee("Kiril");
        Employee employee3 = new Employee("Adil", "manager");

        ShopCenter shopCenter1 = new ShopCenter("internetShop");
        ShopCenter shopCenter2 = new ShopCenter("Caffe");

        employee1.subscribeToShopCenter(shopCenter1);
        employee1.subscribeToShopCenter(shopCenter2);
        employee2.subscribeToShopCenter(shopCenter1);
        employee3.subscribeToShopCenter(shopCenter1);
        employee3.subscribeToShopCenter(shopCenter2);

        Vacancy vacancy1 = new Vacancy("cashier", 100);
        shopCenter1.addVacancy(vacancy1);
        shopCenter2.addVacancy("manager", 500, "take money", "you should be human");
        shopCenter1.addVacancy("doctor", 121);

        employee1.unsubscribeToShopCenter(shopCenter1);

        shopCenter1.removeVacancy(vacancy1);

        employee2.mySubscriptions();
    }

    public static void checkFirstDecoratorPattern() {
        IceCream iceCream1 = new VanillaIceCream();
        iceCream1 = new CaramelICD(iceCream1);
        iceCream1 = new ChocolateICD(iceCream1);

        System.out.print("ice cream1 cost's: " + iceCream1.getCost() + "\nice cream1 ingredients: ");
        for(int i = 0; i < iceCream1.getIngredients().size(); i++) {
            System.out.print(iceCream1.getIngredients().get(i) + " ");
        }
        System.out.println("");

        IceCream iceCream2 = new CaramelICD(new FruitICD(new ChocolateICD(new CondensedMilkICD(new ChocolateIceCream()))));

        System.out.print("ice cream2 cost's: " + iceCream2.getCost() + "\nice cream2 ingredients: ");
        for(int i = 0; i < iceCream2.getIngredients().size(); i++) {
            System.out.print(iceCream2.getIngredients().get(i) + " ");
        }
    }
}
