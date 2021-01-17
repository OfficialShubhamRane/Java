import java.util.*;
public class Account {
    /**
     * checking, saving
     */
    private String type;
    private String uuid;
    private User holder;
    private ArrayList<Transaction> transaction;

    public Account(String type, User holder, Bank theBank){

        //set up account holder info
        this.type = type;
        this.holder = holder;

        //get uuid for the account
        this.uuid = theBank.getNewAccountUUID();

        //get transactions in arrayList
        this.transaction = new ArrayList<Transaction>();
        
    }

    public String getUUID(){
        return this.uuid;
    }   

}
