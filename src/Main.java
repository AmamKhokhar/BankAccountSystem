import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();

        AccountHolders accountHolder1 = new AccountHolders("1","Amam","03099052901","amam@gmail.com","34104-79781777","Lahore",5000.00);
        AccountHolders accountHolder2 = new AccountHolders("2","Ali","03908798645","ali@gmail.com","332096754673","Multan",5000.00);
        bankAccount.addAccount(accountHolder1);
        bankAccount.addAccount(accountHolder2);

        bankAccount.menu();


    }
}