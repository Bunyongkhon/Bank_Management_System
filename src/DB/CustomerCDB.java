package DB;

import Model.Costumer;

import config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public void viewCustomers(){
        String sql = "SELECT * FROM customers ORDER BY customer_id";

        try(
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                ) {

            System.out.println("\n ===== CUSTOMER LIST =====");
            while (rs.next()){
                System.out.println(
                        rs.getInt("customer_id")+
                                " | "+
                                rs.getString("full_name")+
                                " | "+
                                rs.getString("phone")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
