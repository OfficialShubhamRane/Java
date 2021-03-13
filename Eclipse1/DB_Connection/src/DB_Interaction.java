import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DB_Interaction")
public class DB_Interaction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//First Method
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System .out.println("***Entered in DB_Interaction***"); //for debugging 
		
		ServletContext context_act = getServletContext();  
		String act = (String)context_act.getAttribute("act");  
		
		// Calling Signup from SignUpDAO method
		if(act.equals("signup")) {
			String fname = request.getParameter("fname").toString().trim();
			String lname = request.getParameter("lname").toString().trim();
			String email = request.getParameter("email").toString().trim();
			String psw = request.getParameter("psw").toString().trim();
			
			SignUpDAO.signUp(fname, lname, email, psw, act, request, response);
			
		}else
		
		// Calling login from loginDAO method
		if(act.equals("login")) {
			String fname = request.getParameter("fname").toString().trim();
			String psw = request.getParameter("psw").toString().trim();
		
			LoginDAO.login(fname, psw, request, response);
		}
		
	}
	
}
