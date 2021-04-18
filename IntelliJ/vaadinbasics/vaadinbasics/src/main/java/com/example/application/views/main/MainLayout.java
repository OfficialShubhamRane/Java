package com.example.application.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("/")
@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout{

    TextField tf = new TextField();
    Button btn = new Button("Search");

    HorizontalLayout h_layout = new HorizontalLayout();

    public MainLayout(){
        tf.setPlaceholder("Search...");
        tf.setClearButtonVisible(true);

        btn.addClickListener(e -> {
            if(!tf.getValue().isEmpty()){
                Notification.show("Searching: ".concat( tf.getValue() ));
            }
        });

        h_layout.setPadding(true);
        h_layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.END);
        h_layout.add(tf, btn);
        addToNavbar(h_layout);
    }


}
