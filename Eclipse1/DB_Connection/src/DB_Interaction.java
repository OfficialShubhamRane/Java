import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DB_Interaction")
public class DB_Interaction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String URL = "jdbc:mysql://127.0.0.1:3306/application_portal";
	private String USERNAME = "root";
	private String PASS = "1234";
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System .out.println("Entered in DB_Interaction");
		
		String fname = request.getParameter("fname").toString().trim();
		String lname = request.getParameter("lname").toString().trim();
		String email = request.getParameter("email").toString().trim();
		String psw = request.getParameter("psw").toString().trim();
		String act = request.getParameter("signup").toString().trim();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(URL, USERNAME, PASS);
			Statement stmtObj = conObj.createStatement();
			
			if(act.equals("signup")) {
				boolean alreadtExists = false;
				
				// Statement to check whether entered fname exists in DB
				PreparedStatement prepStmt_retrival = conObj.prepareStatement("SELECT COUNT(?) AS count FROM application_portal.user WHERE fname=?");
				prepStmt_retrival.setString(1, fname);
				prepStmt_retrival.setString(2, fname);
				
				//calling query on DB
				ResultSet rs = prepStmt_retrival.executeQuery();
				rs.next();
				System.out.println(rs.getString("count"));
				
				
				if(rs.getString("count").equals("0")){
					PreparedStatement prepStmt_entry = conObj.prepareStatement("INSERT INTO application_portal.user (fname, lname, email, password) VALUES (?,?,?,?)");  
					prepStmt_entry.setString(1,fname);
					prepStmt_entry.setString(2,lname);  
					prepStmt_entry.setString(3,email);  
					prepStmt_entry.setString(4,psw);  
					
					prepStmt_entry.executeUpdate();
				}else if(rs.getString("count").equals("1")) {
					 PrintWriter write = response.getWriter();
					 write.println("fname already exists");
					 System.out.println("fname already exists");
				}
			}
			
			
			stmtObj.close();
			conObj.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
