package eu.kunas.pm4j.javafxsample.controls;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MyComboBoxWithoutLabel implements MyControl, Initializable {

    @FXML
    private Node view;

    @FXML
    public ComboBox comboBox;

    @Override
    public void refresh() {

    }

    @Override
    public Node getView() {
        return view;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
