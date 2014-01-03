package eu.kunas.pm4j.javafxsample.pm.search;

import eu.kunas.pm4j.javafxsample.dto.search.SearchItemDto;
import org.pm4j.core.pm.PmObject;
import org.pm4j.core.pm.annotation.PmFactoryCfg;
import org.pm4j.core.pm.impl.PmTableColImpl2;
import org.pm4j.core.pm.impl.PmTableImpl2;

/**
 * The Table reprents the results in the table.
 *
 */
@PmFactoryCfg(beanPmClasses = SearchItemTableRowPm.class)
public class SearchItemTablePm extends PmTableImpl2<SearchItemTableRowPm, SearchItemDto> {

	public SearchItemTablePm(final PmObject pmParent) {
		super(pmParent);
	}

	public PmTableColImpl2 field = new PmTableColImpl2(this);
}
