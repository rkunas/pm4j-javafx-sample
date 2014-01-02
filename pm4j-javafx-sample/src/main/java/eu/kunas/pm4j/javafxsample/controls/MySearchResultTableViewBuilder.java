package eu.kunas.pm4j.javafxsample.controls;

import org.pm4j.core.pm.PmObject;

import eu.kunas.pm4j.javafxsample.utilities.PageLoader;

public class MySearchResultTableViewBuilder {

    private MySearchResultTableView control = null;

    public MySearchResultTableViewBuilder() {
        this.control = (MySearchResultTableView) new PageLoader().loadController("/eu/kunas/pm4j/javafxsample/controls/MySearchResultTableView.fxml");

    }

    public MySearchResultTableView build() {
        return this.control;
    }

    public MySearchResultTableViewBuilder withRegisterOnSelected(final MyControl lControl) {
        this.control.registerOnSelectRefresh(lControl);
        return this;
    }

    public MySearchResultTableViewBuilder withBindPm(final PmObject table) {
        this.control.bindPm(table);
        return this;
    }
}
