package client;

public class Client {
    private String name;
    private String email;

    public Client(String email) {
        setEmail(email);
        setName("default");
    }

    public Client(String name, String email) {
        this(email);
        setName(name);
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

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
