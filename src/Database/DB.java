package Database;

import java.sql.Connection;

public interface DB {
    void connect();
    Connection getConnection();
    boolean closeConnection();
}
