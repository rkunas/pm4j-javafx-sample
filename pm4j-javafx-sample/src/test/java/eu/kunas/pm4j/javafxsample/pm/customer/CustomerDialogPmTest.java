package eu.kunas.pm4j.javafxsample.pm.customer;

import eu.kunas.pm4j.javafxsample.pm.customer.CustomerDialogPm;
import eu.kunas.pm4j.javafxsample.service.CustomerService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ramazan on 01.01.14.
 */
public class CustomerDialogPmTest {

    CustomerService customerService = new CustomerService();

    CustomerDialogPm customerDialogPm = new CustomerDialogPm();

    @Before
    public void before(){
        customerDialogPm.customerService = customerService;
    }

    @Test
    public void testSearchResult(){
        Assert.assertNotNull(customerDialogPm.searchPm.getPmBean());
    }

    @Test
    public void testNewCommand(){
        customerDialogPm.newCommand.doIt();

        Assert.assertNotNull(customerDialogPm.details.getPmBean());
    }
}
