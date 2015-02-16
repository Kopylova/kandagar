package com.kandagar.rls.dao;

import com.kandagar.rls.domain.Resume;
import com.kandagar.rls.domain.criteria.ResumeSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;

public interface ResumeDao extends BaseDao<Resume, ResumeSearchCriteria > {
	
	void saveOrUpdate(Resume entity) throws IllegalArgumentException, BaseDaoException;
	
	Resume getBySiteId(Integer id) throws BaseDaoException;
}
