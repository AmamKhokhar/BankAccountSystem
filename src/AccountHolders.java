public class AccountHolders {

    private int id;
    private int pin;
    private String name;
    private String contactNo;
    private String email;
    private String cnic;
    private String address;
    private double amount;

    public AccountHolders(int id, int  pin, String name, String contactNo, String email, String cnic, String address, double amount) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
        this.cnic = cnic;
        this.address = address;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
