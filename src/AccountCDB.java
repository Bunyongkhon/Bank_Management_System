import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountCDB {
    public void createAccount (int customerId){
        String sql = "INSERT INTO accounts(customer_id, balance) VALUES(?, 0)";
        try(
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ) {
            pstmt.setInt(1,customerId);
            int rows = pstmt.executeUpdate();
            if (rows >0){
                System.out.println("Account created successfully!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
