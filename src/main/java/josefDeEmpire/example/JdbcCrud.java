package josefDeEmpire.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcCrud {
    private static final String URL = "jdbc:mysql://localhost:3306/java_db?useSSL=true";
    private static final String USER = "root";
    private static final String PASSWORD = "@Joseph84";
    JdbcCrud() {
    }
    public static void users(String first_name, String last_name, String username, String phone_number, String password) throws ClassNotFoundException {
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(50) NOT NULL," +
                    "last_name VARCHAR(50) NOT NULL," +
                    "username VARCHAR(50) UNIQUE NOT NULL," +
                    "phone_number VARCHAR(15)," +
                    "password VARCHAR(100) NOT NULL" +
                    ")";
            PreparedStatement ps = conn.prepareStatement(createTableSQL);
            ps.executeUpdate();
            String insertSQL = "INSERT INTO users (first_name, last_name, username, phone_number, password) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(insertSQL);
            // Set parameter values
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, username);
            ps.setString(4, phone_number);
            ps.setString(5, password);

            // Execute the insert
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User inserted successfully!");
            } else {
                System.out.println("No rows were inserted.");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static boolean isValidUser(String username, String password) {
        boolean isValid = false;

        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters in query
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute query
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    isValid = count > 0;
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
        return isValid;
    }

    public static int isUserId(String username) {


        String sql = "SELECT * FROM users WHERE username = ?";

        int id = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters in query
            statement.setString(1, username);


            // Execute query
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    id = resultSet.getInt("id");
                    String name = resultSet.getString("username");
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
        return id;
    }

    public static String isUsername(String username) {


        String sql = "SELECT * FROM users WHERE username = ?";


        String name = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters in query
            statement.setString(1, username);


            // Execute query
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {

                    name = resultSet.getString("username");
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
        return name;
    }


    public static void deposits(int user_id, double amount){
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String createTableSQL = "CREATE TABLE IF NOT EXISTS deposits(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "user_id INT NOT NULL," +
                    "amount DECIMAL(10, 2) NOT NULL," +
                    "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE" +
                    ")";
            PreparedStatement ps = conn.prepareStatement(createTableSQL);
            ps.executeUpdate();
            String insertSQL = "INSERT INTO deposits (user_id, amount) VALUES (?, ?)";
            ps = conn.prepareStatement(insertSQL);
            // Set parameter values
            ps.setInt(1, user_id);
            ps.setDouble(2, amount);

            // Execute the insert
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Deposits inserted successfully!");
            } else {
                System.out.println("No rows were inserted.");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sends(int sender_id, int recipient_id, double amount){
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String createTableSQL = "CREATE TABLE IF NOT EXISTS sends (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "sender_id INT NOT NULL," +
                    "recipient_id INT NOT NULL," +
                    "amount DECIMAL(10, 2) NOT NULL," +
                    "FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE CASCADE," +
                    "FOREIGN KEY (recipient_id) REFERENCES users(id) ON DELETE CASCADE" +
                    ")";
            PreparedStatement ps = conn.prepareStatement(createTableSQL);
            ps.executeUpdate();
            String insertSQL = "INSERT INTO sends (sender_id, recipient_id, amount) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(insertSQL);
            // Set parameter values
            ps.setInt(1, sender_id);
            ps.setInt(2, recipient_id);
            ps.setDouble(3, amount);

            // Execute the insert
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Send inserted successfully!");
            } else {
                System.out.println("No rows were inserted.");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void withdraws(int user_id, double amount){
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String createTableSQL = "CREATE TABLE IF NOT EXISTS withdrawals (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "user_id int NOT NULL," +
                    "amount DECIMAL(10, 2) NOT NULL," +
                    "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE" +
                    ")";
            PreparedStatement ps = conn.prepareStatement(createTableSQL);
            ps.executeUpdate();
            String insertSQL = "INSERT INTO withdrawals (user_id, amount) VALUES (?, ?)";
            ps = conn.prepareStatement(insertSQL);
            // Set parameter values
            ps.setInt(1, user_id);
            ps.setDouble(2, amount);


            // Execute the insert
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Withdraw recorded successfully!");
            } else {
                System.out.println("No withdrwals were recorded.");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static double checkBalance(int user_id) {
        double total = 0;
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String insertSQL = "SELECT " +
                            "    COALESCE(deposit_total, 0) + " +
                            "    COALESCE(received_total, 0) - " +
                            "    COALESCE(withdraw_total, 0) - " +
                            "    COALESCE(sent_total, 0) AS balance " +
                            "FROM ( " +
                            "    SELECT " +
                            "        (SELECT SUM(amount) FROM deposits WHERE user_id = ?) AS deposit_total, " +
                            "        (SELECT SUM(amount) FROM sends WHERE recipient_id = ?) AS received_total, " +
                            "        (SELECT SUM(amount) FROM withdrawals WHERE user_id = ?) AS withdraw_total, " +
                            "        (SELECT SUM(amount) FROM sends WHERE sender_id = ?) AS sent_total " +
                            ") AS totals;";


            PreparedStatement ps = conn.prepareStatement(insertSQL);
            // Set parameter values
            ps.setInt(1, user_id);
            ps.setInt(2, user_id);
            ps.setInt(3, user_id);
            ps.setInt(4, user_id);


            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getDouble("balance");
                System.out.println("Account balance: " + total);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }




}
