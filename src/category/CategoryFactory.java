package category;

import java.util.ArrayList;

public class CategoryFactory {
    private ArrayList<Category> cache;

    public CategoryFactory() {
        cache = new ArrayList<>();
    }

    public ArrayList<Category> getCategory() {
        return cache;
    }

    public void addCategory(Category category) {
        if(cache.contains(category))
            return;
        cache.add(category);
    }
}
