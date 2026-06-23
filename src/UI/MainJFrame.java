package UI;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {

    public MainJFrame(){
        setVisible(true);
        setSize(350,200);
        setLocationRelativeTo(null);
        setTitle("Menu Form");


        JPanel panel = new JPanel(new GridLayout(3,2,10,10));

        JButton addCustomer = new JButton("ADD CUSTOMER");
        JButton createAcc = new JButton("CREATE ACCOUNT");
        JButton deposit = new JButton("DEPOSIT");
        JButton withdraw = new JButton("WITHDRAW");
        JButton viewCustomer = new JButton("VIEW CUSTOMER ");
        JButton viewTransaction = new JButton("VIEW TRANSACTION");

        panel.add(addCustomer);
        panel.add(createAcc);
        panel.add(deposit);
        panel.add(withdraw);
        panel.add(viewCustomer);
        panel.add(viewTransaction);
        add(panel);

        addCustomer.addActionListener(e->new
                AddCustomerUI());

    }
}
