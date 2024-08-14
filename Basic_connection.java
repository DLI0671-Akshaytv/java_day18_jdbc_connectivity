import java.sql.Connection;
import java.sql.SQLException;

public class Basic_connection {
    public static void main(String[] args) {
        DBConnection db=new DBConnection();
        Connection conn=db.connect();
        try {
            db.disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
