package com.example.application.views.main;

import com.example.application.Application;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;

@PageTitle("DashBoard | AMP")
public class MainLayout extends AppLayout{

    public MainLayout(){

        createDrawer();
        createNavBar();

    }

    private void createNavBar() {
        HorizontalLayout layout = new HorizontalLayout();

        /** Replace application name with logo*/
        H3 ApplicationName = new H3("Application Management Portal");

        layout.add( new DrawerToggle(), ApplicationName);
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.END);
        addToNavbar(layout);

    }

    private void createDrawer() {
        RouterLink dashboardLink = new RouterLink("Dashboard", DashboardLayout.class);
        RouterLink addApplicationLink = new RouterLink("Add Application", AddApplication.class);
        RouterLink applicationsListLink = new RouterLink("Applications List", ApplicationList.class);
        RouterLink aboutLink = new RouterLink("About", AboutLayout.class);

        addToDrawer(new VerticalLayout(
                dashboardLink,
                addApplicationLink,
                applicationsListLink,
                aboutLink

        ));
    }

}
