package com.example.application.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


@Route(value = "/dashboard")
@PageTitle("DashBoard | VaadinBasics")
public class MainLayout extends AppLayout{

    public MainLayout(){

        createDrawer();
        createNavBar();

    }

    private void createNavBar() {
        H3 ApplicationName = new H3("Vaadin Basics");
        addToNavbar(new DrawerToggle(), ApplicationName);
    }

    private void createDrawer() {
        RouterLink dashboardLink = new RouterLink("Dashboard", DashboardLayout.class);
        RouterLink aboutLink = new RouterLink("About", AboutLayout.class);

        addToDrawer(new VerticalLayout(
                dashboardLink,
                aboutLink
        ));
    }

}
