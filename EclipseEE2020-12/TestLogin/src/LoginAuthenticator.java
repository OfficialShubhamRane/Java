import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAuthenticator extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		System.out.println("Entered in LoginAuthenticator");
		
		//Creating sample userName-passWord Combo
		Map<String, String> loginCombinations = new HashMap<String,String>();
		
		loginCombinations.put("Shubham", "123");
		loginCombinations.put("Rahul", "123");
		loginCombinations.put("Vengu", "123");
		
		//Fetch userName-passWord Combo receiving from Servlet TestLogin
		String userName = req.getAttribute("userName").toString();
		String passWord = req.getAttribute("passWord").toString();
		
		//for debugging
		System.out.println(userName + " , " + passWord);
		
		// login for checking usrName-passWord combo
		if(loginCombinations.containsKey(userName) && passWord.equals(loginCombinations.get(userName))) {	//login successful
			System.out.println("Login Succesful");
			
			onSuccess(req, res, userName);
			
		}else {																			// login unsuccessful
			System.out.println("Login Unsuccessful");
			res.sendRedirect("login");
		}	
		
		System.out.println("Exiting from LoginAuthenticator");
	}
	
	public void onSuccess(HttpServletRequest req, HttpServletResponse res, String userName) throws IOException {
		
		System.out.println("Entered in onSucess()");
		
		HttpSession session = req.getSession();
		session.setAttribute("username", userName);
		
		res.sendRedirect("home");
		
	}
	
	
	
}
