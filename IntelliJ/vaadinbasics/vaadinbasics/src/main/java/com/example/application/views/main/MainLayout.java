package com.example.application.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;


@PageTitle("DashBoard | VaadinBasics")
public class MainLayout extends AppLayout{

    public MainLayout(){

        createDrawer();
        createNavBar();

    }

    private void createNavBar() {
        HorizontalLayout layout = new HorizontalLayout();

        /** Replace application name with logo*/
        H3 ApplicationName = new H3("Vaadin Basics");

        layout.add( new DrawerToggle(), ApplicationName);
        layout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.END);
        addToNavbar(layout);

    }

    private void createDrawer() {
        RouterLink dashboardLink = new RouterLink("Dashboard", DashboardLayout.class);
        RouterLink aboutLink = new RouterLink("About", AboutLayout.class);
        RouterLink trialError = new RouterLink("Trial&Error", Trial_ErrorLayout.class);


        addToDrawer(new VerticalLayout(
                dashboardLink,
                trialError,
                aboutLink

        ));
    }

}
