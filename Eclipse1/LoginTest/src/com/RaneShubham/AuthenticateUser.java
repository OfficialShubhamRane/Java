package com.RaneShubham;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet ("/AuthenticateUser")
public class AuthenticateUser extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("Entered in Authenticate user");
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String action = request.getParameter("action");
		
		
		Map<String,String> HashDB = new HashMap<String, String>();
		HashDB.put("Shubham", "1234");

		
		PrintWriter out = response.getWriter();
		// Login
		if(action.equals("login")) {
			
			if(HashDB.containsKey(userName) && HashDB.get(userName).equals(passWord)) {
				System.out.println("Access Granted");
				out.println("Access Granted");
				
			}
			else {
				System.out.println("Access Denied");
				out.println("Access Denied");

			}
			
		// Sign up
		}else if(action.equals("signup")){
			System.out.print("Trying sign up, add in db");
			//check if uName exists in DB
			if(HashDB.containsKey(userName)) {			
				System.out.println("UserName exists, choose something else");
				out.println("UserName exists, choose something else");
				
			}else {
				HashDB.put(userName, passWord);
				System.out.println("Enter uname and pssword in db");
				out.println("Enter uname and pssword in db");
			}
		}
		
		
		
		
	}
}
