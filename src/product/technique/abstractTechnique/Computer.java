package product.technique.abstractTechnique;

import category.Category;
import product.Notifications;
import product.Product;
import product.technique.company.CompanyFactory;

public abstract  class Computer extends Technique {
    private String name;
    private double price;
    private Category category;
    private boolean inStock;
    private CompanyFactory company;

    public Computer(String name, CompanyFactory company) {
        super(name, company);
    }

    public Computer(String name, double price, CompanyFactory company) {
        super(name, price, company);
    }

    public Computer(String name, double price, boolean inStock, CompanyFactory company) {
        super(name, price, inStock, company);
    }


    public void startComputer() {
        System.out.println("Computer is working");
    }
}
