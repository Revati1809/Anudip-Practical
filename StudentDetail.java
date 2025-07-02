import java.sql.*;
public class StudentDetail {
    private static final String URL = "jdbc:mysql://localhost:3306/StudentDetails";
    private static final String USER = "root";
    private static final String PASSWORD = "revatiraut@09";

    public static void main(String[] args) {
        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");

            // Step 3: Create Table
            createTable(connection);

            // Step 4: Insert Data
            insertData(connection, 1, "Revati Raut", "revati@example.com", 90, "TY", "Computer Engineering");
            insertData(connection, 2, "Anisha Joshi", "anisha@example.com", 97, "FY", "Computer Science");

            // Step 5: Retrieve Data
            retrieveData(connection);

            // Step 6: Update Data
            updateData(connection, 1, "revati543@example.com");

            // Step 7: Search Data
            searchData(connection, 1);

            // Step 8: Delete Data
            deleteData(connection, 2);

            // Step 9: Close Connection
            connection.close();
            System.out.println("Database connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create Table
    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS StudentDetail ("
                + "Std_id INT PRIMARY KEY, "
                + "Std_name VARCHAR(100), "
                + "Std_email VARCHAR(100) UNIQUE, "
                + "Std_Marks INT, "
                + "Std_class VARCHAR(100), "
                + "Std_dept VARCHAR(100))";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table 'StudentDetail' created successfully!");
        }
    }

    // Insert Data
    private static void insertData(Connection connection, int Std_id, String Std_name, String Std_email, int Std_Marks, String Std_class, String Std_dept) throws SQLException {
        String insertSQL = "INSERT INTO StudentDetail (Std_id, Std_name, Std_email, Std_Marks, Std_class, Std_dept) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setInt(1, Std_id);
            pstmt.setString(2, Std_name);
            pstmt.setString(3, Std_email);
            pstmt.setInt(4, Std_Marks);
            pstmt.setString(5, Std_class);
            pstmt.setString(6, Std_dept);
            pstmt.executeUpdate();
            System.out.println("Inserted student: " + Std_name);
        }
    }

    // Retrieve Data
    private static void retrieveData(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM StudentDetail";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            System.out.println("\n--- Student Detail: ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Std_id") +
                        ", Name: " + rs.getString("Std_name") +
                        ", Email: " + rs.getString("Std_email") +
                        ", Marks: " + rs.getInt("Std_Marks") +
                        ", Class: " + rs.getString("Std_class") +
                        ", Dept: " + rs.getString("Std_dept"));
            }
        }
    }

    // Update Data
    private static void updateData(Connection connection, int Std_id, String newEmail) throws SQLException {
        String updateSQL = "UPDATE StudentDetail SET Std_email = ? WHERE Std_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, Std_id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Updated email for student ID: " + Std_id);
            } else {
                System.out.println("Student not found for update.");
            }
        }
    }

    // Search Data
    private static void searchData(Connection connection, int Std_id) throws SQLException {
        String sql = "SELECT * FROM StudentDetail WHERE Std_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Std_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Student Found: ID: " + rs.getInt("Std_id") +
                            ", Name: " + rs.getString("Std_name") +
                            ", Email: " + rs.getString("Std_email") +
                           " Marks: " + rs.getInt("Std_Marks") +
                        ", Class: " + rs.getString("Std_class") +
                        ", Dept: " + rs.getString("Std_dept"));
                } else {
                    System.out.println("Student with ID " + Std_id + " not found.");
                }
            }
        }
    }

    // Delete Data
    private static void deleteData(Connection connection, int Std_id) throws SQLException {
        String deleteSQL = "DELETE FROM StudentDetail WHERE Std_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, Std_id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Deleted student with ID: " + Std_id);
            } else {
                System.out.println("Student not found for deletion.");
            }
        }
    }
}