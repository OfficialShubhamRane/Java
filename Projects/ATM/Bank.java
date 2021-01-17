import java.util.*;

public class Bank {
    private String bankName;
    /**
     * List of users
     */
    private ArrayList<User> users;
    /**
     * List of account 
     */
    private ArrayList<Account> accounts;

    /**
     * Create a new bank object with empty lists of users and account
     * @param bankName
     */
    public Bank(String bankName){
        this.bankName = bankName;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    } 


    //creating new UUID for indivisual customer
    public String getNewUserUUID(){
        String uuid = "";
        int lengthOfUUID = 6;
        boolean nonUnique = false;
        Random rand = new Random();
        do{
            
            //generate a uuid
            for(int i=0; i<lengthOfUUID; i++){
                uuid += ((Integer)rand.nextInt(10)).toString();
            }
        
            //check if its unique
            for (User u : this.users) {
                if(uuid.compareTo(u.getUUID())==0){
                    nonUnique = true;
                    break;
                }
            }
        }while(nonUnique);  
        
        return uuid;

    }

    //creating new UUID for the Bank
    public String getNewAccountUUID(){
        String uuid = "";
        int lengthOfUUID = 10;
        boolean nonUnique = false;
        Random rand = new Random();
        do{
            
            
            //generate a uuid
            for(int i=0; i<lengthOfUUID; i++){
                uuid += ((Integer)rand.nextInt(10)).toString();
            }
        
            //check if its unique
            for (Account acnt : this.accounts) {
                if(uuid.compareTo(acnt.getUUID())==0){
                    nonUnique = true;
                    break;
                }
            }
        }while(nonUnique);  

        return uuid;
    }

    //creating a user and adding it to bank list
    public User addUser(String firstName, String lastName, String pin){
        
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        //creating a saving account for new customer
        Account newAccount = new Account("Savings", newUser, this);

        //add account to holder and bank list
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;
    }

    //adding account to list of bank account 
    public void addAccount(Account anAccnt){
        this.accounts.add(anAccnt);
    }

    //validating userID and Pin entered
    public User userLogin(String userID, String pin){

        //search through list of user IDs
        for(User u: this.users){

            //if user found
            if(u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)){
                return u;
            }
        }
        return null;
    }

    //to get bank name
    public String getBankName(){
        return this.bankName;
    }









}
