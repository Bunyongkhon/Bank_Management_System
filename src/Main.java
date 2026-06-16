import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        Costumer cos = new Costumer(name, phoneNum);
        CustomerCDB customerCDB = new CustomerCDB();

       do {
           System.out.println("========= MENU =========");
           System.out.println("1.INPUT CUSTOMER ");
           System.out.println("2.SHOW CUSTOMER ");
           System.out.print("Choose Option --> :  ");
           choice = sc.nextInt();

           switch (choice){
               case 1 :{
                   System.out.println("==== INFORMATION ====");
                   System.out.print("Enter Customer Full Name :");
                   String name = sc.nextLine();
                   System.out.print("Enter Phone Number : ");
                   String phoneNum = sc.nextLine();

                   customerCDB.addCustomer(cos);

               }
               case 2 :{
                   System.out.println("==== SHOW INFORMATION ====");
                   customerCDB.viewCustomers();

               }
           }


       }while (choice < 4);
    }
}
