package com.example.application.views.main;

import com.example.application.backend.entity.Company;
import com.example.application.backend.entity.Contact;
import com.example.application.backend.service.ContactService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("/")
public class MainView extends VerticalLayout {

    Grid<Contact> grid = new Grid<>(Contact.class);
    private ContactService contactService;

    public MainView(ContactService contactService) {
        this.contactService = contactService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(grid);
        updateList();

    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("company");

        grid.setColumns("firstName", "lastName", "email", "status");
        grid.addColumn(contact -> {
            Company company = contact.getCompany();
            return company == null ? "-" : company.getName();
        }).setHeader("Company");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));


    }


    private void updateList() {
        grid.setItems(contactService.findAll());
    }

}
