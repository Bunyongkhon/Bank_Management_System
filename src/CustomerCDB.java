import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerCDB {
    public void addCustomer(Costumer costumer){
        String sql = "INSERT INTO customers(full_name,phone) VALUES(?, ?)";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
           pstmt.setString(1, costumer.getFullName());
           pstmt.setString(2,costumer.getPhone());

           int rows = pstmt.executeUpdate();

           if (rows > 0 ){
               System.out.println("Customer added successfully!");
           }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
