package product.technique;

import category.Category;
import product.technique.abstractTechnique.Smartphone;
import product.technique.company.AppleCompany;

public class AppleSmartphone extends Smartphone {
    public AppleSmartphone(String name) {
        super(name, new AppleCompany());
    }

    public AppleSmartphone(String name, double price) {
        super(name, price, new AppleCompany());
    }

    public AppleSmartphone(String name, double price, boolean inStock) {
        super(name, price, inStock, new AppleCompany());
    }

    @Override
    public void startPhone() {
        System.out.println("Apple phone " + getName() + " is working");
    }
}
