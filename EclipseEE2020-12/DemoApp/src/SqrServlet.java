import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SqrServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		System.out.println("Entered in SqrServlet");
		
		 //Accepting/fetching data from res object
//		int addition = Integer.parseInt(req.getParameter("addition")) ;
		
		//Using Session
//		HttpSession session = req.getSession();
//		int addition = (int) session.getAttribute("addition");
		
		int addition=0;
		//Using Cookie
		Cookie cookies[] = req.getCookies();
		
		for( Cookie c : cookies) {
			if(c.getName().equals("addition")) {
				addition = Integer.parseInt(c.getValue());
			}
		}
		
		int square = addition * addition;
		System.out.println(square);
		
		//printing
		PrintWriter out = res.getWriter();
		out.println("Result is: " + square);
	
	}
}
