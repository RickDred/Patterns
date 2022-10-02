package observerPatterns.firstObserverPattern;

public class Product {
    public void setSubscribers(ProductSubscribers subscribers) {
        this.subscribers = subscribers;
    }

    private String name;
    private double price;
    private boolean isInStock;
    private ProductSubscribers subscribers = new ProductSubscribers(this);

    public Product(String name, double price) {
        setName(name);
        setPrice(price);
        setInStock(true);
    }

    public Product(String name, double price, boolean isInStock) {
        this(name, price);
        setInStock(isInStock);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < this.price) {
            onDataChange("Hey, the price just got cheaper!!!\nHurry up and buy this product in our shop");
        }
        else {
            onDataChange("The price of this product is going up right now!!!\nHurry up and buy it before it goes up again!");
        }
        this.price = price;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        if(inStock != isInStock && inStock) {
            onDataChange("The product has arrived on our shelves and is waiting for you to buy it)))");
        }
        else if(inStock != isInStock) {
            onDataChange("Unfortunately we are out of stock, stay tuned, we will be sure to let you know.");
        }
        isInStock = inStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductSubscribers getSubscribers() {
        return subscribers;
    }

    public void onDataChange(String message) {
        subscribers.notifyClients(message);
    }

    @Override
    public String toString() {
        return name + " {" + price + ", " + isInStock + "}";
    }
}
