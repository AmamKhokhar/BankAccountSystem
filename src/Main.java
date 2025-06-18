import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args) {


        BankAccountImpl bankAccount = new BankAccountImpl();

//        AccountHolders accountHolder1 = new AccountHolders("1",1122,"Amam","03099052901","amam@gmail.com","34104-79781777","Lahore",5000.00);
//        AccountHolders accountHolder2 = new AccountHolders("2",2211,"Ali","03908798645","ali@gmail.com","332096754673","Multan",5000.00);
//        AccountHolders accountHolder3 = new AccountHolders("3",1234,"Hamza","03109876789","hamza@gmail.com","34105-6578678","Multan",3000.00);
//        bankAccount.addAccount(accountHolder1);
//        bankAccount.addAccount(accountHolder2);
//        bankAccount.addAccount(accountHolder3);

        Admin admin1 = new Admin(1,1122,"Ahmed","03099988765","ahmed@gmail.com","Peshawar");
        bankAccount.addAdmin(admin1);

        bankAccount.menu();


    }
}