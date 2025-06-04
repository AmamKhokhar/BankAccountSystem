import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount {

    // Fields
    private List<AccountHolders> accountHolder;
    Scanner scanner = new Scanner(System.in);

    // Parameterized Constructor
    BankAccount(){
        accountHolder = new ArrayList<>();
    }

    public List<AccountHolders> getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(List<AccountHolders> accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void addAccount(AccountHolders accountHolders){
        accountHolder.add(accountHolders);
    }

    public void checkBalance(){
        System.out.println("Enter Your Account ID: ");
        String id = scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolder : accountHolder){
            if(accountHolder.getId().equals(id)){
                newAccountHolder = accountHolder;
                break;
            }
        }
        if (newAccountHolder != null){
            System.out.println("Your Balance is: "+newAccountHolder.getAmount() + "\n");
        }else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }

    }

    public void deposit(){

        System.out.println("Enter Your Account ID: ");
        String id = scanner.nextLine();

        System.out.println("Enter Amount To Deposit: ");
        double amountToDeposit = scanner.nextDouble();
        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolder : accountHolder){
            if(accountHolder.getId().equals(id)){
                newAccountHolder = accountHolder;
                break;
            }
        }
        if (newAccountHolder != null){
            double newBalance = newAccountHolder.getAmount() + amountToDeposit;
            newAccountHolder.setAmount(newBalance);
            System.out.println("Amount Deposited successfully");
            System.out.println("Your New Balance is: " + newAccountHolder.getAmount() + "\n");
        }else{
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }
    }

    public void withdrawAmount(){

        System.out.println("Enter Your Account ID: ");
        String id = scanner.nextLine();

        System.out.println("Enter Amount To Withdraw: ");
        double amountToWithdraw = scanner.nextDouble();
        scanner.nextLine();

        AccountHolders newAccountHolder = null;
        for (AccountHolders accountHolders1 : accountHolder){
            if (accountHolders1.getId().equals(id)){
                newAccountHolder = accountHolders1;
                break;
            }
        }
        if (newAccountHolder != null){

            double newBalance = newAccountHolder.getAmount() - amountToWithdraw;

            if (newBalance < 0){
                System.out.println("You Have Sufficient Balance\n");
            }else{
                newAccountHolder.setAmount(newBalance);
                System.out.println("Your Amount is Withdraw Successfully");
                System.out.println("Your New Balance is: " + newAccountHolder.getAmount() + "\n");
            }

        }else {
            System.out.println("Account Does Not Exist With ID:" + id + "\n");
        }


    }

    public void menu(){

        System.out.println("\n==Welcome To Our Bank Management System==\n");

        while(true){

            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit\n");
            System.out.println("Select Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice==1){
                deposit();
            } else if (choice==2) {
                withdrawAmount();
            } else if (choice==3) {
                checkBalance();
            } else if (choice==4) {
                break;
            }else {
                System.out.println("Please Enter Valid Option");
            }

        }

    }
}
