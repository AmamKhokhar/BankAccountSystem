public class Admin extends Person{

    private int employId;
    private int pin;

    public Admin(int employId, int pin, String name, String contact, String email, String address) {
        super(name, contact,email ,address);
        this.employId = employId;
        this.pin = pin;
    }

    public int getEmployId() {
        return employId;
    }

    public void setEmployId(int employId) {
        this.employId = employId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

}
