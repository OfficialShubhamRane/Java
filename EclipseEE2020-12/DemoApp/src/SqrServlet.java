import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqrServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		// Accepting/fetching data from res object
		int addition = Integer.parseInt(req.getParameter("addition")) ;
		int square = addition * addition;
		
		//printing
		PrintWriter out = res.getWriter();
		out.println("Result is: " + square);
		
//		System.out.println("hello for sq"); // for debugging
	
	}
}
