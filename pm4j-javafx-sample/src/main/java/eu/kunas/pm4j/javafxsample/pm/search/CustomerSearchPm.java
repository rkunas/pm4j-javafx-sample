package eu.kunas.pm4j.javafxsample.pm.search;

import eu.kunas.pm4j.javafxsample.dto.business.CustomerDto;
import eu.kunas.pm4j.javafxsample.dto.search.SearchResultDto;
import eu.kunas.pm4j.javafxsample.dto.search.SearchResultItemDto;
import eu.kunas.pm4j.javafxsample.pm.customer.CustomerDialogPm;
import org.pm4j.core.pm.PmObject;
import org.pm4j.core.pm.annotation.PmBeanCfg;
import org.pm4j.core.pm.impl.PmBeanBase;
import org.pm4j.core.pm.impl.PmCommandImpl;

/**
 * Created by ramazan on 24.11.13.
 */
@PmBeanCfg(beanClass = SearchResultDto.class)
public class CustomerSearchPm extends PmBeanBase<SearchResultDto> {

    public final PmCommandImpl viewCommand = new PmCommandImpl(this){

        @Override
        protected void doItImpl() throws Exception {
            CustomerSearchPm searchpm = (CustomerSearchPm)getPmParent();
            CustomerDialogPm dialogpm =  (CustomerDialogPm) searchpm.getPmParent();

            CustomerDto c = new CustomerDto();
            c.setFirstName("Ramazan");
            c.setLastName("Kunas");
            dialogpm.details.setPmBean(c);
        }
    };

    public final SearchItemTablePm result = new SearchItemTablePm(this);

    public CustomerSearchPm(PmObject parent){
        super(parent);

    }


    public SearchResultItemDto selected;
}
