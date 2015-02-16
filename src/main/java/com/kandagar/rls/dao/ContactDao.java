package com.kandagar.rls.dao;

import com.kandagar.rls.domain.Contact;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;

public interface ContactDao extends BaseDao<Contact, BaseSearchCriteria > {

	void saveOrUpdate(Contact entity) throws IllegalArgumentException, BaseDaoException;
	
}
