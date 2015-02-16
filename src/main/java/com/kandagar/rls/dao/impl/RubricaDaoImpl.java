package com.kandagar.rls.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.kandagar.rls.dao.RubricaDao;
import com.kandagar.rls.domain.Rubrica;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;

@Repository
public class RubricaDaoImpl extends BaseHibernateDao implements RubricaDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Rubrica> getAll(BaseSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(Rubrica.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

	@Override
	public long getAllCount(BaseSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(Rubrica.class);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public CustomPaginatedList getAllPaginated(BaseSearchCriteria searchCriteria) {
		throw new BaseDaoException("Не реализовано!");
	}
	
	@Override
	public Rubrica get(Integer id) {
		return (Rubrica)getSession().get(Rubrica.class, id);
	}
	
	@Override
	public Rubrica getBySiteId(Integer id) {
		Rubrica rubrica = null;
		if(id == null) {
			return rubrica;
		}
		try {
			Query q = getSession().createQuery("FROM Rubrica WHERE siteId = :id");
			q.setString("id", id.toString());
			rubrica = (Rubrica) q.uniqueResult();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
		return rubrica;
	}
	
	@Override
	public void save(Rubrica entity) throws IllegalArgumentException, BaseDaoException {
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
	public void saveOrUpdate(Rubrica entity) throws IllegalArgumentException, BaseDaoException {
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
	public void update(Rubrica entity) throws IllegalArgumentException, BaseDaoException {
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
			Query q = getSession().createQuery("DELETE FROM Rubrica WHERE id = :id");
			q.setString("id", id.toString());
			q.executeUpdate();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
	}

	@Override
	public void remove(Rubrica entity) throws IllegalArgumentException, BaseDaoException {
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
