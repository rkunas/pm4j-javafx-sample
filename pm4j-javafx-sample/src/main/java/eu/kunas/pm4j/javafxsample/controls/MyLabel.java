package eu.kunas.pm4j.javafxsample.controls;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class MyLabel implements MyControl {

    @FXML
    Node view;

    @FXML
    public Label fieldLabel;

    @Override
    public void refresh() {

    }

    @Override
    public Node getView() {
        return view;
    }
}
