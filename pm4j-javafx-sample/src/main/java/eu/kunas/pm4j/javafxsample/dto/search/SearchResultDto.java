package eu.kunas.pm4j.javafxsample.dto.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramazan on 22.11.13.
 */
public class SearchResultDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> labels = new ArrayList<String>();

    private List<SearchResultItemDto> resultSet = new ArrayList<SearchResultItemDto>();

    public List<String> getLabels() {
        return this.labels;
    }

    public void setLabels(final List<String> labels) {
        this.labels = labels;
    }

    public List<SearchResultItemDto> getResultSet() {
        return this.resultSet;
    }

    public void setResultSet(final List<SearchResultItemDto> resultSet) {
        this.resultSet = resultSet;
    }
}
