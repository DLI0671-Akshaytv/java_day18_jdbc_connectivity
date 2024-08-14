import java.sql.*;

public class SimpleQuery {
    public static void main(String[] args) throws SQLException {
        DBConnection db=new DBConnection();
        Connection conn=db.connect();
        PreparedStatement smt=conn.prepareStatement("select * from authors");
        ResultSet rs=null;
        try{

            rs= smt.executeQuery();
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
