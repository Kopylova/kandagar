package com.kandagar.rls.service;

import java.util.List;

import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;
import com.kandagar.rls.model.BaseModel;

public interface BaseService<T extends BaseModel, S extends BaseSearchCriteria> {

    List<T> getAll(S searchCriteria);

    long getAllCount(S searchCriteria);
    
    CustomPaginatedList getAllPaginated(S searchCriteria);

    T get(Integer id);
    
    void save(T entity) throws IllegalArgumentException, BaseDaoException;
    
    void update(T entity) throws IllegalArgumentException, BaseDaoException;

    void remove(Integer id) throws IllegalArgumentException, BaseDaoException;

    void remove(T entity) throws IllegalArgumentException, BaseDaoException;
}
