package DB;

import config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountCDB {
    public void createAccount (int customerId){
        String sql = "INSERT INTO accounts(customer_id, balance) VALUES(?, 0)";
        try(
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
                ) {
            pstmt.setInt(1,customerId);
            int rows = pstmt.executeUpdate();
            if (rows >0){
                System.out.println("Model.Account created successfully!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deposit(int accountId, double amount ){
        String sql = "UPDATE accounts "+
                    "SET balance = balance + ? " +
                    "WHERE account_id = ?";

        try(
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ){
            pstmt.setDouble(1,amount);
            pstmt.setInt(2,accountId);

            int rows = pstmt.executeUpdate();
            if (rows >0 ){
                TransactionCDB transactionCDB = new TransactionCDB();
                transactionCDB.addTransaction(accountId,"DEPOSIT",amount);
                System.out.println("Deposit successful");
            }else {
                System.out.println("Model.Account not found!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
