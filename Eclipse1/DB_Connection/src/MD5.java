import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	protected static String getMd5(String input) 
    { 
        try { 
        	System.out.println("***Entered in MD5***");
        
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            BigInteger no = new BigInteger(1, messageDigest); 
   
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }
  
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e);
        } 
    } 
}