package eu.kunas.pm4j.javafxsample.pm.search;

import eu.kunas.pm4j.javafxsample.dto.search.SearchItemDto;
import org.pm4j.core.pm.PmAttrString;
import org.pm4j.core.pm.annotation.PmAttrCfg;
import org.pm4j.core.pm.annotation.PmBeanCfg;
import org.pm4j.core.pm.impl.PmAttrStringImpl;
import org.pm4j.core.pm.impl.PmTableRowImpl;

@PmBeanCfg(beanClass = SearchItemDto.class)
public class SearchItemTableRowPm extends PmTableRowImpl<SearchItemDto> {

	@PmAttrCfg(readOnly = true)
	public PmAttrString title = new PmAttrStringImpl(this);

	@PmAttrCfg(readOnly = true)
	public PmAttrString field = new PmAttrStringImpl(this);

	public PmAttrString value = new PmAttrStringImpl(this);

	public SearchItemTableRowPm() {
	}

}
