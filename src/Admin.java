public class Admin {

    private String employId;
    private int pin;
    private String name;
    private String contact;
    private String email;
    private String address;

    public Admin(String employId, int pin, String name, String contact, String email, String address) {
        this.employId = employId;
        this.pin = pin;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
