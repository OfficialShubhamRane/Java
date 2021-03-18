import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.util.UUIDGenerator;

@SuppressWarnings("serial")
@WebServlet ("/SignUp")
public class SignUp extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("***Entered in SignUp servlet***"); // for debugging
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");
		String psw_repeat = request.getParameter("psw_repeat");
		
		boolean passMatched=true, fnameLen=true, lnameLen=true, passLen=true;
		
		PrintWriter write = response.getWriter();
		
		/*
		 * Do input valiadation here
		 * 
		 * */
	
		//if first name exceeds length
		if(fname.length() > 14) {
			write.println("fnameLength exceeds length");
			fnameLen = false;
		}
		//if last name exceeds length
		if(lname.length() > 14) {
			write.println("lnameLength exceeds length");
			lnameLen = false;
		}
		// password and confirm password should be equal to each other
		if(!psw.equals(psw_repeat)) {
			 
			 write.println("Provided password do not match its confirmation");
			 passMatched = false;
		}
		if(psw.length() < 8) {
			write.println("Password should contain atleast 8 characters");
			passLen = false;
		}
			
		if (passMatched && fnameLen && lnameLen && passLen) {
			
			/*
			 * Generate UUID here
			 */
			
			request.setAttribute("fname",fname);
			request.setAttribute("lname",lname);
			request.setAttribute("email",email);
			request.setAttribute("psw",psw);
			
			ServletContext context_act = getServletContext();
			context_act.setAttribute("act", "signup");
			
			RequestDispatcher reqDis_DB = request.getRequestDispatcher("DB_Interaction");
			reqDis_DB.forward(request, response);
			
			
			
		}else {
			System.out.println("***Some condition is not satisfied***");
		}
		
	}
}