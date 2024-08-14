import java.sql.*;

public class DBConnection {
    private static final String URL="jdbc:postgresql://localhost:5432/Library_Management";
    private static final String USER="postgres";
    private static final String PASSWORD="1234";
    private Connection conn=null;

    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to PostgreSQL database successful!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public void disconnect() throws SQLException {
        conn.close();
        System.out.println("Connection Disconnected!");
    }
}
