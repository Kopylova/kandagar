package com.kandagar.rls.extension.paging;

import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

public interface CustomPaginatedList extends PaginatedList {
	 
    String SORT_ASC = "asc";
    
    String SORT_DESC = "desc";
 
    @SuppressWarnings("rawtypes")
	void setList(List resultList);
 
    void setTotalNumberOfRows(int total);
 
    void setPageSize(int pageSize);
 
    void setIndex(int index);
 
    int getFirstRecordIndex();
 
    int getPageSize();
 
    void setSortDirection(SortOrderEnum sortOrderEnum);
 
    void setSortCriterion(String sortCriterion);
 
}
