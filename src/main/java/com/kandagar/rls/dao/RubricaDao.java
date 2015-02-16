package com.kandagar.rls.dao;

import com.kandagar.rls.domain.Rubrica;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;

public interface RubricaDao extends BaseDao<Rubrica, BaseSearchCriteria > {

	void saveOrUpdate(Rubrica entity) throws IllegalArgumentException, BaseDaoException;
	
	Rubrica getBySiteId(Integer id) throws BaseDaoException;
}
