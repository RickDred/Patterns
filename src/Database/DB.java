package Database;

import java.sql.*;

public class DB {
    private Connection conn;
    private static DB db;
    public UserDB clientDB;

    private DB() {}

    public static synchronized DB getInstance() {
        if(db == null) {
            db = new DB();
            if(db.clientDB == null) {
                db.clientDB = new UserDB();
            }
        }
        db.connect();
        return db;
    }

    private void connect() {
        if(conn == null) {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "elaman(2004)@";
            try {
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Database connected!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public Connection getConnection() {
        if(conn == null) {
           connect();
        }
        return conn;
    }

    public boolean closeConnection() {
        if(conn == null) return true;
        try {
            conn.close();
            System.out.println("Connection closed!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}