package com.example.application.views.main;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the applicaation-list template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("applicaation-list")
@JsModule("./application-list.ts")
@Route(value = "/application-list", layout = MainLayout.class)
@PageTitle("Applications List | Vaadin Basics")
public class ApplicationList extends LitTemplate {

    /**
     * Creates a new ApplicationList.
     */
    public ApplicationList() {
        // You can initialise any data required for the connected UI components here.
    }

}
