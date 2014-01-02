package eu.kunas.pm4j.javafxsample.controls;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

import org.pm4j.core.pm.PmCommand;

public class MyButton implements Initializable, MyControl {

    @FXML
    public Node view;

    @FXML
    public Button button;

    private PmCommand pmCommand = null;

    private List<MyControl> doItControls = null;

    public void bindPm(final PmCommand command) {
        this.pmCommand = command;
        refresh();
    }

    public void refresh() {
        this.button.setText(this.pmCommand.getPmTitle());
        this.button.setDisable(!this.pmCommand.isPmEnabled());
    }

    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {

    }

    protected void registerOnActionRefresh(final MyControl control) {
        if (this.doItControls == null) {
            this.doItControls = new ArrayList<MyControl>();
        }

        this.doItControls.add(control);
    }

    private void onActionRefresh() {
        if (this.doItControls != null) {
            for (final MyControl control : this.doItControls) {
                control.refresh();
            }
        }
    }

    @FXML
    private void onAction() {
        this.pmCommand.doIt();
        onActionRefresh();
    }

    public Node getView() {
        return this.view;
    }

}
