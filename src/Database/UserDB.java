package Database;

import client.Client;

import java.sql.*;

public class UserDB extends DBController{
    Connection conn;
    Statement stmt;

    public UserDB() {
        super();
        conn = PostgresDB.getInstance().getConnection();
    }

    public void addClient(Client client) {
        String table = "customers";
        String SQL = "INSERT INTO customers(customer_name, customer_email) VALUES (?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,client.getName());
            pstmt.setString(2,client.getEmail());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Client getClientById(int id) {
        Client client = null;
        ResultSet rs = getOneRowById("customers", id);
        try {
            client = new Client(rs.getString("customer_name"), rs.getString("customer_email"), rs.getInt("customer_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Client getClientByEmail(String email) {
        ResultSet rs;
        Client client = null;

        String SQL = queryBegin("customers");
        SQL += " WHERE customer_email = " + email;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            client = new Client(rs.getString("customer_name"), rs.getString("customer_email"), rs.getInt("customer_id"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }
}
