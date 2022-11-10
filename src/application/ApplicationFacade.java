package application;

import Database.PostgresDB;
import Database.UserDB;
import client.Client;
import product.Product;

import java.sql.Connection;

public class ApplicationFacade {
    public PostgresDB getDB() {
        return PostgresDB.getInstance();
    }

    public Connection getConnection() {
        return PostgresDB.getInstance().getConnection();
    }

    public Client getClientById(int id) {
        UserDB db = new UserDB();
        return db.getClientById(id);
    }

    public Client getClientByEmail(String email) {
        UserDB db = new UserDB();
        return db.getClientByEmail(email);
    }

    public void registerNewClient(Client client) {
        UserDB db = new UserDB();
        db.addClient(client);
    }

    public String getClientName(Client client) {
        return client.getName();
    }

    public String getClientEmail(Client client) {
        return client.getEmail();
    }

    public String getProductName(Product product) {
        return product.getName();
    }

    public double getProductPrice(Product product) {
        return product.getPrice();
    }
}
