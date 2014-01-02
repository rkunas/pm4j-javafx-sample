package eu.kunas.pm4j.javafxsample.dto.search;

import java.io.Serializable;

/**
 * Created by ramazan on 24.11.13.
 */
public class SearchItemDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String field;

    private Object value;

    public SearchItemDto() {

    }

    public String getField() {
        return this.field;
    }

    public void setField(final String field) {
        this.field = field;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(final Object value) {
        this.value = value;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
