package eu.kunas.pm4j.javafxsample.dto.search;

import java.io.Serializable;

/**
 * Created by ramazan on 22.11.13.
 */

public class BusinessKey implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;

    public BusinessKey(final Long id) {
        this.id = id;
    }

    public BusinessKey() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
