package Database;

import category.Category;
import product.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDB extends DBController{
    Connection conn;

    public CategoryDB() {
        super();
        conn = PostgresDB.getInstance().getConnection();
    }

    public Category getCategory(String name) {
        ResultSet rs = getData("categories");
        try {
            while(rs.next()) {
                if(rs.getString("category_name") == name) {
                    return new Category(name, rs.getInt("category_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Category getCategory(int id) {
        ResultSet rs = getOneRowById("categories", id);
        try {
            return new Category(rs.getString("category_name"), rs.getInt("category_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // DODELAT'
    public ArrayList<Product> getProductsByCategory(String category) {
        ResultSet rs;
        ArrayList<Product> products = new ArrayList<>();
        String SQL = queryBegin("products");
        SQL += " NATURAL JOIN categories WHERE products.category_id = categories.category_id AND categories.category_name = " + category;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            while(rs.next()) {
                String name = rs.getString("product_name");
                double price = rs.getDouble("product_price");
                boolean isInStock = rs.getBoolean("product_is_in_stock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
