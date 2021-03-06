package eu.kunas.pm4j.javafxsample.service;

import eu.kunas.pm4j.javafxsample.dto.business.CustomerDto;
import eu.kunas.pm4j.javafxsample.dto.search.BusinessKey;
import eu.kunas.pm4j.javafxsample.dto.search.SearchResultDto;
import eu.kunas.pm4j.javafxsample.dto.search.SearchResultItemDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This Service could be youre Service.
 * EJB or Spring Injected Service.
 * <p/>
 * Created by ramazan
 */
public class CustomerService {

    Map<Long, CustomerDto> db = new HashMap<Long, CustomerDto>();

    Long counter = 1L;

    public CustomerService() {

        CustomerDto c1 = new CustomerDto();
        c1.setId(counter++);
        c1.setFirstName("Martin");
        c1.setLastName("Fowler");

        CustomerDto c2 = new CustomerDto();
        c2.setId(counter++);
        c2.setFirstName("Olaf");
        c2.setLastName("Boede");

        CustomerDto c3 = new CustomerDto();
        c3.setId(counter++);
        c3.setFirstName("Ramazan");
        c3.setLastName("Kunas");
        c3.setMobile("0157800000");

        db.put(c1.getId(), c1);
        db.put(c2.getId(), c2);
        db.put(c3.getId(), c3);
    }

    public SearchResultDto seach() {
        SearchResultDto resultDto = new SearchResultDto();
        resultDto.getLabels().add("Name");

        for (CustomerDto customer : db.values()) {
            SearchResultItemDto item = new SearchResultItemDto();

            item.setKey(new BusinessKey(customer.getId()));
            item.getDataset().add(customer.getFirstName());
            resultDto.getResultSet().add(item);
        }

        return resultDto;
    }

    public CustomerDto getCustomer(Long id) {
        return db.get(id);
    }

    public void saveCustomer(CustomerDto dto) {
        if (dto.getId() == null) {
            dto.setId(counter++);
            System.out.println("Counter" + counter);
        }
        db.remove(dto.getId());
        db.put(dto.getId(), dto);
    }

    public void deleteCustomer(CustomerDto dto) {
        db.remove(dto.getId());
    }

    public List<CustomerDto> getAll() {
        return (List<CustomerDto>) db.values();
    }

}
