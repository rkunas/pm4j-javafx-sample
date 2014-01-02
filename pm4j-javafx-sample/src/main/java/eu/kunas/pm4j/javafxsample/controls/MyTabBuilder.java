package eu.kunas.pm4j.javafxsample.controls;

import javafx.scene.Node;

import org.pm4j.core.pm.PmTab;

public class MyTabBuilder {

    private MyTab control = null;

    public MyTabBuilder(final MyTab labTab) {
        this.control = labTab;
    }

    public MyTabBuilder() {
        this.control = new MyTab();
    }

    public MyTabBuilder withContent(final Node node) {
        this.control.setContent(node);
        return this;
    }

    public MyTabBuilder withBindPm(final PmTab tab) {
        this.control.bindPm(tab);
        return this;
    }

    public MyTabBuilder withItem(final MyControl control) {
        return this;
    }

    public MyTab build() {
        return this.control;
    }

}
