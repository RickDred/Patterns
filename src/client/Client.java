package client;

public class Client {
    private String name;
    private String email;
    private int id;



    public Client(String email) {
        setEmail(email);
        setName("default");
    }

    public Client(String name, String email) {
        this(email);
        setName(name);
    }

    public Client(String email, int id) {
        this(email);
        setId(id);
    }

    public Client(String name, String email, int id) {
        this(email, email);
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
