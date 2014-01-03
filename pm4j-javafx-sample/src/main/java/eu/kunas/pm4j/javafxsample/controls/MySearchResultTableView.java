package eu.kunas.pm4j.javafxsample.controls;

import eu.kunas.pm4j.javafxsample.dto.search.SearchResultDto;
import eu.kunas.pm4j.javafxsample.dto.search.SearchResultItemDto;
import eu.kunas.pm4j.javafxsample.pm.search.CustomerSearchPm;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.pm4j.core.pm.PmObject;
import org.pm4j.core.pm.impl.PmBeanBase;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MySearchResultTableView implements Initializable, MyControl {

    @FXML
    public Node view;

    @FXML
    TableView<SearchResultItemDto> table;

    private List<MyControl> doItControls = null;

    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {

    }

    public Node getView() {
        return this.view;
    }

    private PmBeanBase pmObject = null;

    public void bindPm(final PmObject o) {
        this.pmObject = (PmBeanBase) o;

    }

    private void onSelectedModel() {
        final CustomerSearchPm searchPm = (CustomerSearchPm) this.pmObject;

        if (this.table.getSelectionModel().getSelectedItem() != null) {
            searchPm.selected = this.table.getSelectionModel().getSelectedItem();
            searchPm.viewCommand.doIt();
            onSelectedRefresh();
        }
    }

    private void onSelectedRefresh() {
        if (this.doItControls != null) {
            for (final MyControl control : this.doItControls) {
                control.refresh();
            }
        }
    }

    public void registerOnSelectRefresh(final MyControl control) {
        if (this.doItControls == null) {
            this.doItControls = new ArrayList<MyControl>();
        }

        this.doItControls.add(control);
    }

    @FXML
    private void onMouseClicked() {
        onSelectedModel();
    }

    @FXML
    private void onKeyReleased() {
        onSelectedModel();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void refresh() {
        this.table.getColumns().clear();
        final SearchResultDto result = (SearchResultDto) this.pmObject.getPmBean();

        int i = 0;

        for (final String label : result.getLabels()) {
            final TableColumn column = new TableColumn();
            final int index = i;
            column.setText(label);

            column.setCellValueFactory(new Callback<CellDataFeatures<SearchResultItemDto, String>, ObservableValue<String>>() {

                public ObservableValue<String> call(final CellDataFeatures<SearchResultItemDto, String> row) {

                    return new ReadOnlyObjectWrapper(row.getValue().getDataset().get(index));

                }
            });

            this.table.getColumns().add(column);
            i++;

        }
        final ObservableList data = FXCollections.observableArrayList(result.getResultSet());

        this.table.setItems(data);
    }
}
