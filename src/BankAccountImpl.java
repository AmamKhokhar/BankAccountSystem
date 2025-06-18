import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountImpl implements BankAccount{

    private List<AccountHolders> accountHolder;
    private List<Admin> admins;
    public Integer id = null;
    public Integer employId = null;
    public int pin;
    String url = "jdbc:mysql://localhost:3306/bankaccountsystem";
    String username = "root";
    String password = "amam";




    Scanner scanner = new Scanner(System.in);

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

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    AccountHolders newAccountHolder = null;
    public void findAccountHolder(int id){
        for (AccountHolders accountHolders : accountHolder) {
            if (accountHolders.getId()==id){
                newAccountHolder = accountHolders;
                break;
            }
        }
    }

    Admin newAdmin = null;
    public void findAdmin(int employId){
        for (Admin admin : admins) {
            if (admin.getEmployId()==employId) {
                newAdmin = admin;
                break;
            }
        }

    }

    @Override
    public void loginForAccountHolders() {

        while (true){
            System.out.println("Enter Your Account ID: ");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                break;
            }else {
                System.out.println("Invalid Input. Please Enter a Number");
                scanner.next();
            }
        }
        scanner.nextLine();

        System.out.println("Enter Your Pin: ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        findAccountHolder(id);

        if (newAccountHolder != null) {
            if (newAccountHolder.getPin() == pin) {
                System.out.println("Logged in Successfully\n"
                                    +"Account Detail\n"
                                    +"----------------------\n"
                                    +"ID: " + newAccountHolder.getId()+"\n"
                                    +"Name: " + newAccountHolder.getName()+"\n"
                                    +"Contact: " + newAccountHolder.getContact()+"\n"
                                    +"Email: " + newAccountHolder.getEmail()+"\n"
                                    +"Address: " + newAccountHolder.getAddress()+"\n"
                                    +"Amount: " + newAccountHolder.getAmount()+"\n"
                                    +"----------------------"+"\n");

                while (true){
                        System.out.println("1. Deposit Money\n"
                                +"2. Withdraw Money\n"
                                +"3. Check Balance\n"
                                +"4. Logout\n"
                                +"\nSelect Your Choice: ");

                        if (scanner.hasNextInt()){
                            int choice = scanner.nextInt();
                                if (choice == 1) {
                                    deposit();
                                } else if (choice == 2) {
                                    withdrawAmount();
                                } else if (choice == 3) {
                                    checkBalance();
                                } else if (choice == 4) {
                                    break;
                                }

                        }
                        else {
                            System.out.println("Invalid input. Please Enter number b/w 1-4");
                            scanner.next();
                        }
                }


            }
            else {
                System.out.println("You Entered the Wrong Pin");
            }
        }
        else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }

    }

    @Override
    public void loginForAdmin() {

        while(true){
            System.out.println("Enter Your Employ ID: ");
            if (scanner.hasNextInt()){
                employId = scanner.nextInt();
                while (true){
                    System.out.println("Enter Your Pin: ");
                    if (scanner.hasNextInt()){
                        pin = scanner.nextInt();
                        break;
                    }else {
                        System.out.println("Invalid Pin. Please Enter Numbers");
                        scanner.next();
                    }
                }
                break;
            }else {
                System.out.println("Invalid input. Please enter number");
                scanner.next();
            }
        }

        findAdmin(employId);

        if (newAdmin != null) {
            if (newAdmin.getPin() == pin) {
                    System.out.println("Logged in Successfully\n"+
                                        "Admin Details\n"+
                                        "----------------------\n"+
                                        "EmployId: " + newAdmin.getEmployId()+"\n"+
                                        "Name: " + newAdmin.getName()+"\n"+
                                        "Contact: " + newAdmin.getContact()+"\n"+
                                        "Email: " + newAdmin.getEmail()+"\n"+
                                        "Address: " + newAdmin.getAddress()+"\n"+
                                        "----------------------");

                while (true) {
                    System.out.println("1. Add Account\n"+
                                        "2. View Accounts\n"+
                                        "3. Update Account\n"+
                                        "4. Delete Account\n"+
                                        "5. Logout\n"+
                                        "Select Your Choice: ");
                    if (scanner.hasNextInt()){
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
                    }else {
                        System.out.println("Invalid input. Please enter a number b/w 1-5");
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

        findAccountHolder(id);

        if (newAccountHolder != null) {
            System.out.println("Your Balance is: " + newAccountHolder.getAmount() + "\n");
        } else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }

    }

    @Override
    public void deposit() {

        double amountToDeposit;
        while (true){
            System.out.println("Enter Amount To Deposit: ");
            if (scanner.hasNextInt()){
                amountToDeposit = scanner.nextDouble();
                if(amountToDeposit>=1000.00 && amountToDeposit<=50000.00){
                    break;
                }
                else {
                    System.out.println("Invalid Amount. Please Enter Amount b/w 1000-50000");
                    scanner.next();
                }
            }else {
                System.out.println("Invalid Input. Please Enter Numbers");
                scanner.next();
            }

        }

        findAccountHolder(id);

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

        double amountToWithdraw;
        while (true){
            System.out.println("Enter Amount To Withdraw: ");
            if (scanner.hasNextInt()){
                amountToWithdraw = scanner.nextDouble();
                scanner.nextLine();
                if (amountToWithdraw>=1000.00 && amountToWithdraw<=50000.00){
                    break;
                }else {
                    System.out.println("Invalid Amount. Amount Must Be b/w 1000-50000");
                }
            }else {
                System.out.println("Invalid Input. Please Enter Numbers");
            }

        }
        findAccountHolder(id);

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
    public void addAccount() {
        String name, email, contact, cnic, address;
        double amount;
        int  pin;

        System.out.println("=== Enter Account Information ===");
        System.out.print("Enter Id: ");
        id = scanner.nextInt();
        scanner.nextLine();

        // Name
        while (true) {
            System.out.print("Enter Name: ");
            name = scanner.nextLine();
            if (name.matches("[a-zA-Z\\s]+")) break;
            System.out.println("Invalid Name. Use only letters and spaces.");
        }

        // Pin
        while (true) {
            System.out.print("Enter PIN (4-digit number): ");
            if (scanner.hasNextInt()) {
                pin = scanner.nextInt();
                if (pin >= 1000 && pin <= 9999) {
                    scanner.nextLine(); // clear buffer
                    break;
                } else {
                    System.out.println("PIN must be a 4-digit number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }

        // Contact Number
        while (true) {
            System.out.print("Enter Contact No (e.g., 03XXXXXXXXX): ");
            contact = scanner.nextLine();
            if (contact.matches("03\\d{9}")) break;
            System.out.println("Invalid contact number. Format should be 03XXXXXXXXX.");
        }

        // Email
        while (true) {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
            if (email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) break;
            System.out.println("Invalid email format.");
        }

        // CNIC
        while (true) {
            System.out.print("Enter CNIC (xxxxx-xxxxxxx-x): ");
            cnic = scanner.nextLine();
            if (cnic.matches("\\d{5}-\\d{7}-\\d{1}")) break;
            System.out.println("Invalid CNIC format.");
        }

        // Address
        System.out.print("Enter Address: ");
        address = scanner.nextLine(); // basic input, no validation applied

        // Deposit Amount
        while (true) {
            System.out.print("Enter Amount to Deposit (1000 - 100000): ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine(); // clear buffer
                if (amount >= 1000.00 && amount <= 100000.00) break;
                System.out.println("Amount must be between 1000 and 100000.");
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // clear invalid input
            }
        }

        String query = "insert into accountholders(id,pin,holder_name,email,contact,address,cnic,amount) values(?,?,?,?,?,?,?,?)";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully !!");

            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established !!");

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,pin);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,email);
            preparedStatement.setString(5,contact);
            preparedStatement.setString(6,address);
            preparedStatement.setString(7,cnic);
            preparedStatement.setDouble(8,amount);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Account Added Successfully !!");
            }else {
                System.err.println("Account is not added");
            }

        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        // Add Account
//        AccountHolders accountHolder1 = new AccountHolders(accountHolder.size() + 1, pin, name, contact, email, cnic, address, amount);
//        accountHolder.add(accountHolder1);

//        System.out.println("✅ Account Added Successfully!");
    }


    @Override
    public void viewAccount() {

        String query = "select * from accountholders";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully !!");

            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established !!");

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                System.out.println("=====================");
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("Name: "+rs.getString("holder_name"));
                System.out.println("Email: "+rs.getString("email"));
                System.out.println("Contact: "+rs.getString("contact"));
                System.out.println("Address: "+rs.getString("address"));
                System.out.println("Current Balance: "+rs.getDouble("amount"));
                System.out.println();
            }

        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }





//            if (accountHolder.isEmpty()){
//                System.out.println("There is no account to show");
//            }else {
//                System.out.println("Accounts Detail");
//                System.out.println("----------------------");
//                for (AccountHolders accountHolders1 : accountHolder){
//                    System.out.println("Account ID: " + accountHolders1.getId()+"\n"+
//                                        "Name: " + accountHolders1.getName()+"\n"+
//                                        "Contact: " + accountHolders1.getContact()+"\n"+
//                                        "Email: " + accountHolders1.getEmail()+"\n"+
//                                        "CNIC: " + accountHolders1.getCnic()+"\n"+
//                                        "Address: " + accountHolders1.getAddress()+"\n"+
//                                        "Amount: " + accountHolders1.getAmount() + "\n");
//                }
//                System.out.println("----------------------");
//            }
    }


    @Override
    public void updateAccount() {

        String contact , email , address;

        while (true){
            System.out.println("Enter Account Id To Update:");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            }else {
                System.out.println("Invalid Input. Please Enter Numbers");
                scanner.next();
            }
        }

        while (true){

                System.out.println("Enter Contact(03XXXXXXXXX): ");
                contact = scanner.nextLine();
                if (contact.matches("03\\d{9}")){
                    break;
                }else {
                    System.out.println("Input Number in Formate(03XXXXXXXXX) :");
                }
        }

        while (true){
            System.out.println("Enter Email");
            email = scanner.nextLine();
            if (email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")){
                break;
            }else {
                System.out.println("Invalid Email Format");
            }
        }
                System.out.println("Enter Address");
                address = scanner.nextLine();

        try{

            String query = "update accountholders set email = ?, contact = ?, address = ?" +
                    " where id = ?";
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully !!");

            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established Successfully !!");

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,contact);
            preparedStatement.setString(3,address);
            preparedStatement.setInt(4,id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Account updated successfully !!");
            }else {
                System.out.println("Account does not updated");
            }

        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }



//        findAccountHolder(id);
//
//        if(newAccountHolder != null){
//
//            while (true){
//
//                System.out.println("Enter Contact(03XXXXXXXXX): ");
//                contact = scanner.nextLine();
//                if (contact.matches("03\\d{9}")){
//                    break;
//                }else {
//                    System.out.println("Input Number in Formate(03XXXXXXXXX) :");
//                }
//            }
//
//            while (true){
//                System.out.println("Enter Email");
//                email = scanner.nextLine();
//                if (email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")){
//                    break;
//                }else {
//                    System.out.println("Invalid Email Format");
//                }
//            }
//            System.out.println("Enter Address");
//            address = scanner.nextLine();
//
//            newAccountHolder.setContact(contact);
//            newAccountHolder.setEmail(email);
//            newAccountHolder.setAddress(address);
//            System.out.println("✅ Account Updated Successfully");
//
//
//        }else {
//            System.out.println("Account Does Not Exist With ID: " + id + "\n");
//        }
    }

    @Override
    public void deleteAccount() {

        while (true){
            System.out.println("Enter Account Id To Remove: ");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                break;
            }else {
                System.out.println("Invalid Input. Please Enter Numbers");
                scanner.next();
            }
        }


        try{

            String query = "delete from accountholders" +
                            " where id = ?";
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully !!");

            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established Successfully !!");

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Account deleted successfully !!");
            }else {
                System.out.println("Account is not deleted");
            }

        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }

        //        findAccountHolder(id);
//
//        if (newAccountHolder != null){
//            accountHolder.remove(newAccountHolder);
//            System.out.println("Account Removed Successfully");
//        }else {
//            System.out.println("Account Does Not Exist With ID:" + id + "\n");
//        }
    }

    public void DbConnectivity(){}

    @Override
    public void menu() {

        System.out.println("\n==Welcome To Our Bank Management System==\n");

        while (true) {
            System.out.println("==Login Page==\n"+
                                "1. Admin\n"+
                                "2. Account Holder\n"+
                                "3. Exit\n"+
                                "Select Your Role: ");

            if (scanner.hasNextInt()){
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
            }else {
                System.out.println("Invalid Input. Please Select Options b/w 1-3");
            }

        }
    }
}
