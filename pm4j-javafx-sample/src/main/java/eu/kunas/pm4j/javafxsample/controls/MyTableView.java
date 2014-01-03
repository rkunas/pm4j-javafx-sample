package eu.kunas.pm4j.javafxsample.controls;

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
import org.pm4j.core.pm.PmAttr;
import org.pm4j.core.pm.PmTable2;
import org.pm4j.core.pm.PmTableCol2;
import org.pm4j.core.pm.PmTableRow;
import org.pm4j.core.pm.impl.PmTableRowImpl;
import org.pm4j.core.pm.impl.PmUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MyTableView implements Initializable {

    @FXML
    public Node view;

    @FXML
    private TableView<PmTableRow> table;

    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {

    }

    public Node getView() {
        return this.view;
    }

    public void bindPm(final PmTable2 table2) {

        final List<PmTableCol2> columns = table2.getColumnPms();

        for (final PmTableCol2 pmTableCol2 : columns) {

            final TableColumn column = new TableColumn();

            column.setText(pmTableCol2.getPmTitle());

            column.setCellValueFactory(new Callback<CellDataFeatures<PmTableRowImpl, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(final CellDataFeatures<PmTableRowImpl, String> row) {

                    final PmAttr attr = (PmAttr) PmUtil.findChildPm(row.getValue(), pmTableCol2.getPmName());

                    return new ReadOnlyObjectWrapper(attr.getValueAsString());

                }
            });

            this.table.getColumns().add(column);

        }
        //
        final List beanList = new ArrayList();

        for (final Object o : table2.getRowPms()) {
            final PmTableRow rowPm = (PmTableRow) o;

            beanList.add(rowPm.getPmBean());
        }
        //
        final ObservableList data = FXCollections.observableArrayList(table2.getRowPms());

        this.table.setItems(data);

    }
}
