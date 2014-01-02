package eu.kunas.pm4j.javafxsample.pm.search;

import eu.kunas.pm4j.javafxsample.dto.search.SearchDto;
import org.pm4j.core.pm.PmObject;
import org.pm4j.core.pm.annotation.PmBeanCfg;
import org.pm4j.core.pm.impl.PmBeanImpl;

@PmBeanCfg(beanClass = SearchDto.class)
public class SearchPm extends PmBeanImpl<SearchDto> {

	public SearchPm(final PmObject arg0) {
		super(arg0);
	}

	public SearchItemTablePm items = new SearchItemTablePm(this);

}
