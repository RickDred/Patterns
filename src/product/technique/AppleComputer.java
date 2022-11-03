package product.technique;

import category.Category;
import product.technique.abstractTechnique.Computer;
import product.technique.company.AppleCompany;
import product.technique.company.CompanyFactory;

public class AppleComputer extends Computer {
    public AppleComputer(String name) {
        super(name, new AppleCompany());
    }

    public AppleComputer(String name, double price) {
        super(name, price, new AppleCompany());
    }

    public AppleComputer(String name, double price, boolean inStock) {
        super(name, price, inStock, new AppleCompany());
    }

    @Override
    public void startComputer() {
        System.out.println("Apple computer " + getName() + " is working");
    }
}
