package Service;

import Classes.Category;
import Database.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private static CategoryService instance;

    private CategoryService() {
    }

    public static synchronized CategoryService getInstance() {
        if (instance == null) {
            instance = new CategoryService();
        }
        return instance;
    }

    public void addCategory(Category category) {
        String query = "INSERT INTO categories (name) VALUES (?)";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM categories";
        try (Connection connection = Config.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Category category = new Category(resultSet.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void updateCategory(String oldName, String newName) {
        String query = "UPDATE categories SET name = ? WHERE name = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newName);
            statement.setString(2, oldName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(String name) {
        String query = "DELETE FROM categories WHERE name = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Category getCategoryByName(String name) {
        Category category = null;
        String query = "SELECT * FROM categories WHERE name = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                category = new Category(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
