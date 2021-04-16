package com.example.application.views.enterApplication;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "enterApplication", layout = MainView.class)
@PageTitle("Enter  Application")
@CssImport("./views/enterApplication/enterApplication-view.css")

public class EnterApplication extends HorizontalLayout {

    private TextField companyNameBtn;
    private TextField position;
    private TextField location;
    private TextField source;
    private Button submitApplicationBtn;


    public EnterApplication() {
        addClassName("enterApplication-view");

        companyNameBtn = new TextField("Company Name: ");
        position = new TextField("Position: ");
        location = new TextField("Location: ");
        source = new TextField("Source: ");

        submitApplicationBtn = new Button("Submit");

        VerticalLayout formLayout = new VerticalLayout(companyNameBtn, position, location, source, submitApplicationBtn );
        formLayout.setDefaultHorizontalComponentAlignment(Alignment.BASELINE);
        add(formLayout);

        submitApplicationBtn.addClickListener(e ->{
            Notification.show("Application successfully submitted");
        });

    }

}
