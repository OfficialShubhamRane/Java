package com.example.application.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.sql.*;


@Route(value = "/trial&error", layout = MainLayout.class)
public class Trial_ErrorLayout extends VerticalLayout {

    Button btn;

    String URL = "jdbc:mysql://127.0.0.1:3306/application_portal?autoreconnect=true";
    String PASSWORD = "1234";
    String USERNAME = "root";
    Connection con = null;
    Statement stmt = null;

//    root@127.0.0.1:3306
//    jdbc:mysql://127.0.0.1:3306/?user=root


    public Trial_ErrorLayout() throws SQLException {

        formPopupWindow();



    }

    private void formPopupWindow() throws SQLException {
        btn = new Button("Click here");
        VerticalLayout layout = new VerticalLayout();
        layout.add(btn);
        btn.addClickListener(e -> {
            System.out.println("Button Clicked");

            try {
                System.out.println("Trying to make connection...");
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                stmt = con.createStatement();

                String getSQL = "SELECT * from application_portal.vaadinbasics";
                ResultSet rs = stmt.executeQuery(getSQL);

                while(rs.next()){
                    System.out.println(rs.getString("name"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            
        });

        add((layout));
    }
}
