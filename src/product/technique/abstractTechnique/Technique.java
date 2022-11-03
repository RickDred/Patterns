package product.technique.abstractTechnique;

import category.Category;
import product.Notifications;
import product.Product;
import product.technique.company.CompanyFactory;

public abstract class Technique extends Notifications implements Product {
    private final String name;
    private double price;
    private final Category category;
    private boolean inStock;
    private CompanyFactory company;

    public Technique(String name, CompanyFactory company) {
        super();
        this.name = name;
        setInStock(false);
        setCompany(company);
        category = new Category("technique");
    }

    public Technique(String name, double price, CompanyFactory company) {
        this(name, company);
        setPrice(price);
    }

    public Technique(String name, double price, boolean inStock, CompanyFactory company) {
        this(name, price, company);
        setInStock(true);
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
}
