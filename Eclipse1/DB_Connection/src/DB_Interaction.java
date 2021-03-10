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
	private final String URL = "jdbc:mysql://127.0.0.1:3306/application_portal";
	private final String USERNAME = "root";
	private final String PASS = "1234";
	
	//First Method
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System .out.println("Entered in DB_Interaction");
		
		String fname = request.getParameter("fname").toString().trim();
		String lname = request.getParameter("lname").toString().trim();
		String email = request.getParameter("email").toString().trim();
		String psw = request.getParameter("psw").toString().trim();
		String act = request.getParameter("signup").toString().trim();
		
		//Calling Signup method
		if(act.equals("signup")) {
			SignUpDAO.signUp(fname, lname, email, psw, act, request, response);
		}

		
	}
	
	
}
