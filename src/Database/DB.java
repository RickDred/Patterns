package Database;

import client.Client;

import java.sql.*;

public class DB {
    private Connection conn;
    private static DB db;
    Statement stmt;

    private DB() {}

    public static synchronized DB getInstance() {
        if(db == null) db = new DB();
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
                stmt = conn.createStatement();
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

    public int getCount(String table) {
        String SQL = "SELECT count(*) FROM " + table;
        int count = 0;
        try {
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            count = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    private String queryBegin(String table, String ... columns) {
        String query = "SELECT ";
        if(columns.length == 0) {
            query += "* ";
        }
        else {
            for(int i = 0; i < columns.length-1; i++) {
                query += columns[i] + ", ";
            }
            query += columns[columns.length-1];
        }
        query += " FROM " + table;
        return query;
    }

    public void getData(String table, String ... columns) {
        String SQL = queryBegin(table, columns);

        try {
            ResultSet rs = stmt.executeQuery(SQL);
            displayData(rs, columns);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getOneRowById(String table, int id, String ... columns) {
        String SQL = queryBegin(table, columns);
        SQL += " WHERE " + table.substring(0, table.length()-1) + "_id" + " = " + Integer.toString(id);

        try {
            ResultSet rs = stmt.executeQuery(SQL);
            displayData(rs, columns);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayData(ResultSet rs, String ... columns) throws SQLException {
        while (rs.next()) {
            for(String column: columns) {
                System.out.print(rs.getString(column) + "\t");
            }
            System.out.println();
        }
    }

    public void addClient(Client client) {
        String table = "customers";
        String SQL = "INSERT INTO customers(customer_id, customer_name, customer_email) VALUES (?, ?, ?)";
        int id = getCount(table) + 1;
//        SQL += Integer.toString(id) + ", '" + client.getName() + "', '" + client.getEmail() + "');";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1,id);
            pstmt.setString(2,client.getName());
            pstmt.setString(3,client.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}