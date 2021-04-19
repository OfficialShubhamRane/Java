package com.example.application.views.main;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "/", layout = MainLayout.class)
@PageTitle("DashBoard | VaadinBasics")
public class DashboardLayout extends VerticalLayout {

    public DashboardLayout(){
        add(new Text("Dashboard"));
    }
}
