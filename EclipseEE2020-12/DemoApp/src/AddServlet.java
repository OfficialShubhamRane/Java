import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** This class file is for one single servlet class*/
public class AddServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		// Accepting input from html form
		int x = Integer.parseInt(req.getParameter("num1")); 	
		int y = Integer.parseInt(req.getParameter("num2"));
//		
//		// data processing
		int add = x + y;
		
		res.sendRedirect("sq?addition="+add);
		
		
		
		//sending data through res object
//		req.setAttribute("addition", add);
		
		//creating connection between two servlets
//		RequestDispatcher reqDis = req.getRequestDispatcher("sq");
//		reqDis.forward(req, res);
	}
	
	public int add(int x, int y) {
		return x + y;
	}
	
	 
}
