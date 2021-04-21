package com.example.application.views.main;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the example-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("example-view")
@JsModule("./example-view.ts")
@Route(value = "/example", layout = MainLayout.class)
@PageTitle("Example Trial and Error | VaadinBasics")
public class ExampleView extends LitTemplate {

    @Id("typeHere_tf")
    private TextField typeHere_tf;
    @Id("submit_btn")
    private Button submit_btn;

    /**
     * Creates a new ExampleView.
     */
    public ExampleView() {
        // You can initialise any data required for the connected UI components here.

        submit_btn.addClickListener(e -> {
            Notification.show( typeHere_tf.getValue());
        });

    }

}
