package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "/", layout = MainLayout.class)
@RouteAlias(value = "/dashboard", layout = MainLayout.class)
@PageTitle("DashBoard | VaadinBasics")
public class DashboardLayout extends VerticalLayout {

    private Notification ApplicationFormNotification;
    private Button submitApplication_Btn;
    private Button cancelApplication_Btn;
    private Button addApplication_Btn;
    private TextField companyName;
    private TextField position;
    private DatePicker dateApplied;
    private TextField source;
    private TextArea notes;

    H3 dashboardLabel = new H3("Dashboard");

    /** Dashboard constructor */
    public DashboardLayout(){
        addClassName("dashboard-layout");

        HorizontalLayout topLayout = new HorizontalLayout(dashboardLabel, addApplication() );
        topLayout.setDefaultVerticalComponentAlignment(Alignment.END);
        topLayout.setPadding(true);
        add(topLayout);

    }

    /** Generates Add application button details */
    private Button addApplication() {

        addApplication_Btn = new Button("Add Application");
        H3 applicationFromHeader = new H3("Enter Application Details");

        addApplication_Btn.addClickListener(e -> {
            ApplicationFormNotification = new Notification(
                    applicationFromHeader,
                    generateApplicationForm(),
                    generateFormButtons());

            ApplicationFormNotification.setPosition(Notification.Position.MIDDLE);
            ApplicationFormNotification.open();
            addApplication_Btn.setEnabled(false);
        });

        return addApplication_Btn;
    }

    /** Generates Application form */
    private FormLayout generateApplicationForm() {
        FormLayout applicationFormLayout = new FormLayout();

        companyName = new TextField("Company Name: ");
        position = new TextField("Position: ");
        dateApplied = new DatePicker("Date Applied: ");
        source = new TextField("Source: ");
        source.setPlaceholder("Indeed, Glassdoor etc..");
        notes = new TextArea("Notes: ");
        notes.setPlaceholder("Note to self / Follow Up Contact Name or Email");


        companyName.setClearButtonVisible(true);
        position.setClearButtonVisible(true);
        dateApplied.setClearButtonVisible(true);
        source.setClearButtonVisible(true);
        notes.setClearButtonVisible(true);

        /** Get Date picker in front*/
        applicationFormLayout.add(companyName, position, dateApplied, source, notes);

        return applicationFormLayout;

    }

    /** Generate Add Application Form Buttons */
    private HorizontalLayout generateFormButtons(){

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        buttonLayout.setSpacing(true);

        submitApplication_Btn = new Button("Submit");
        cancelApplication_Btn = new Button("Cancel");

        submitApplication_Btn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelApplication_Btn.addThemeVariants(ButtonVariant.LUMO_ERROR);
        buttonLayout.add(submitApplication_Btn, cancelApplication_Btn);
        buttonLayout.setPadding(true);

        submitApplication_Btn.addClickListener(e ->{
            ApplicationFormNotification.close();
            addApplication_Btn.setEnabled(true);
        });

        cancelApplication_Btn.addClickListener(e ->{
            ApplicationFormNotification.close();
            addApplication_Btn.setEnabled(true);
        });

        return buttonLayout;
    }
}
