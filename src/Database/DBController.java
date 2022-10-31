package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBController {
    private Statement stmt;

    public DBController() {
        try {
            Connection conn = DB.getInstance().getConnection();
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    protected String queryBegin(String table, String ... columns) {
        StringBuilder query = new StringBuilder("SELECT ");
        if(columns.length == 0) {
            query.append("* ");
        }
        else {
            for(int i = 0; i < columns.length-1; i++) {
                query.append(columns[i]).append(", ");
            }
            query.append(columns[columns.length - 1]);
        }
        query.append(" FROM ").append(table);
        return query.toString();
    }

    public ResultSet getData(String table, String ... columns) {
        String SQL = queryBegin(table, columns);
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery(SQL);
            displayData(rs, columns);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public ResultSet getOneRowById(String table, int id, String ... columns) {
        ResultSet rs = null;

        String SQL = queryBegin(table, columns);
        SQL += " WHERE " + table.substring(0, table.length()-1) + "_id" + " = " + Integer.toString(id);

        try {
            rs = stmt.executeQuery(SQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    private void displayData(ResultSet rs, String ... columns) throws SQLException {
        try {
            while (rs.next()) {
                for(String column: columns) {
                    System.out.print(rs.getString(column) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
