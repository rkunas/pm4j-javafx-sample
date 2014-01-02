package eu.kunas.pm4j.javafxsample.controls;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class MyVBoxBuilder {

    private MyVBox control = null;

    public MyVBoxBuilder() {
        this.control = new MyVBox();
    }

    public MyVBoxBuilder(final MyVBox c) {
        this.control = c;
    }

    public MyVBoxBuilder withItem(final MyControl c) {
        this.control.addItem(c);
        return this;
    }

    protected MyVBoxBuilder withDefaultSpaces() {
        final VBox v = (VBox) this.control.getView();
        v.setPadding(new Insets(10, 10, 10, 10));

        v.setSpacing(10);
        return this;
    }

    public MyVBox build() {
        withDefaultSpaces();
        return this.control;
    }
}
