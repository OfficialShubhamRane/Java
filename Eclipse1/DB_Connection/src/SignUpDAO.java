import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpDAO {
	
	/** Declaring constants*/
	private static final long serialVersionUID = 1L;
	
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/application_portal";
	private final static String USERNAME = "root";
	private final static String PASS = "1234";
	
	protected static void signUp(String fname, String lname, String email, String psw, String act, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(URL, USERNAME, PASS);
			Statement stmtObj = conObj.createStatement();
			
			boolean alreadtExists = false;
					
			// Statement to check whether entered fname exists in DB
			String query = "SELECT COUNT(?) AS count FROM application_portal.user WHERE fname=?";
			PreparedStatement prepStmt_retrival = conObj.prepareStatement(query);
			prepStmt_retrival.setString(1, fname);
			prepStmt_retrival.setString(2, fname);
					
			//calling query on DB
			ResultSet rs = prepStmt_retrival.executeQuery();
			rs.next();
			
					
			if(rs.getString("count").equals("0")){
				query = "INSERT INTO application_portal.user (fname, lname, email, password) VALUES (?,?,?,?)";
				PreparedStatement prepStmt_entry = conObj.prepareStatement(query);  
				prepStmt_entry.setString(1,fname);
				prepStmt_entry.setString(2,lname);  
				prepStmt_entry.setString(3,email);
				
				psw = MD5.getMd5(psw);
				prepStmt_entry.setString(4,psw);  
				
				prepStmt_entry.executeUpdate();
				
			}else if(rs.getString("count").equals("1")) {
				PrintWriter write = response.getWriter();
				write.println("fname already exists");
			}
			
			stmtObj.close();
			conObj.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
}
