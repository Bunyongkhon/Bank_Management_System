import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        CustomerCDB customerCDB = new CustomerCDB();
        AccountCDB accountCDB = new AccountCDB();

       do {
           System.out.println("========= MENU =========");
           System.out.println("1.INPUT CUSTOMER ");
           System.out.println("2.SHOW CUSTOMER ");
           System.out.println("3.CREATE ACCOUNT");
           System.out.print("Choose Option --> :  ");
           choice = sc.nextInt();

           switch (choice){
               case 1 :{
                   System.out.println("==== INFORMATION ====");
                   sc.nextLine();
                   System.out.print("Enter Customer Full Name :");
                   String name = sc.nextLine();
                   System.out.print("Enter Phone Number : ");
                   String phoneNum = sc.nextLine();
                   Costumer cos = new Costumer(name, phoneNum);

                   customerCDB.addCustomer(cos);

               }break;
               case 2 :{
                   System.out.println("==== SHOW INFORMATION ====");
                   customerCDB.viewCustomers();

               }break;
               case 3 :{

                   System.out.println("==== CREATE ACCOUNT ====");
                   System.out.print("Enter Customer ID :");
                   int customerId = sc.nextInt();
                   accountCDB.createAccount(customerId);
               }break;
           }


       }while (choice < 4);
    }
}
