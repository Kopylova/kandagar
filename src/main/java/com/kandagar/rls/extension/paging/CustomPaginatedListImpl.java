package com.kandagar.rls.extension.paging;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;

@SuppressWarnings("rawtypes")
public class CustomPaginatedListImpl implements CustomPaginatedList {

	private int index;

	private int pageSize;

	private int fullListSize;

	private List list;

	private SortOrderEnum sortDirection = SortOrderEnum.DESCENDING;

	private String sortCriterion;

	public CustomPaginatedListImpl(Integer page, String sortCriterion, String sortOrder) {

		sortDirection = CustomPaginatedList.SORT_ASC.equals(sortOrder) ? SortOrderEnum.ASCENDING : SortOrderEnum.DESCENDING;
        
        this.pageSize = 5;
        
        this.sortCriterion = sortCriterion;
      
    	index = page == null ? 0 : page - 1;
	}
	
	public int getFirstRecordIndex() {
		return index * pageSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List results) {
		this.list = results;
	}

	public int getFullListSize() {
		return fullListSize;
	}

	public void setTotalNumberOfRows(int total) {
		this.fullListSize = total;
	}

	public int getTotalPages() {
		return (int) Math.ceil(((double) fullListSize) / pageSize);
	}

	public int getObjectsPerPage() {
		return pageSize;
	}

	public int getPageNumber() {
		return index + 1;
	}

	public String getSearchId() {
		return null;
	}

	public String getSortCriterion() {
		return sortCriterion;
	}

	public SortOrderEnum getSortDirection() {
		return sortDirection;
	}

	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public void setSortDirection(SortOrderEnum sortDirection) {
		this.sortDirection = sortDirection;
	}
}
