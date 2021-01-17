import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String firstName;
    private String lastName;
    /**
     * Universal Unique ID
     */
    private String uuid;
    /**
     * Using MD5 to hash pin
     */
    private byte pinHash[];
    /**
     * One user will have multiple accounts
     */
    private ArrayList<Account> accounts;

    // Creates a user profile with initial information
    public User(String firstName, String lastName, String pin, Bank theBank) {

        // setup user's name
        this.firstName = firstName;
        this.lastName = lastName;

        // setup users PIN
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            this.pinHash = md5.digest(pin.getBytes());
        
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error caught, NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        this.uuid = theBank.getNewUserUUID();
        //create empty list of accounts
        this.accounts = new ArrayList<Account>();
        //print log message
        System.out.printf("New user %s, %s's ID is %s \n", this.lastName,this.firstName,this.uuid );
    }

    // adds account to particular useer's account list
    public void addAccount(Account anAccnt){
         this.accounts.add(anAccnt);
    }

    //returns userID of particular User
    public String getUUID(){
        return this.uuid;
    }   

    /**
     * Validates the pin entered by user
     */
    public boolean validatePin(String aPin){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            System.err.println("error caught, NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }
}
