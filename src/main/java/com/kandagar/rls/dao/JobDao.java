package com.kandagar.rls.dao;

import com.kandagar.rls.domain.Job;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;

public interface JobDao extends BaseDao<Job, BaseSearchCriteria > {

	void saveOrUpdate(Job entity) throws IllegalArgumentException, BaseDaoException;
	
}
