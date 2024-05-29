package Service;

import Classes.Distributor;
import Database.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistributorService {
    private static DistributorService instance;

    private DistributorService() {
    }

    public static synchronized DistributorService getInstance() {
        if (instance == null) {
            instance = new DistributorService();
        }
        return instance;
    }

    public void addDistributor(Distributor distributor) {
        String query = "INSERT INTO distributors (name) VALUES (?)";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, distributor.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Distributor> getAllDistributors() {
        List<Distributor> distributors = new ArrayList<>();
        String query = "SELECT * FROM distributors";
        try (Connection connection = Config.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Distributor distributor = new Distributor(resultSet.getString("name"));
                distributors.add(distributor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return distributors;
    }

    public void updateDistributor(String oldName, String newName) {
        String query = "UPDATE distributors SET name = ? WHERE name = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newName);
            statement.setString(2, oldName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDistributor(String name) {
        String query = "DELETE FROM distributors WHERE name = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Distributor getDistributorByName(String name) {
        Distributor distributor = null;
        String query = "SELECT * FROM distributors WHERE name = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                distributor = new Distributor(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return distributor;
    }
}
