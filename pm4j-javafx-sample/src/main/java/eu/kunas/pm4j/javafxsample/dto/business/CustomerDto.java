package eu.kunas.pm4j.javafxsample.dto.business;

import java.io.Serializable;

/**
 * This can be youre Entity or any other dto.
 * It is the Business Object.
 * <p/>
 * Created by ramazan on 22.11.13.
 */
public class CustomerDto implements Serializable {


    private Long id;

    private String firstName;

    private String lastName;

    private String mobile;

    public CustomerDto() {

    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
