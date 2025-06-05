public class AccountHolders extends Person{

    private int id;
    private int pin;
    private String cnic;
    private double amount;

    public AccountHolders(int id, int  pin, String name, String contact, String email, String cnic, String address, double amount) {
        super(name,contact,email,address);
        this.id = id;
        this.pin = pin;
        this.cnic = cnic;
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

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
