package com.kandagar.rls.dao;

import com.kandagar.rls.domain.Country;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;

public interface CountryDao extends BaseDao<Country, BaseSearchCriteria > {

	void saveOrUpdate(Country entity) throws IllegalArgumentException, BaseDaoException;
	
	Country getBySiteId(Integer id) throws BaseDaoException;
	
}
