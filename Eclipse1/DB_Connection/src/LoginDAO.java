import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDAO {

	/** Declaring constants*/
	private static final long serialVersionUID = 1L;
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/application_portal";
	private final static String USERNAME = "root";
	private final static String PASS = "1234";
	
	protected static void login(String fname, String psw, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(URL, USERNAME, PASS);
			Statement stmtObj = conObj.createStatement();
			PrintWriter writer = response.getWriter();
			
			String retrivalQuery = "Select COUNT(email) AS count FROM application_portal.user WHERE fname = ? AND  password = ?;";
			PreparedStatement prepStmt_retrival = conObj.prepareStatement(retrivalQuery);
			prepStmt_retrival.setString(1, fname);
			
			//Password Hashing
			psw = MD5.getMd5(psw);
			prepStmt_retrival.setString(2, psw);

			ResultSet rs = prepStmt_retrival.executeQuery();
			rs.next();
			if(rs.getString("count").equals("1")) {
				writer.println("Welcome " + fname);
			}else {
				writer.println("fname and password combination is wrong, user does not exists");
			}
			
		}catch( Exception e) {
			System.out.println(e);
		}
		
	}
	
	
}
