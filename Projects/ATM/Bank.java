import java.util.*;

public class Bank {
    private String bankName;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;


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

    public void addAccount(Account anAccnt){
        this.accounts.add(anAccnt);
    }
}
