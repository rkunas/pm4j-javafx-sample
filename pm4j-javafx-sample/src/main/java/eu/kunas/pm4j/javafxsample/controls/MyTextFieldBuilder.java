package eu.kunas.pm4j.javafxsample.controls;

import org.pm4j.core.pm.PmAttr;

import eu.kunas.pm4j.javafxsample.utilities.PageLoader;

public class MyTextFieldBuilder {

    private MyTextField control = null;

    public MyTextFieldBuilder() {
        this.control = (MyTextField) new PageLoader().loadController("/eu/kunas/pm4j/javafxsample/controls/MyTextField.fxml");
    }

    public MyTextField build() {
        return this.control;
    }

    public MyTextFieldBuilder withBindPm(final PmAttr pmAttr) {
        this.control.bindPm(pmAttr);
        return this;
    }

}
