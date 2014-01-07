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
 * Controller for the view and handlers.
 * Entry Point
 * <p/>
 * Connection between the UI Components and the Pm Model.
 * <p/>
 * Created by ramazan
 */
public class CustomerController implements Initializable {

    CustomerDialogPm customerDialogPm = new CustomerDialogPm();
    MyButton saveButton;
    MyButton newButton;
    MyButton deleteButton;
    MySearchResultTableView results;
    CustomerService service = new CustomerService();
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
    private MyTextField mobile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        customerDialogPm.customerService = service;

        results = new MySearchResultTableViewBuilder().withBindPm(customerDialogPm.searchPm).build();
        results.refresh();

        menu.getChildren().add(results.getView());

        // @formatter:off
        firstname = new MyTextFieldBuilder()
                .withBindPm(customerDialogPm.details.firstName)
                .build();

        lastname = new MyTextFieldBuilder()
                .withBindPm(customerDialogPm.details.lastName)
                .build();

        mobile = new MyTextFieldBuilder()
                .withBindPm(customerDialogPm.details.mobile)
                .build();

        saveButton = new MyButtonBuilder()
                .withBindPm(customerDialogPm.saveCommand)
                .withRegisterSelfOnAction()
                .withRegisterOnAction(results)
                .withRegisterOnAction(firstname)
                .withRegisterOnAction(lastname)
                .withRegisterOnAction(mobile)
                .build();

        newButton = new MyButtonBuilder()
                .withBindPm(customerDialogPm.newCommand)
                .withRegisterOnAction(lastname)
                .withRegisterOnAction(newButton)
                .withRegisterOnAction(saveButton)
                .withRegisterOnAction(firstname)
                .withRegisterOnAction(mobile)
                .build();

        deleteButton = new MyButtonBuilder()
                .withBindPm(customerDialogPm.deleteCommand)
                .withRegisterSelfOnAction()
                .withRegisterOnAction(results)
                .withRegisterOnAction(lastname)
                .withRegisterOnAction(firstname)
                .withRegisterOnAction(mobile)
                .build();
        // @formatter:on

        results.registerOnSelectRefresh(saveButton);
        results.registerOnSelectRefresh(deleteButton);

        newButton.refresh();
        saveButton.refresh();
        deleteButton.refresh();

        header.getChildren().add(newButton.getView());
        header.getChildren().add(saveButton.getView());
        header.getChildren().add(deleteButton.getView());

        results.registerOnSelectRefresh(firstname);
        results.registerOnSelectRefresh(lastname);
        results.registerOnSelectRefresh(mobile);

        content.getChildren().add(firstname.getView());
        content.getChildren().add(lastname.getView());
        content.getChildren().add(mobile.getView());

    }

    public Node getView() {
        return view;
    }
}
