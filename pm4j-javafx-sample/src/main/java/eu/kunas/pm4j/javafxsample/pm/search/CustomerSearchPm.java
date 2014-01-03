package eu.kunas.pm4j.javafxsample.pm.search;

import eu.kunas.pm4j.javafxsample.dto.search.SearchResultDto;
import eu.kunas.pm4j.javafxsample.dto.search.SearchResultItemDto;
import eu.kunas.pm4j.javafxsample.pm.customer.CustomerDialogPm;
import org.pm4j.core.pm.PmObject;
import org.pm4j.core.pm.annotation.PmBeanCfg;
import org.pm4j.core.pm.annotation.PmCommandCfg;
import org.pm4j.core.pm.impl.PmBeanBase;
import org.pm4j.core.pm.impl.PmCommandImpl;

/**
 * Conains all Business handlings for the list.
 * The PM represents the SearchResultDto
 * <p/>
 * Created by ramazan on 24.11.13.
 */
@PmBeanCfg(beanClass = SearchResultDto.class)
public class CustomerSearchPm extends PmBeanBase<SearchResultDto> {

    @PmCommandCfg(beforeDo = PmCommandCfg.BEFORE_DO.DO_NOTHING)
    public final PmCommandImpl viewCommand = new PmCommandImpl(this) {

        @Override
        protected void doItImpl() throws Exception {
            CustomerSearchPm searchpm = (CustomerSearchPm) getPmParent();
            CustomerDialogPm dialogpm = (CustomerDialogPm) searchpm.getPmParent();

            CustomerDialogPm dialogPm = (CustomerDialogPm) getPmParent().getPmParent();

            dialogpm.details.setPmBean(dialogPm.customerService.getCustomer(selected.getKey().getId()));
        }
    };

    @Override
    public SearchResultDto getPmBean() {
        CustomerDialogPm dialogPm = (CustomerDialogPm) getPmParent();
        return dialogPm.customerService.seach();
    }

    public final SearchItemTablePm result = new SearchItemTablePm(this);

    public CustomerSearchPm(PmObject parent) {
        super(parent);

    }


    public SearchResultItemDto selected;
}
