package eu.kunas.pm4j.javafxsample.controls;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TabPane;

import org.pm4j.core.pm.PmTab;
import org.pm4j.core.pm.PmTabSet2;

public class MyTabPane implements MyControl {

    @FXML
    public Node view;

    @FXML
    public TabPane tabPane;

    public PmTabSet2 pmObject = null;

    public List<MyTab> tabs = new ArrayList<MyTab>(0);

    public void bindPm(final PmTabSet2 pmObjectExt) {
        this.pmObject = pmObjectExt;
    }

    @Override
    public void refresh() {
        final PmTab currentTab = this.pmObject.getCurrentTabPm();

        for (final MyTab labTab : this.tabs) {
            if (labTab.getPmTab().equals(currentTab)) {
                this.tabPane.getSelectionModel().select(labTab);
            }
        }
    }

    @Override
    public Node getView() {
        return this.view;
    }

    public void addTab(final MyTab tab) {
        this.tabPane.getTabs().add(tab);
        this.tabs.add(tab);
    }

}
