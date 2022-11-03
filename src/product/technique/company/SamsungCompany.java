package product.technique.company;

public class SamsungCompany implements CompanyFactory {
    private String name = "Samsung";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CompanyFactory getInstance() {
        return this;
    }
}
