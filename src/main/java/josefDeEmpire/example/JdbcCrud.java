package josefDeEmpire.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcCrud {
    private static final String URL = "jdbc:mysql://localhost:3306/java_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "@Joseph84";
    JdbcCrud() {
//            // CREATE
//            createBook("Java 101", "John Doe");
//
//            // READ
//            getBooks();
//
//            // UPDATE
//            updateBook(1, "Java 17 Mastery");
//
//            // DELETE
//            deleteBook(1);

    }
    // CREATE
    public static void createUser(String first_name, String last_name, String username, String phone_number, String password){
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO users (first_name, last_name, username, phone_number, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setString(3, username);
            stmt.setString(4, phone_number);
            stmt.setString(5, password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void getUsers() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Returns a list of users with {username, password}
    public static List<Map<String, String>> getUser() {
        List<Map<String, String>> users = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT username, password FROM users"; // Target users table
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> user = new HashMap<>();
                user.put("username", rs.getString("username"));
                user.put("password", rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static List<Map<String, String>> getPassword(String username) {
        List<Map<String, String>> users = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // ✅ Use PreparedStatement to prevent SQL injection
            String sql = "SELECT password FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username); // Bind the username parameter

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Map<String, String> user = new HashMap<>();
                user.put("password", rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // UPDATE
    public static void updateUser(int id, String newTitle) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE books SET title = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, newTitle);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteUser(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
