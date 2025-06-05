public class Admin extends Person{

    private String employId;
    private int pin;

    public Admin(String employId, int pin, String name, String contact, String email, String address) {
        super(name, contact,email ,address);
        this.employId = employId;
        this.pin = pin;
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

}
