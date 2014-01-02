package eu.kunas.pm4j.javafxsample.dto.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramazan on 24.11.13.
 */
public class SearchDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<SearchItemDto> items = new ArrayList<SearchItemDto>();

    public SearchDto() {

    }

    public List<SearchItemDto> getItems() {
        return this.items;
    }

    public void setItems(final List<SearchItemDto> items) {
        this.items = items;
    }
}
