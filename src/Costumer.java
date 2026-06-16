public class Costumer {
    private int customerId;
    private String fullName;
    private String phone;

    public Costumer( String fullName, String phone){
        this.fullName = fullName;
        this.phone = phone;
    }
    public Costumer(int customerId, String fullName, String phone){
        this.customerId = customerId;
        this.fullName = fullName;
        this.phone = phone;
    }

    public  int getCustomerId(){
        return customerId;
    }
    public String getFullName(){
        return fullName;
    }
    public String getPhone(){
        return phone;
    }
}
