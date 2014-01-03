package eu.kunas.pm4j.javafxsample.controls;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import org.pm4j.core.pm.PmMessage;
import org.pm4j.core.pm.PmMessage.Severity;

import eu.kunas.pm4j.javafxsample.pm.search.SearchItemTableRowPm;

public class MySearchItemTextField implements Initializable, MyControl {

    @FXML
    public Node view;

    @FXML
    public Label fieldLabel;

    @FXML
    public TextField fieldValue;

    public Tooltip tooltip = new Tooltip();

    @FXML
    public ImageView errorIcon;

    protected int limit = 0;

    private SearchItemTableRowPm pmAttr = null;

    public MySearchItemTextField() {
        this.tooltip.getStyleClass().add("ttip");
    }

    public void bindPm(final SearchItemTableRowPm attr) {
        this.pmAttr = attr;
        this.fieldLabel.setText(this.pmAttr.title.getValueAsString());
        this.fieldValue.setText(this.pmAttr.value.getValueAsString());
        this.limit = this.pmAttr.value.getMaxLen();
    }

    public void refresh() {
        this.fieldValue.setText(this.pmAttr.value.getValueAsString());
        if (!this.pmAttr.isPmValid()) {
            final List<PmMessage> messages = this.pmAttr.getPmConversation().getPmMessages(this.pmAttr, Severity.ERROR);
            if (!messages.isEmpty()) {
                this.tooltip.setText(messages.get(0).getTitle());
            }
            Tooltip.install(getView(), this.tooltip);
            addError();
        } else {
            Tooltip.uninstall(getView(), this.tooltip);
            removeError();
        }
    }

    protected void limitValue() {
        try {
            if (MySearchItemTextField.this.fieldValue.getText().length() >= MySearchItemTextField.this.limit) {
                MySearchItemTextField.this.fieldValue.replaceText(this.limit, this.fieldValue.getText().length(), "");
            }
        } catch (final Exception exc) {
            exc.printStackTrace();
        }
    }

    private void writeValue() {
        this.pmAttr.value.setValueAsString(this.fieldValue.getText());
    }

    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {

        this.fieldValue.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<Event>() {
            @Override
            public void handle(final Event arg0) {
                limitValue();
                writeValue();
            }
        });

        this.fieldValue.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(final ObservableValue<? extends Boolean> arg0, final Boolean arg1, final Boolean arg2) {
            }
        });

        this.fieldValue.getStyleClass().add("textfield");
    }

    public Node getView() {
        return this.view;
    }

    protected void addError() {
        this.fieldValue.getStyleClass().add("error");
        this.errorIcon.setVisible(true);
    }

    protected void removeError() {
        this.fieldValue.getStyleClass().remove("error");
        this.errorIcon.setVisible(false);
    }
}