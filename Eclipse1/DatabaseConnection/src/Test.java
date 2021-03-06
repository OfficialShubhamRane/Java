
import java.sql.*;
public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String URL = "jdbc:mysql://localhost:3306/world";
		String userName = "root";
		String passWord = "1234";
		String query = "select * from world";
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection con = DriverManager.getConnection(URL, userName, passWord);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name = rs.getString("ID");
		System.out.println(name);
		
		st.close();
		con.close();
	}

}
 