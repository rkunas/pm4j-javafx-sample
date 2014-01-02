package eu.kunas.pm4j.javafxsample.controls;

import eu.kunas.pm4j.javafxsample.utilities.PageLoader;

/**
 * Created by ramazan on 15.11.13.
 */
public class MyComboBoxWithoutLabelBuilder {

    private MyComboBoxWithoutLabel control = null;

    public MyComboBoxWithoutLabelBuilder() {
        this.control = (MyComboBoxWithoutLabel) new PageLoader().loadController("/eu/kunas/pm4j/javafxsample/controls/MyComboBoxWithoutLabel.fxml");

    }

    public MyComboBoxWithoutLabel build() {
        return control;
    }
}
