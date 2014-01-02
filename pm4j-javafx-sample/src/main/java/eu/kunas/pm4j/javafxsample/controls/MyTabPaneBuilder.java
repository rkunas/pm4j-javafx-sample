package eu.kunas.pm4j.javafxsample.controls;

import org.pm4j.core.pm.PmTabSet2;

import eu.kunas.pm4j.javafxsample.utilities.PageLoader;

public class MyTabPaneBuilder {

    private MyTabPane control = null;

    public MyTabPaneBuilder() {
        this.control = (MyTabPane) new PageLoader().loadController("/eu/kunas/pm4j/javafxsample/controls/MyTabPane.fxml");

    }

    public MyTabPane build() {
        return this.control;
    }

    public MyTabPaneBuilder withBindPm(final PmTabSet2 tabset) {
        this.control.pmObject = tabset;
        return this;
    }

    public MyTabPaneBuilder withTab(final MyTab tab) {
        this.control.addTab(tab);
        return this;
    }
}
