package eu.kunas.pm4j.javafxsample.controls;

import eu.kunas.pm4j.javafxsample.utilities.PageLoader;

public class MyTextAreaBuilder {

    private MyTextArea control = null;

    public MyTextAreaBuilder() {
        this.control = (MyTextArea) new PageLoader().loadController("/eu/kunas/pm4j/javafxsample/controls/MyTextArea.fxml");
    }

    public MyTextArea build() {
        return this.control;
    }
}
