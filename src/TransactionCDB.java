import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionCDB {
    public void addTransaction(int accountId,String type,double amount){
        String sql = "INSERT INTO transactions (account_id, transaction_type, amount)"+
                "VALUES (?, ?, ?)";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);

                ){
            pstmt.setInt(1,accountId);
            pstmt.setString(2,type);
            pstmt.setDouble(3,amount);
            pstmt.executeUpdate();
            System.out.println("Transaction recorded.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
