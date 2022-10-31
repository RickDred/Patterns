package category;

public class Category {
    private String name;
    private int id;

    public Category(String name) {
        setName(name);
    }

    public Category(String name, int id) {
        this(name);
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
