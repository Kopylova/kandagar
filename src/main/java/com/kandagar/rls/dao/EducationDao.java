package com.kandagar.rls.dao;

import com.kandagar.rls.domain.Education;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;

public interface EducationDao extends BaseDao<Education, BaseSearchCriteria > {

	void saveOrUpdate(Education entity) throws IllegalArgumentException, BaseDaoException;
	
	Education getBySiteId(Integer id) throws BaseDaoException;
	
}
