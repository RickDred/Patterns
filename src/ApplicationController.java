import Database.DB;
import category.Category;
import client.Client;
import product.Product;
import product.decorator.DeliveryDecorator;
import product.forKids.Toy;
import product.technique.AppleComputer;
import product.technique.AppleSmartphone;
import product.technique.SamsungComputer;
import product.technique.SamsungSmartphone;
import product.technique.abstractTechnique.Technique;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationController {
    private Scanner in;
    private Client user;
    private DB db;
    private ArrayList<Product> products;
    private ArrayList<Category> categories;
    private ArrayList<Product> cart;

    public void startApp() {
        db = DB.getInstance();
        in = new Scanner(System.in);
        System.out.println("=========================================================================");
        System.out.println("Hello! Welcome to our console shop app!");
        products = new ArrayList<>();
        categories = new ArrayList<>();
        cart = new ArrayList<>();
        initShop();
        account();
    }

    private void account() {
        System.out.println("=========================================================================");
        System.out.println("Please, choose an action:");
        System.out.println("1. Log in");
        System.out.println("2. Log on (not available)");
        System.out.println("0. Close app");

        int input = in.nextInt();

        switch (input) {
            case 0 -> exit();
            case 1 -> register();
            case 2 -> System.out.println("Sorry, this function not available yet");
            default -> System.out.println("Sorry, try again");
        }

        account();
    }

    private void register() {
        System.out.println("=========================================================================");
        System.out.println("Register page");
        System.out.println("0. Back");
        System.out.println("Write your email:");

        String input = in.next();

        if(input.equals("0")) return;

        String email = input;

        System.out.println("=========================================================================");
        System.out.println("0. Back");
        System.out.println("1. Skip");
        System.out.println("Write your name:");

        input = in.next();

        if(input.equals("0")) return;

        if(input.equals("1")) {
            user = new Client(email);
        }
        else {
            user = new Client(input, email);
        }
        db.clientDB.addClient(user);
        System.out.println(user.getName() + " account with email " + user.getEmail() + " created");
        mainMenu();
    }

    private void mainMenu() {
        System.out.println("=========================================================================");
        System.out.println("0. Close app");
        System.out.println("1. Log out");
        System.out.println("2. Get all products");
        System.out.println("3. Search");
        System.out.println("4. Get all categories");
        System.out.println("5. Cart");

        int input = in.nextInt();

        switch (input) {
            case 0 -> exit();
            case 1 -> logOut();
            case 2 -> getAllProducts();
            case 3 -> searchProduct();
            case 4 -> getAllCategories();
            case 5 -> cartPage();
            default -> System.out.println("Try again");
        }
        mainMenu();
    }

    private void getAllProducts() {
        System.out.println("=========================================================================");
        System.out.println("0. Exit");
        System.out.println("1. Back to menu");
        int k = 2;
        for(Product product: products) {
            System.out.println((k++) + ". " + product.getName() + " - " + product.getPrice());
        }

        int input = in.nextInt();

        if(input == 0) exit();
        else if(input == 1) mainMenu();
        else {
            for (int i = 2; i < products.size() + 1; i++) {
                if(input == i) {
                    getProductPage(products.get(i - 2));
                    break;
                }
            }
            System.out.println("Try again");
        }

        getAllProducts();
    }

    private void searchProduct() {
    }

    private void getAllCategories() {
    }

    private void getProductPage(Product product) {
        System.out.println("=========================================================================");
        System.out.println("Product page");
        System.out.println("name: " + product.getName());
        System.out.println("price: " + product.getPrice());
        System.out.println("category: " + product.getCategory().getName());
        System.out.println("is in stock: " + product.isInStock());
        productPageAction(product);
    }

    private void getProductPage(Technique product) {
        System.out.println("=========================================================================");
        System.out.println("Product page");
        System.out.println("name: " + product.getName());
        System.out.println("price: " + product.getPrice());
        System.out.println("category: " + product.getCategory().getName());
        System.out.println("company: " + product.getCompany().getName());
        System.out.println("is in stock: " + product.isInStock());
        productPageAction(product);
    }

    private void productPageAction(Product product) {
        System.out.println("=========================================================================");
        System.out.println("0. Exit");
        System.out.println("1. Back to menu");
        System.out.println("2. Subscribe/Unsubscribe to product");
        System.out.println("3. Add to cart(without delivery)");
        System.out.println("4. Add to cart(with delivery - 10%)");
        System.out.println("5. Back to catalog");

        int input = in.nextInt();

        switch (input) {
            case 0 -> exit();
            case 1 -> mainMenu();
            case 2 -> subscribeControl(product);
            case 3 -> cart.add(product);
            case 4 -> cart.add(new DeliveryDecorator(product));
            case 5 -> {return;}
            default -> System.out.println("Try again");
        }

        getProductPage(product);
    }

    private void cartPage() {
        double price = 0;
        System.out.println("=========================================================================");
        System.out.println("In your cart:");
        for(int i = 1; i <= cart.size(); i++) {
            System.out.println(i + ". " + cart.get(i-1).getName() + " - " + cart.get(i-1).getPrice());
            price += cart.get(i-1).getPrice();
        }
        System.out.println("Total price: " + price);
        System.out.println("=========================================================================");
        System.out.println("0. Exit");
        System.out.println("1. Back to menu");

        int input = in.nextInt();

        switch (input) {
            case 0 -> exit();
            case 1 -> logOut();
            default -> System.out.println("Try again");
        }

        cartPage();
    }

    private void subscribeControl(Product product) {
        boolean is = false;
        int ok = product.addClient(user);
        if(ok == -1) {
            if(product.removeClient(user) == 1) {
                System.out.println("You successfully unsubscribe from " + product.getName());
                return;
            }
        }
        else {
            if(ok == 1) {
                System.out.println("You successfully subscribe to " + product.getName());
                return;
            }
        }
        System.out.println("Something get wrong");
    }

    private void exit() {
        System.out.println("=========================================================================");
        System.out.println("Are you sure you want to close app?");
        System.out.println("0. Yes");
        System.out.println("1. No");

        int input = in.nextInt();

        if(input == 0) {
            db.closeConnection();
            System.exit(0);
        }
        if(input == 1) {
            return;
        }
        System.out.println("Try again");
        exit();
    }

    private void logOut() {
        System.out.println("=========================================================================");
        System.out.println("Are you sure that you want to log out?");
        System.out.println("0. Yes");
        System.out.println("1. No");

        int input = in.nextInt();

        if(input == 0) {
            user = null;
            account();
        }
        if(input == 1) {
            return;
        }
        System.out.println("Try again");
        logOut();
    }

    private void initShop() {
        categories.add(new Category("technique"));
        categories.add(new Category("forKids"));

        products.add(new SamsungComputer("SamsungComputerModel1", 10000, true));
        products.add(new SamsungComputer("SamsungComputerModel2", 11000, false));
        products.add(new AppleComputer("AppleComputerModel1", 15000, false));
        products.add(new AppleComputer("AppleComputerModel2", 16000, true));
        products.add(new SamsungSmartphone("Samsung Galaxy G8", 5000, true));
        products.add(new SamsungSmartphone("Samsung A10 pro", 7000, true));
        products.add(new AppleSmartphone("Iphone 11", 9000, true));
        products.add(new AppleSmartphone("Iphone 12", 9900, true));

        products.add(new Toy("Plush beer toy", 50, true));
        products.add(new Toy("Car toy", 70, false));
        products.add(new Toy("Barbie", 150, true));
        products.add(new Toy("Iron man", 200, true));
    }
}
