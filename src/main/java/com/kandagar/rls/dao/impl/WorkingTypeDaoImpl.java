package com.kandagar.rls.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.kandagar.rls.dao.WorkingTypeDao;
import com.kandagar.rls.domain.WorkingType;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;

@Repository
public class WorkingTypeDaoImpl extends BaseHibernateDao implements WorkingTypeDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<WorkingType> getAll(BaseSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(WorkingType.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

	@Override
	public long getAllCount(BaseSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(WorkingType.class);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public CustomPaginatedList getAllPaginated(BaseSearchCriteria searchCriteria) {
		throw new BaseDaoException("Не реализовано!");
	}
	
	@Override
	public WorkingType get(Integer id) {
		return (WorkingType)getSession().get(WorkingType.class, id);
	}
	
	@Override
	public WorkingType getBySiteId(Integer id) {
		WorkingType workingType = null;
		if(id == null) {
			return workingType;
		}
		try {
			Query q = getSession().createQuery("FROM WorkingType WHERE siteId = :id");
			q.setString("id", id.toString());
			workingType = (WorkingType) q.uniqueResult();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
		return workingType;
	}
	
	@Override
	public void save(WorkingType entity) throws IllegalArgumentException, BaseDaoException {
		if(entity == null) {
			throw new IllegalArgumentException("Не определен!");
		}
		try {
			getSession().save(entity);
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}	
	}
	
	@Override
	public void saveOrUpdate(WorkingType entity) throws IllegalArgumentException, BaseDaoException {
		if(entity == null) {
			throw new IllegalArgumentException("Не определен!");
		}
		try {
			if(entity.getId() != null){
				getSession().merge(entity);
			}else {
				getSession().save(entity);
			}
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}	
	}
	
	@Override
	public void update(WorkingType entity) throws IllegalArgumentException, BaseDaoException {
		if(entity == null) {
			throw new IllegalArgumentException("Не определен!");
		}
		try {
			getSession().update(entity);	
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}		
	}

	@Override
	public void remove(Integer id) throws IllegalArgumentException, BaseDaoException {
		if(id == null) {
			throw new IllegalArgumentException("Первичный ключ не определен!");
		}
		try {
			Query q = getSession().createQuery("DELETE FROM WorkingType WHERE id = :id");
			q.setString("id", id.toString());
			q.executeUpdate();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
	}

	@Override
	public void remove(WorkingType entity) throws IllegalArgumentException, BaseDaoException {
		if(entity == null) {
			throw new IllegalArgumentException("Не определен!");
		}
		try {
			getSession().delete(entity);
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}		
	}
}
