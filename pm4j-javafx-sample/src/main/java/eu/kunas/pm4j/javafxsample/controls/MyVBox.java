package eu.kunas.pm4j.javafxsample.controls;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class MyVBox implements MyControl {

    private VBox vbox = null;

    private final List<MyControl> toRefresh = new ArrayList<MyControl>(0);

    public MyVBox() {
        this.vbox = new VBox();
    }

    @Override
    public void refresh() {
        for (final MyControl c : this.toRefresh) {
            c.refresh();
        }
    }

    public void addItem(final MyControl control) {
        this.vbox.getChildren().add(control.getView());
        this.toRefresh.add(control);
    }

    @Override
    public Node getView() {
        return this.vbox;
    }
}
