package com.RaneShubham;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(description = "Accept and validate username and password", urlPatterns = { "/LoginPortal" })
public class LoginPortal extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entered in LoginPortal");

		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String action = request.getParameter("action");
			

		request.setAttribute("userName", userName);
		request.setAttribute("passWord", passWord);
		request.setAttribute("action", action);
			
			
		RequestDispatcher rd = request.getRequestDispatcher("AuthenticateUser");
		rd.forward(request, response);
		
		PrintWriter out = response.getWriter();
		out.print("Hello");
			
		
		
		
	}

}
