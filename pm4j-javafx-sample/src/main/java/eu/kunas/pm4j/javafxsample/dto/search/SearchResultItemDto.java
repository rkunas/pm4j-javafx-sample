package eu.kunas.pm4j.javafxsample.dto.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramazan on 22.11.13.
 */
public class SearchResultItemDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private BusinessKey key;

    private List<String> dataset = new ArrayList<String>();

    public SearchResultItemDto() {

    }

    public BusinessKey getKey() {
        return this.key;
    }

    public void setKey(final BusinessKey key) {
        this.key = key;
    }

    public List<String> getDataset() {
        return this.dataset;
    }

    public void setDataset(final List<String> dataset) {
        this.dataset = dataset;
    }
}
