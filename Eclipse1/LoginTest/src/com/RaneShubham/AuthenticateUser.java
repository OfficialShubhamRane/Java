package com.RaneShubham;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet ("/AuthenticateUser")
public class AuthenticateUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("Entered in Authenticate user");
		
		String uName = request.getParameter("userName");
		String pWord = request.getParameter("passWord");
		String action = request.getParameter("action");
		
		Map<String,String> HashDB = new HashMap<String, String>();
		HashDB.put("Shubham", "1234");
		
		
		// Login
		if(action.equals("login")) {
			
			if(HashDB.containsKey(uName) && HashDB.get(uName).equals(pWord)) {
				System.out.println("Access Granted");
				
			}
			else {
				System.out.println("Access Denied");
				response.sendRedirect("LoginPortal");
			}
			
		// Sign up
		}else if(action.equals("signup")){
			System.out.print("Trying sign up, add in db");
			//check if uName exists in DB
			if(HashDB.containsKey(uName)) {			
				System.out.println("UserName exists, choose something else");
				response.sendRedirect("LoginPortal");
				
			}else {
				HashDB.put(uName, pWord);
				response.sendRedirect("LoginPortal");
			}
		}
		
		
		
		
	}
}
