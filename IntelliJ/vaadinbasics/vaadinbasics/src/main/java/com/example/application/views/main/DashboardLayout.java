package com.example.application.views.main;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Tag("dashboard")
@JsModule("./dashboard-view.ts")
@Route(value = "/", layout = MainLayout.class)
@RouteAlias(value = "/dashboard", layout = MainLayout.class)
@PageTitle("DashBoard | VaadinBasics")
public class DashboardLayout extends VerticalLayout {

    /** Dashboard constructor */
    public DashboardLayout(){

        setBaseDashboardLayout();

    }

    /** Create base skeleton layout for dashboard */
    private void setBaseDashboardLayout() {

        Div barChart_1_div = new Div( new Label(" Place holder for First Bar Chart") );
        barChart_1_div.setHeight("200px");
        Div pieChart_1_div = new Div( new Label(" Place holder for First Pie Chart") );
        pieChart_1_div.setHeight("400px");
        Div pieChart_2_div = new Div( new Label(" Place holder for Second Pie Chart"));
        pieChart_2_div.setHeight("400px");

        Label barChart_1 = new Label("First Bar Chart");
        Label pieChart_1 = new Label("First Pie Chart");
        Label pieChart_2 = new Label("Second Pie Chart");

        SplitLayout horizontalSplitLayout = new SplitLayout();
        horizontalSplitLayout.addToPrimary(pieChart_1_div);
        horizontalSplitLayout.addToSecondary(pieChart_2_div);

        SplitLayout layout = new SplitLayout();
        layout.setOrientation( SplitLayout.Orientation.VERTICAL );
        layout.addToPrimary( horizontalSplitLayout );
        layout.addToSecondary( barChart_1_div );

        add(layout);

    }

}
