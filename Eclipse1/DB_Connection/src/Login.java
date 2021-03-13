

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("***Entered in login***"); //debugging
		
		String fname = request.getParameter("fname");
		String psw = request.getParameter("psw");

		
		request.setAttribute("fname", fname);
		request.setAttribute("psw", psw);
		
		ServletContext context_act = getServletContext();  
		context_act.setAttribute("act","login");

		RequestDispatcher reqDis_DB = request.getRequestDispatcher("DB_Interaction");
		reqDis_DB.forward(request, response);
	}

}
