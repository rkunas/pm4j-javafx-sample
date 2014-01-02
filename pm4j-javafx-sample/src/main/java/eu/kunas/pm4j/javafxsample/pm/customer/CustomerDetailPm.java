package eu.kunas.pm4j.javafxsample.pm.customer;

import eu.kunas.pm4j.javafxsample.dto.business.CustomerDto;
import org.pm4j.core.pm.PmAttrString;
import org.pm4j.core.pm.PmObject;
import org.pm4j.core.pm.annotation.PmAttrCfg;
import org.pm4j.core.pm.annotation.PmBeanCfg;
import org.pm4j.core.pm.annotation.PmTitleCfg;
import org.pm4j.core.pm.impl.PmAttrStringImpl;
import org.pm4j.core.pm.impl.PmBeanImpl;

/**
 * Created by ramazan on 09.12.13.
 */

@PmBeanCfg(beanClass = CustomerDto.class)
public class CustomerDetailPm extends PmBeanImpl<CustomerDto> {

    @PmAttrCfg(required = true)
    @PmTitleCfg(title = "Firstname")
    public final PmAttrString firstName = new PmAttrStringImpl(this);

    @PmAttrCfg(required = true)
    @PmTitleCfg(title = "Lastname")
    public final PmAttrString lastName = new PmAttrStringImpl(this);

    public CustomerDetailPm(PmObject parent){
        super(parent);
    }
}
