package com.kandagar.rls.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.kandagar.rls.dao.CountryDao;
import com.kandagar.rls.domain.Country;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;

@Repository
public class CountryDaoImpl extends BaseHibernateDao implements CountryDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Country> getAll(BaseSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(Country.class);
		return criteria.list();
	}

	@Override
	public long getAllCount(BaseSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(Country.class);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public CustomPaginatedList getAllPaginated(BaseSearchCriteria searchCriteria) {
		throw new BaseDaoException("Не реализовано!");
	}
	
	@Override
	public Country get(Integer id) {
		return (Country)getSession().get(Country.class, id);
	}
	
	@Override
	public Country getBySiteId(Integer id) {
		Country country = null;
		if(id == null) {
			return country;
		}
		try {
			Query q = getSession().createQuery("FROM Country WHERE siteId = :id");
			q.setString("id", id.toString());
			country = (Country) q.uniqueResult();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
		return country;
	}
	
	@Override
	public void save(Country entity) throws IllegalArgumentException, BaseDaoException {
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
	public void saveOrUpdate(Country entity) throws IllegalArgumentException, BaseDaoException {
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
	public void update(Country entity) throws IllegalArgumentException, BaseDaoException {
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
			Query q = getSession().createQuery("DELETE FROM Country WHERE id = :id");
			q.setString("id", id.toString());
			q.executeUpdate();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
	}

	@Override
	public void remove(Country entity) throws IllegalArgumentException, BaseDaoException {
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
