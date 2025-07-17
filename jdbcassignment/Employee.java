package jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

    // Method to establish and return a database connection
    public Connection getConnection() {
        Connection con = null;
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "virensql");
        } catch (Exception e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        return con;
    }

    /**
     * Inserts a new employee into the database.
     * Uses PreparedStatement to prevent SQL injection.
     * @param name The name of the employee.
     * @param city The city where the employee resides.
     * @param contact The contact number of the employee.
     */
    public void insertEmployee(String name, String city, String contact) {
        System.out.println("**************** Insert New Employee *****************");
        String sql = "INSERT INTO employees (name, city, contact) VALUES (?, ?, ?)";

        // Using try-with-resources to ensure the connection and statement are closed automatically
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set the parameter values for the prepared statement
            ps.setString(1, name);
            ps.setString(2, city);
            ps.setString(3, contact);

            // Execute the update and get the number of rows affected
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee added successfully!");
            } else {
                System.out.println("Failed to add the employee.");
            }
        } catch (SQLException e) {
            System.out.println("Error during insertion: " + e.getMessage());
        }
    }

    /**
     * Retrieves and displays all employees from the database.
     */
    public void getEmployee() {
        System.out.println("**************** Display All Employees *****************");
        String sql = "SELECT * FROM employees";
        
        // Using try-with-resources for automatic resource management
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet res = st.executeQuery(sql)) {

            System.out.println("ID\tName\t\tCity\t\tContact");
            System.out.println("-------------------------------------------------");

            // Iterate through the result set and print employee details
            while (res.next()) {
                System.out.printf("%-4d\t%-15s\t%-15s\t%s\n",
                        res.getInt("id"),
                        res.getString("name"),
                        res.getString("city"),
                        res.getString("contact"));
            }
            System.out.println("-------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("Error fetching employees: " + e.getMessage());
        }
    }

    /**
     * Updates the city of an existing employee based on their ID.
     * @param id The ID of the employee to update.
     * @param city The new city for the employee.
     */
    public void updateEmployee(int id, String city) {
        System.out.println("**************** Update Employee *****************");
        String sql = "UPDATE employees SET city = ? WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set parameters for the update query
            ps.setString(1, city);
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + id + " was updated successfully.");
            } else {
                System.out.println("No employee found with ID " + id + ". Update failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error during update: " + e.getMessage());
        }
    }

    /**
     * Deletes an employee from the database based on their ID.
     * @param cid The ID of the employee to delete.
     */
    public void deleteEmployee(int cid) {
        System.out.println("**************** Delete Employee *****************");
        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set the ID parameter for the delete query
            ps.setInt(1, cid);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + cid + " was deleted successfully.");
            } else {
                System.out.println("No employee found with ID " + cid + ". Deletion failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error during deletion: " + e.getMessage());
        }
    }
}
