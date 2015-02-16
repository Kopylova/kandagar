package com.kandagar.rls.dao;

import com.kandagar.rls.domain.WorkingType;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;

public interface WorkingTypeDao extends BaseDao<WorkingType, BaseSearchCriteria > {

	void saveOrUpdate(WorkingType entity) throws IllegalArgumentException, BaseDaoException;
	
	WorkingType getBySiteId(Integer id) throws BaseDaoException;
}
