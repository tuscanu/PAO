package Service;

import Classes.Product;
import Classes.Category;
import Database.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static ProductService instance;

    private ProductService() {
    }

    public static synchronized ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public void addProduct(Product product) {
        String query = "INSERT INTO products (name, price, category) VALUES (?, ?, ?)";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getCategory().getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Connection connection = Config.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Category category = CategoryService.getInstance().getCategoryByName(resultSet.getString("category"));
                Product product = new Product(resultSet.getString("name"), resultSet.getDouble("price"), category);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void updateProduct(String oldName, String newName, double price, String categoryName) {
        String query = "UPDATE products SET name = ?, price = ?, category = ? WHERE name = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newName);
            statement.setDouble(2, price);
            statement.setString(3, categoryName);
            statement.setString(4, oldName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(String name) {
        String query = "DELETE FROM products WHERE name = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProductByName(String name) {
        Product product = null;
        String query = "SELECT * FROM products WHERE name = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Category category = CategoryService.getInstance().getCategoryByName(resultSet.getString("category"));
                product = new Product(resultSet.getString("name"), resultSet.getDouble("price"), category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
