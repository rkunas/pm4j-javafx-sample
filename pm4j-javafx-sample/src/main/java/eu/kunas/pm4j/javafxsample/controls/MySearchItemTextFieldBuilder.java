package eu.kunas.pm4j.javafxsample.controls;

import eu.kunas.pm4j.javafxsample.pm.search.SearchItemTableRowPm;
import eu.kunas.pm4j.javafxsample.utilities.PageLoader;

public class MySearchItemTextFieldBuilder {

    private MySearchItemTextField control = null;

    public MySearchItemTextFieldBuilder() {
        this.control = (MySearchItemTextField) new PageLoader().loadController("/eu/kunas/pm4j/javafxsample/controls/MySearchItemTextField.fxml");
    }

    public MySearchItemTextField build() {
        return this.control;
    }

    public MySearchItemTextFieldBuilder withBindPm(final SearchItemTableRowPm pmAttr) {
        this.control.bindPm(pmAttr);
        return this;
    }

}
