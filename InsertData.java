import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        DBConnection db=new DBConnection();
        Connection conn=db.connect();
        try{
            String sql = "INSERT INTO authors (author_id, first_name, last_name, nationality) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setInt(1,201);
            stmt.setString(2,"Akshay");
            stmt.setString(3,"Raj");
            stmt.setString(4,"Indian");
            int k=stmt.executeUpdate();
            if(k>0){
                System.out.println("New author added sucessfully!");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            db.disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
