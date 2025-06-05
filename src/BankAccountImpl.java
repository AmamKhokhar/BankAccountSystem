import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountImpl implements BankAccount{

    // Fields
    private List<AccountHolders> accountHolder;
    private List<Admin> admins;
    public Integer id = null;

    Scanner scanner = new Scanner(System.in);

    // Parameterized Constructor
    BankAccountImpl() {
        accountHolder = new ArrayList<>();
        admins = new ArrayList<>();
    }

    public List<AccountHolders> getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(List<AccountHolders> accountHolder) {
        this.accountHolder = accountHolder;
    }

//    public void addAccount(AccountHolders accountHolders) {
//        accountHolder.add(accountHolders);
//    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }


    @Override
    public void loginForAccountHolders() {

//        System.out.println("\n==Login Page==\n");
        System.out.println("Enter Your Account ID: ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Your Pin: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolders : accountHolder) {
            if (accountHolders.getId()==id){
                newAccountHolder = accountHolders;
                break;
            }
        }
        if (newAccountHolder != null) {
            if (newAccountHolder.getPin() == pin) {
                System.out.println("Logged in Successfully\n");
                System.out.println("Account Detail");
                System.out.println("----------------------");
                System.out.println("ID: " + newAccountHolder.getId());
                System.out.println("Name: " + newAccountHolder.getName());
                System.out.println("Contact: " + newAccountHolder.getContact());
                System.out.println("Email: " + newAccountHolder.getEmail());
                System.out.println("Address: " + newAccountHolder.getAddress());
                System.out.println("Amount: " + newAccountHolder.getAmount());
                System.out.println("----------------------");
                System.out.println();

                while (true) {

                    System.out.println("1. Deposit Money");
                    System.out.println("2. Withdraw Money");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Logout\n");
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

    @Override
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

                    System.out.println("1. Add Account");
                    System.out.println("2. View Accounts");
                    System.out.println("3. Update Account");
                    System.out.println("4. Delete Account");
                    System.out.println("5. Logout");
                    System.out.println("Select Your Choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice==1){
                        addAccount();
                    } else if (choice == 2) {
                        viewAccount();
                    } else if (choice == 3) {
                        updateAccount();
                    } else if (choice == 4) {
                        deleteAccount();
                    } else if (choice == 5) {
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

    @Override
    public void checkBalance() {
//        System.out.println("Enter Your Account ID: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolder : accountHolder) {
            if (accountHolder.getId()==id) {
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

    @Override
    public void deposit() {

//        System.out.println("Enter Your Account ID: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();


        System.out.println("Enter Amount To Deposit: ");
        double amountToDeposit = scanner.nextDouble();
        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolder : accountHolder) {
            if (accountHolder.getId()==id) {
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

    @Override
    public void withdrawAmount() {

//        System.out.println("Enter Your Account ID: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();

        System.out.println("Enter Amount To Withdraw: ");
        double amountToWithdraw = scanner.nextDouble();
        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolders1 : accountHolder) {
            if (accountHolders1.getId()==id) {
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

    @Override
    public void addAccount(){

        System.out.println("Enter Account Information");
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Pin: ");
        int pin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Contact No: ");
        String contact = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Cnic: ");
        String cnic = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Amount to Deposit Minimum 1000");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        AccountHolders accountHolder1 = new AccountHolders(accountHolder.size()+1,pin,name,contact,email,cnic,address,amount);
        accountHolder.add(accountHolder1);

        System.out.println("Account Added Successfully");
    }

    @Override
    public void viewAccount() {

            if (accountHolder.isEmpty()){
                System.out.println("There is no account to show");
            }else {
                System.out.println("Accounts Detail");
                System.out.println("----------------------");
                for (AccountHolders accountHolders1 : accountHolder){
                    System.out.println("Account ID: " + accountHolders1.getId());
                    System.out.println("Name: " + accountHolders1.getName());
                    System.out.println("Contact: " + accountHolders1.getContact());
                    System.out.println("Email: " + accountHolders1.getEmail());
                    System.out.println("CNIC: " + accountHolders1.getCnic());
                    System.out.println("Address: " + accountHolders1.getAddress());
                    System.out.println("Amount: " + accountHolders1.getAmount() + "\n");
                }
                System.out.println("----------------------");
            }
    }


    @Override
    public void updateAccount() {

        System.out.println("Enter Account Id To Update:");
        int id = scanner.nextInt();
        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolders : accountHolder){
            if (accountHolders.getId()==id){
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

            newAccountHolder.setContact(newContact);
            newAccountHolder.setEmail(newEmail);
            newAccountHolder.setCnic(newCnic);
            newAccountHolder.setAddress(newAddress);

            System.out.println("Account Updated Successfully");

        }else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }

    }

    @Override
    public void deleteAccount() {

        System.out.println("Enter Account Id To Remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolders : accountHolder){
            if (accountHolders.getId()==id){
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

    @Override
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
