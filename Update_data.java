import java.sql.*;

public class Update_data {
    public static void main(String[] args) throws SQLException {
        DBConnection db=new DBConnection();
        Connection conn=db.connect();
        PreparedStatement stmt=conn.prepareStatement("select * from authors");
        ResultSet rs=null;
        Statement smt=null;
        try{
            //update query
            String updateQuery = "UPDATE authors SET nationality = ? WHERE author_id = ?";
            stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, "Pakistan"); // Set the new nationality
            stmt.setInt(2, 3); // Set the author_id for which you want to update the nationality
            int rowsUpdated = stmt.executeUpdate();
            if(rowsUpdated>1){
                System.out.println("Updated successsfully");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            smt=conn.createStatement();
            rs= smt.executeQuery("select * from authors");
            System.out.println("\nList of Authors\n-------------------------------------");
            while(rs.next()){
                int id=rs.getInt("author_id");
                String firstname=rs.getString("first_name");
                String lastname=rs.getString("last_name");
                String nation=rs.getString("nationality");
                System.out.println("ID: "+id+"   Name:"+firstname+lastname+"  Nationality:"+nation);
            }
            System.out.println();

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
