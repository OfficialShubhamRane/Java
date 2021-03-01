import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", 
					"hplussport", "postgres", "password");
		try {
			Connection connection = dcm.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
