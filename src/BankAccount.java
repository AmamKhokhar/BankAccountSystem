import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount {

    // Fields
    private List<AccountHolders> accountHolder;
    private List<Admin> admins;
    ;
    Scanner scanner = new Scanner(System.in);

    // Parameterized Constructor
    BankAccount() {
        accountHolder = new ArrayList<>();
        admins = new ArrayList<>();
    }

    public List<AccountHolders> getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(List<AccountHolders> accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void addAccount(AccountHolders accountHolders) {
        accountHolder.add(accountHolders);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void loginForAccountHolders() {

//        System.out.println("\n==Login Page==\n");
        System.out.println("Enter Your Account ID: ");
        String id = scanner.nextLine();

        System.out.println("Enter Your Pin: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolders : accountHolder) {
            if (accountHolders.getId().equals(id)) {
                newAccountHolder = accountHolders;
                break;
            }
        }
        if (newAccountHolder != null) {
            if (newAccountHolder.getPin() == pin) {
                System.out.println("Logged in Successfully\n");
                System.out.println("Account Details");
                System.out.println("----------------------");
                System.out.println("ID: " + newAccountHolder.getId());
                System.out.println("Name: " + newAccountHolder.getName());
                System.out.println("Contact: " + newAccountHolder.getContactNo());
                System.out.println("Email: " + newAccountHolder.getEmail());
                System.out.println("Address: " + newAccountHolder.getAddress());
                System.out.println("Amount: " + newAccountHolder.getAmount());
                System.out.println("----------------------");
                System.out.println();

                while (true) {

                    System.out.println("1. Deposit Money");
                    System.out.println("2. Withdraw Money");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Exit\n");
                    System.out.println("Select Your Choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        deposit();
                    } else if (choice == 2) {
                        withdrawAmount();
                    } else if (choice == 3) {
                        checkBalance();
                    } else if (choice == 4) {
                        break;
                    } else {
                        System.out.println("Please Enter Valid Option");
                    }

                }

            } else {
                System.out.println("You Entered the Wrong Pin");
            }
        } else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }

    }

    public void loginForAdmin() {

//        System.out.println("\n==Login Page==\n");
        System.out.println("Enter Your Employ ID: ");
        String employId = scanner.nextLine();


        System.out.println("Enter Your Pin: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        Admin newAdmin = null;
        for (Admin admin : admins) {
            if (admin.getEmployId().equals(employId)) {
                newAdmin = admin;
                break;
            }
        }
        if (newAdmin != null) {
            if (newAdmin.getPin() == pin) {
                System.out.println("Logged in Successfully");
                System.out.println("Admin Details");
                System.out.println("----------------------");
                System.out.println("EmployId: " + newAdmin.getEmployId());
                System.out.println("Name: " + newAdmin.getName());
                System.out.println("Contact: " + newAdmin.getContact());
                System.out.println("Email: " + newAdmin.getEmail());
                System.out.println("Address: " + newAdmin.getAddress());
                System.out.println("----------------------");

                while (true) {

                    System.out.println("1. View Accounts");
                    System.out.println("2. Update Account");
                    System.out.println("3. Delete Account");
                    System.out.println("4. Logout");
                    System.out.println("Select Your Choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        viewAccounts();
                    } else if (choice == 2) {
                        updateAccounts();
                    } else if (choice == 3) {
                        deleteAccounts();
                    } else if (choice == 4) {
                        break;
                    } else {
                        System.out.println("Please Enter Valid Option");
                    }
                }
            } else {
                System.out.println("Entered Wrong Pin");
            }
        } else {
            System.out.println("Admin Does Not Exist With EmployID: " + employId);
        }
    }

    public void checkBalance() {
        System.out.println("Enter Your Account ID: ");
        String id = scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolder : accountHolder) {
            if (accountHolder.getId().equals(id)) {
                newAccountHolder = accountHolder;
                break;
            }
        }
        if (newAccountHolder != null) {
            System.out.println("Your Balance is: " + newAccountHolder.getAmount() + "\n");
        } else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }

    }

    public void deposit() {

        System.out.println("Enter Your Account ID: ");
        String id = scanner.nextLine();


        System.out.println("Enter Amount To Deposit: ");
        double amountToDeposit = scanner.nextDouble();
        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolder : accountHolder) {
            if (accountHolder.getId().equals(id)) {
                newAccountHolder = accountHolder;
                break;
            }
        }
        if (newAccountHolder != null) {
            double newBalance = newAccountHolder.getAmount() + amountToDeposit;
            newAccountHolder.setAmount(newBalance);
            System.out.println("Amount Deposited successfully");
            System.out.println("Your New Balance is: " + newAccountHolder.getAmount() + "\n");
        } else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }
    }

    public void withdrawAmount() {

        System.out.println("Enter Your Account ID: ");
        String id = scanner.nextLine();

        System.out.println("Enter Amount To Withdraw: ");
        double amountToWithdraw = scanner.nextDouble();
        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolders1 : accountHolder) {
            if (accountHolders1.getId().equals(id)) {
                newAccountHolder = accountHolders1;
                break;
            }
        }
        if (newAccountHolder != null) {

            double newBalance = newAccountHolder.getAmount() - amountToWithdraw;

            if (newBalance < 0) {
                System.out.println("You Have Sufficient Balance\n");
            } else {
                newAccountHolder.setAmount(newBalance);
                System.out.println("Your Amount is Withdraw Successfully");
                System.out.println("Your New Balance is: " + newAccountHolder.getAmount() + "\n");
            }

        } else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }


    }

    public void viewAccounts() {

            if (accountHolder != null){
                System.out.println("Accounts Detail");
                System.out.println("----------------------");
                for (AccountHolders accountHolders1 : accountHolder){
                    System.out.println("Account ID: " + accountHolders1.getId());
                    System.out.println("Name: " + accountHolders1.getName());
                    System.out.println("Contact: " + accountHolders1.getContactNo());
                    System.out.println("Email: " + accountHolders1.getEmail());
                    System.out.println("CNIC: " + accountHolders1.getCnic());
                    System.out.println("Address: " + accountHolders1.getAddress());
                    System.out.println("Amount: " + accountHolders1.getAmount() + "\n");
                }
                System.out.println("----------------------");
            }else {
                System.out.println("There is no account to show");
            }
    }


    public void updateAccounts() {

        System.out.println("Enter Account Id To Update:");
        String id = scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolders : accountHolder){
            if (accountHolders.getId().equals(id)){
                newAccountHolder = accountHolders;
                break;
            }
        }
        if (newAccountHolder != null){
            System.out.println("Enter Contact: ");
            String newContact = scanner.nextLine();
            System.out.println("Enter Email: ");
            String newEmail = scanner.nextLine();
            System.out.println("Enter CNIC: ");
            String newCnic = scanner.nextLine();
            System.out.println("Enter Address: ");
            String newAddress = scanner.nextLine();

            newAccountHolder.setContactNo(newContact);
            newAccountHolder.setEmail(newEmail);
            newAccountHolder.setCnic(newCnic);
            newAccountHolder.setAddress(newAddress);

            System.out.println("Account Updated Successfully");

        }else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }

    }

    public void deleteAccounts() {

        System.out.println("Enter Account Id To Remove: ");
        String id = scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolders : accountHolder){
            if (accountHolders.getId().equals(id)){
                newAccountHolder = accountHolders;
                break;
            }
        }
        if (newAccountHolder != null){
            accountHolder.remove(newAccountHolder);
            System.out.println("Account Removed Successfully");
        }else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }
    }

    public void menu() {

        System.out.println("\n==Welcome To Our Bank Management System==\n");

        while (true) {
            System.out.println("==Login Page==\n");
            System.out.println("1. Admin");
            System.out.println("2. Account Holder");
            System.out.println("3. Exit");
            System.out.println("Select Your Role: ");
            int role = scanner.nextInt();
            scanner.nextLine();

            if (role == 1) {
                loginForAdmin();
            } else if (role == 2) {
                loginForAccountHolders();
            } else if (role == 3) {
                break;
            } else {
                System.out.println("Please Enter Valid Choice");
            }

        }
    }
}
