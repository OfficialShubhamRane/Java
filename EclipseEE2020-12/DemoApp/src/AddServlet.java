import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** This class file is for one single servlet class*/
public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		System.out.println("Entered in AddServlet");
		
		// Accepting input from html form
		int x = Integer.parseInt(req.getParameter("num1")); 	
		int y = Integer.parseInt(req.getParameter("num2"));
//		
//		// data processing
		int add = add(x, y);
		System.out.println("Addition is done"); // para Debugging
		

		//Using session
//		HttpSession session = req.getSession();
//		session.setAttribute("addition", add);
		
		// Using Cookies
		Cookie additionCookie = new Cookie("addition", String.valueOf(add));
		res.addCookie(additionCookie);
		
		
		
		
		// Using redirect method  to servlet page sq
		res.sendRedirect("sq");
		System.out.println("Exiting from AddServlet");	// para Debugging
		
		// sending data through res object
//		req.setAttribute("addition", add);
		
		// creating connection between two servlets
//		RequestDispatcher reqDis = req.getRequestDispatcher("sq");
//		reqDis.forward(req, res);
	}
	
	public int add(int x, int y) {
		return x + y;
	}
	
	 
}
