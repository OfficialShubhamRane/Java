import java.util.*;

public class Transaction {
    private double amount;
    private Date timeStamp;
    private String memo;
    private Account inAccount;

    public Transaction(double amount, Account inAccount){
        this.amount = amount;
        this.inAccount = inAccount;
        this.timeStamp = new Date();
        this.memo = "";
    }

    public Transaction(double amount, Account inAccount, String memo){
        this(amount, inAccount);
        this.memo = memo;
    }

}
