package com.example.application.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddApplicationDAO {

    String URL = "jdbc:mysql://127.0.0.1:3306/application_portal?autoreconnect=true";
    String PASSWORD = "1234";
    String USERNAME = "root";



    public AddApplicationDAO() throws SQLException {

        ApplicationToDatabase();

    }

    private void ApplicationToDatabase() throws SQLException {

        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement stmt = con.createStatement();

    }


}
