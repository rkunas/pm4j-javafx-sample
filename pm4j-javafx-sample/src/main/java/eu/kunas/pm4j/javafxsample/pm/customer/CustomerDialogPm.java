package eu.kunas.pm4j.javafxsample.pm.customer;

import eu.kunas.pm4j.javafxsample.dto.business.CustomerDto;
import eu.kunas.pm4j.javafxsample.pm.search.CustomerSearchPm;
import eu.kunas.pm4j.javafxsample.service.CustomerService;
import org.pm4j.core.pm.PmCommand;
import org.pm4j.core.pm.annotation.PmCommandCfg;
import org.pm4j.core.pm.annotation.PmTitleCfg;
import org.pm4j.core.pm.impl.PmCommandImpl;
import org.pm4j.core.pm.impl.PmConversationImpl;


public class CustomerDialogPm extends PmConversationImpl {

    public CustomerService customerService = new CustomerService();

    public final CustomerDetailPm details = new CustomerDetailPm(this);

    public final CustomerSearchPm searchPm = new CustomerSearchPm(this);

    public void init(){
        searchPm.setPmBean(customerService.seach());
    }

    @PmTitleCfg(title = "New")
    public final  PmCommand newCommand = new PmCommandImpl(this){

        @Override
        protected void doItImpl() throws Exception {
            CustomerDto customerDto = new CustomerDto();
            details.setPmBean(customerDto);
        }
    };

    @PmTitleCfg(title = "Save")
    @PmCommandCfg(beforeDo = PmCommandCfg.BEFORE_DO.VALIDATE)
    public  final PmCommand saveCommand = new PmCommandImpl(this){

        @Override
        protected void doItImpl() throws Exception {
            customerService.saveCustomer(details.getPmBean());
            searchPm.setPmBean(customerService.seach());
        }
    };

    @PmTitleCfg(title = "Delete")
    public final PmCommand deleteCommand = new PmCommandImpl(this){

        @Override
        protected void doItImpl() throws Exception {

        }
    };

    public CustomerDialogPm(){

    }
}
