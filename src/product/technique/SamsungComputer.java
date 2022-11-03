package product.technique;

import category.Category;
import product.technique.abstractTechnique.Computer;
import product.technique.company.SamsungCompany;

public class SamsungComputer extends Computer {

    public SamsungComputer(String name) {
        super(name, new SamsungCompany());
    }

    public SamsungComputer(String name, double price) {
        super(name, price, new SamsungCompany());
    }

    public SamsungComputer(String name, double price, boolean inStock) {
        super(name, price, inStock, new SamsungCompany());
    }
    @Override
    public void startComputer() {
        System.out.println("Samsung computer " + getName() + " is working");
    }
}
