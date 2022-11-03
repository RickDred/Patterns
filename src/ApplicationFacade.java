import Database.DB;
import Database.UserDB;
import client.Client;
import java.sql.Connection;

public class ApplicationFacade {
    public DB getDB() {
        return DB.getInstance();
    }

    public Connection getConnection() {
        return DB.getInstance().getConnection();
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
}
