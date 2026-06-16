import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Full Name :");
        String name = sc.nextLine();
        System.out.print("Enter Phone Number : ");
        String phoneNum = sc.nextLine();
       Costumer cos = new Costumer(name, phoneNum);

       CustomerCDB add = new CustomerCDB();
       add.addCustomer(cos);
    }
}
