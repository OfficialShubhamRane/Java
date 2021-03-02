import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestLogin extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Entered in Test Login");
		
		//Fetching userName and Password submitted by user
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		
		//Calling method to validate userName-passWord Combo
		authenticate(userName, passWord, req, res);
		
		//para debugging
		System.out.println("Exiting from TestLogin");
	}
	
	public void authenticate(String userName, String passWord, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Calling Servlet LoginAuthenticator to check for userName-passWord Combo
		RequestDispatcher reqDis = req.getRequestDispatcher("loginAuthenticator");
		
		req.setAttribute("userName", userName);
		req.setAttribute("passWord", passWord);
		
		reqDis.forward(req, res);
		
		
		
	}
	
}
