package product.technique.company.companyAdapter;

import category.Category;

public class CompanyToCategory extends Category {
    private Category category;
    private int id;

    public CompanyToCategory(Category category) {
        super(category.getName());
        this.category = category;
    }

    @Override
    public String getName() {
        return category.getName();
    }

    @Override
    public void setName(String name) {
        category.setName(name);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
