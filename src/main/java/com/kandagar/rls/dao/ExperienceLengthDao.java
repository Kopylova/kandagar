package com.kandagar.rls.dao;

import com.kandagar.rls.domain.ExperienceLength;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;

public interface ExperienceLengthDao extends BaseDao<ExperienceLength, BaseSearchCriteria > {

	void saveOrUpdate(ExperienceLength entity) throws IllegalArgumentException, BaseDaoException;
	
	ExperienceLength getBySiteId(Integer id) throws BaseDaoException;
	
}
