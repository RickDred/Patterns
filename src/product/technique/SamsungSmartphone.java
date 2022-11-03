package product.technique;

import category.Category;
import product.technique.abstractTechnique.Smartphone;
import product.technique.company.CompanyFactory;
import product.technique.company.SamsungCompany;

public class SamsungSmartphone extends Smartphone {
    public SamsungSmartphone(String name) {
        super(name, new SamsungCompany());
    }

    public SamsungSmartphone(String name, double price) {
        super(name, price, new SamsungCompany());
    }

    public SamsungSmartphone(String name, double price, boolean inStock) {
        super(name, price, inStock, new SamsungCompany());
    }

    @Override
    public void startPhone() {
        System.out.println("Samsung phone " + getName() + " is working");
    }
}
