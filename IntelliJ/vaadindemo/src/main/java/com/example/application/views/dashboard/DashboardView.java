package com.example.application.views.dashboard;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.dependency.CssImport;

@Route(value = "dashboard", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Dashboard")
@CssImport("./views/dashboard/dashboard-view.css")
public class DashboardView extends HorizontalLayout {

    private TextField name;
    private Button enterFirstName;

    public DashboardView() {
        addClassName("dashboard-view");

        name = new TextField("First Name");
        enterFirstName = new Button("Enter");
        add(name, enterFirstName);
        setVerticalComponentAlignment(Alignment.END, name, enterFirstName);

        enterFirstName.addClickListener(e -> {
            Notification.show("Welcome " + name.getValue());
        });
    }

}
