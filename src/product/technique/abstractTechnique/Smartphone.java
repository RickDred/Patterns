package product.technique.abstractTechnique;

import category.Category;
import product.Notifications;
import product.Product;
import product.technique.company.CompanyFactory;

public abstract class Smartphone extends Technique {
    private String name;
    private double price;
    private Category category;
    private boolean inStock;
    private CompanyFactory company;

    public Smartphone(String name, CompanyFactory company) {
        super(name, company);
        this.name = name;
        this.company = company;
        this.category = new Category("technique");
    }

    public Smartphone(String name, double price, CompanyFactory company) {
        this(name, company);
        setPrice(price);
    }

    public Smartphone(String name, double price, boolean inStock, CompanyFactory company) {
        this(name, price, company);
        setInStock(inStock);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isInStock() {
        return inStock;
    }

    @Override
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    protected void setCompany(CompanyFactory company) {
        this.company = company;
    }

    public CompanyFactory getCompany() {
        return company;
    }

    public void startPhone() {
        System.out.println("Phone is working");
    }
}
