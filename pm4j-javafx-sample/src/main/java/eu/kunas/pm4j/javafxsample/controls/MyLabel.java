package eu.kunas.pm4j.javafxsample.controls;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * Created by ramazan on 17.11.13.
 */
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
