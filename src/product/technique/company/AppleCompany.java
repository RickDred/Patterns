package product.technique.company;

public class AppleCompany implements CompanyFactory {
    private String name = "Apple";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CompanyFactory getInstance() {
        return this;
    }
}
