package eu.kunas.pm4j.javafxsample.controls;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class MyComboBox implements MyControl {

    @FXML
    private Node view;

    @FXML
    public Label fieldLabel;

    @FXML
    public ComboBox comboBox;

    @Override
    public void refresh() {

    }

    @Override
    public Node getView() {
        return view;
    }

}
