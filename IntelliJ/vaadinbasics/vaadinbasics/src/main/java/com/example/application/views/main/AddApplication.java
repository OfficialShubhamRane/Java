package com.example.application.views.main;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.ButtonOptions;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the add-application template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Route(value = "/add-application", layout = MainLayout.class)
@PageTitle("Add Applications | AMP")
public class AddApplication extends VerticalLayout {

    /**
     * Creates a new AddApplication.
     */
    public AddApplication() {

        setFormLayoutWindow( );

    }

    /** Generate application form*/
    private VerticalLayout generateApplicationForm() {

        VerticalLayout layoutWithFormItems = new VerticalLayout();

        TextField companyName = new TextField("Company name : ");
        companyName.setPlaceholder("Google");

        TextField positionName = new TextField("Position applied : ");
        positionName.setPlaceholder("Associate");

        TextField location = new TextField( "Location : " );
        location.setPlaceholder("New York, California etc");

        TextField sourceAppliedFrom = new TextField( "Source : " );
        sourceAppliedFrom.setPlaceholder("Indeed/Glassdoor etc");

        DatePicker appliedOn  = new DatePicker( "Date Applied" );

        HorizontalLayout buttonLayout = new HorizontalLayout();
        Button submitBtn = new Button("Submit");
        Button cancelBtn = new Button("Cancel");
        buttonLayout.add( submitBtn, cancelBtn );

        layoutWithFormItems.add(companyName);
        layoutWithFormItems.add(positionName);
        layoutWithFormItems.add(appliedOn);
        layoutWithFormItems.add(sourceAppliedFrom);
        layoutWithFormItems.add(location);
        layoutWithFormItems.add( buttonLayout );

        return layoutWithFormItems;

    }

    /** Generate layout to set application form */
    private void setFormLayoutWindow( ){

        HorizontalLayout horizontalLayout = new HorizontalLayout( generateApplicationForm() );
        horizontalLayout.getStyle().set( "border", "1px solid #9E9E9E" );
        horizontalLayout.setJustifyContentMode( FlexComponent.JustifyContentMode.CENTER );
        horizontalLayout.setDefaultVerticalComponentAlignment( Alignment.END );

        add( horizontalLayout );


    }



}
