package eu.kunas.pm4j.javafxsample.controls;

import org.pm4j.core.pm.PmCommand;

import eu.kunas.pm4j.javafxsample.utilities.PageLoader;

public class MyButtonBuilder {

    private MyButton control = null;

    public MyButtonBuilder() {
        this.control = (MyButton) new PageLoader().loadController("/eu/kunas/pm4j/javafxsample/controls/MyButton.fxml");
    }

    public MyButton build() {
        return this.control;
    }

    public MyButtonBuilder withRegisterOnAction(final MyControl lControl) {
        this.control.registerOnActionRefresh(lControl);
        return this;
    }

    public MyButtonBuilder withRegisterSelfOnAction() {
        this.control.registerOnActionRefresh(this.control);
        return this;
    }

    public MyButtonBuilder withBindPm(final PmCommand command) {
        this.control.bindPm(command);
        return this;
    }
}
