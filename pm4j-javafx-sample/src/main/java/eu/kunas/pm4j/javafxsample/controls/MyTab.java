package eu.kunas.pm4j.javafxsample.controls;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import org.pm4j.core.pm.PmTab;

import java.util.ArrayList;
import java.util.List;

public class MyTab extends Tab implements MyControl {

    private PmTab tab;

    private final List<MyControl> refreshControls = new ArrayList<MyControl>(0);

    public void bindPm(final PmTab atab) {
        this.tab = atab;
        refresh();
    }

    @Override
    public void refresh() {
        setText(this.tab.getPmTitle());
        setDisable(!this.tab.isPmEnabled());
    }

    protected void registerRefresh(final MyControl control) {
        this.refreshControls.add(control);
    }

    @Override
    public Node getView() {
        return null;
    }

    public PmTab getPmTab() {
        return this.tab;
    }

}
