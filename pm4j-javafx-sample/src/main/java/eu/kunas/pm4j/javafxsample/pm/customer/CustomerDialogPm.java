package eu.kunas.pm4j.javafxsample.pm.customer;

import eu.kunas.pm4j.javafxsample.dto.business.CustomerDto;
import eu.kunas.pm4j.javafxsample.pm.search.CustomerSearchPm;
import eu.kunas.pm4j.javafxsample.service.CustomerService;
import org.pm4j.core.pm.PmCommand;
import org.pm4j.core.pm.annotation.PmCommandCfg;
import org.pm4j.core.pm.annotation.PmTitleCfg;
import org.pm4j.core.pm.impl.PmCommandImpl;
import org.pm4j.core.pm.impl.PmConversationImpl;

/**
 * Main Dialog PM of the Customer Dialog
 *
 * Created by ramazan on 09.12.13.
 */
public class CustomerDialogPm extends PmConversationImpl {

    public CustomerService customerService = new CustomerService();

    public final CustomerDetailPm details = new CustomerDetailPm(this);

    public final CustomerSearchPm searchPm = new CustomerSearchPm(this);

    @PmTitleCfg(title = "New")
    public final PmCommand newCommand = new PmCommandImpl(this) {

        @Override
        protected void doItImpl() throws Exception {
            CustomerDto customerDto = new CustomerDto();
            details.setPmBean(customerDto);
        }
    };

    @PmTitleCfg(title = "Save")
    @PmCommandCfg(beforeDo = PmCommandCfg.BEFORE_DO.VALIDATE)
    public final PmCommand saveCommand = new PmCommandImpl(this) {

        @Override
        protected void doItImpl() throws Exception {
            customerService.saveCustomer(details.getPmBean());
            searchPm.setPmBean(customerService.seach());
        }

        @Override
        protected boolean isPmEnabledImpl() {
            return details.getPmBean() != null ? true : false;
        }
    };

    @PmTitleCfg(title = "Delete")
    public final PmCommand deleteCommand = new PmCommandImpl(this) {

        @Override
        protected void doItImpl() throws Exception {
            customerService.deleteCustomer(details.getPmBean());
        }

        @Override
        protected boolean isPmEnabledImpl() {
            return details.getPmBean() != null ? true : false;
        }

    };

    public CustomerDialogPm() {

    }
}
