public class Account {

    private int accountId, customerId;
    private double balance;

    public Account(int accountId,int customerId, double balance){
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }
}

