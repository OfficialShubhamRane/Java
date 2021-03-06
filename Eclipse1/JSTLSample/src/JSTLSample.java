import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSTLSample extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Hello");
		String name = "Shubham";
		
		req.setAttribute("name1", name);
		
		RequestDispatcher rd = req.getRequestDispatcher("feltCuteDeleteLater.jsp");
		rd.forward(req, res);
		
	}
}
