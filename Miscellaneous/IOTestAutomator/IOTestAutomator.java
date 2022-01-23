/**
 * IOTestAutomator
 */

import java.io.*;  
import java.net.*;
public class IOTestAutomator {

    public IOTestAutomator(){
        readIOFile();
    }

    /** Read io.pl get the IPs of IBEs*/
    public void readIOFile(){

        try{  
            File file=new File("io.txt");    // creates a new file instance  
            FileReader fr=new FileReader(file);   // reads the file  
            BufferedReader br=new BufferedReader(fr);  // creates a buffering character input stream  
            StringBuffer allIPs=new StringBuffer();    // constructs a string buffer with no characters  
            String line;

            // while ther is data in file
            while((line = br.readLine())!=null)  
            {  
                // if there is ip on any line
                if(line.contains("{'ip'=>")){
                    StringBuffer currentIP = new StringBuffer();
                    int indexOfIP = line.indexOf("{'ip'=>'");
                    indexOfIP += 8;

                    // start working character by charcter and keep going till "'"
                    for(int i = indexOfIP ;i < line.length(); i++){
                        //as soo nas "'" is found. stop and return
                        if("'".equals(line.charAt(i)+"")){
                            pingIP(currentIP.toString());
                            break;
                        }
                        currentIP.append(line.charAt(i));                
                    }
                    System.out.println("currentIP: " + currentIP);

                }
                allIPs.append(line);     // appends line to string buffer  
                allIPs.append("\n");     // line feed   
            }  
            fr.close();    // closes the stream and release the resources  
            }  
        catch(IOException e){  
            e.printStackTrace();  
        }

    }

    /** Write those IPs in .csv */

    /** Read .csv and ping to those IPs */

    public void pingIP(String ip) throws UnknownHostException, IOException{

        InetAddress geek = InetAddress.getByName(ip);
        if (geek.isReachable(5000))
            System.out.println("Host "+ ip +" is reachable");
        else
            System.out.println("Sorry ! We can't reach to this host " + ip);

    }


    /** Read the response and note it down in a seperate .csv file
     * format can be 
     * "127.0.0.1,good,127.0.0.2,bad,....."
     */

     /** Generate good, easy to read UI from that file
      * Maybe a green light red light stuff
      */

    public static void main(String[] args) {
        IOTestAutomator obj = new IOTestAutomator();
    }
}