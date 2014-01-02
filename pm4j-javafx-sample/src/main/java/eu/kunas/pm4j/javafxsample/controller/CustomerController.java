package eu.kunas.pm4j.javafxsample.controller;

import eu.kunas.pm4j.javafxsample.controls.*;
import eu.kunas.pm4j.javafxsample.pm.customer.CustomerDialogPm;
import eu.kunas.pm4j.javafxsample.service.CustomerService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ramazan on 22.11.13.
 */
public class CustomerController implements Initializable {

    CustomerDialogPm customerDialogPm = new CustomerDialogPm();

    @FXML
    private VBox menu;

    @FXML
    private VBox content;

    @FXML
    private Node view;

    @FXML
    private HBox header;

    private MyTextField firstname;
    private MyTextField lastname;

    MyButton saveButton;
    MyButton newButton;
    MyButton deleteButton;

    MySearchResultTableView results;

    CustomerService service = new CustomerService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        customerDialogPm.customerService = service;
        customerDialogPm.init();

        results = new MySearchResultTableViewBuilder().withBindPm(customerDialogPm.searchPm).build();
        results.refresh();

        menu.getChildren().add(results.getView());

        firstname = new MyTextFieldBuilder().withBindPm(customerDialogPm.details.firstName).build();
        lastname = new MyTextFieldBuilder().withBindPm(customerDialogPm.details.lastName).build();

        saveButton = new MyButtonBuilder().withBindPm(customerDialogPm.saveCommand).build();
        newButton = new MyButtonBuilder().withBindPm(customerDialogPm.newCommand).withRegisterOnAction(lastname).withRegisterOnAction(firstname).build();
        deleteButton = new MyButtonBuilder().withBindPm(customerDialogPm.deleteCommand).build();

        newButton.refresh();
        saveButton.refresh();
        deleteButton.refresh();


        header.getChildren().add(newButton.getView());
        header.getChildren().add(saveButton.getView());
        header.getChildren().add(deleteButton.getView());

        results.registerOnSelectRefresh(firstname);
        results.registerOnSelectRefresh(lastname);

        content.getChildren().add(firstname.getView());
        content.getChildren().add(lastname.getView());

    }

    public Node getView() {
        return view;
    }
}
