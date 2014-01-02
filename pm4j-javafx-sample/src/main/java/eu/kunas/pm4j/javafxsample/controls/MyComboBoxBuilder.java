package eu.kunas.pm4j.javafxsample.controls;

import eu.kunas.pm4j.javafxsample.utilities.PageLoader;

/**
 * Created by ramazan on 15.11.13.
 */
public class MyComboBoxBuilder {

    MyComboBox control = null;

    public MyComboBoxBuilder() {
        this.control = (MyComboBox) new PageLoader().loadController("/eu/kunas/pm4j/javafxsample/controls/MyComboBox.fxml");
    }

    public MyComboBox build() {
        return control;
    }
}
