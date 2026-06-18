import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        CustomerCDB customerCDB = new CustomerCDB();
        AccountCDB accountCDB = new AccountCDB();
        TransactionCDB transactionCDB = new TransactionCDB();

       do {
           System.out.println("========= MENU =========");
           System.out.println("1.INPUT CUSTOMER ");
           System.out.println("2.SHOW CUSTOMER ");
           System.out.println("3.CREATE ACCOUNT");
           System.out.println("4.DEPOSIT MONEY");
           System.out.println("5.VIEW TRANSACTION");
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
               case 4 :{
                   System.out.println("==== DEPOSIT ====");
                   System.out.print("Enter Account Number :");
                   int accountId = sc.nextInt();
                   System.out.print("Enter Amount :");
                   double amount = sc.nextDouble();

                   accountCDB.deposit(accountId,amount);
               }break;
               case 5 :{
                   System.out.println("==== TRANSACTION ====");
                   transactionCDB.viewTransactions();
               }
           }

       }while (choice < 6);
    }
}
