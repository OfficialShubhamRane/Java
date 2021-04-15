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
    private Button submitApplicationBtn;


    public EnterApplication() {
        addClassName("enterApplication-view");

        companyNameBtn = new TextField("Enter Company Name: ");
        position = new TextField("Enter Position: ");
        submitApplicationBtn = new Button("Submit");
        add(companyNameBtn, position, submitApplicationBtn);

        submitApplicationBtn.addClickListener(e ->{
            Notification.show("Application successfully submitted");
        });

    }

}
