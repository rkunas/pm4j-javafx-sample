package eu.kunas.pm4j.javafxsample.controls;

import eu.kunas.pm4j.javafxsample.utilities.PageLoader;

public class MyComboBoxWithoutLabelBuilder {

    private MyComboBoxWithoutLabel control = null;

    public MyComboBoxWithoutLabelBuilder() {
        this.control = (MyComboBoxWithoutLabel) new PageLoader().loadController("/eu/kunas/pm4j/javafxsample/controls/MyComboBoxWithoutLabel.fxml");

    }

    public MyComboBoxWithoutLabel build() {
        return control;
    }
}
