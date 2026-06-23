package DB;
import config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public void viewTransactions(){
        String sql = "SELECT * FROM transactions ORDER BY transaction_id";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                ){
            System.out.println("==== TRANSACTION HISTORY ====");

            while (rs.next()){
                System.out.println(
                        "Transaction ID :"+rs.getInt("transaction_id")
                        +"| Model.Account ID :" +rs.getInt("account_id")
                        +"| Type : "+rs.getString("transaction_type")
                        +"| Amount :"+rs.getDouble("amount")
                        +"| Date :" +rs.getDate("transaction_date")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
