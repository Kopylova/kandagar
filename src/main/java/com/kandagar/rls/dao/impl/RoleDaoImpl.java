package com.kandagar.rls.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kandagar.rls.dao.RoleDao;
import com.kandagar.rls.domain.Role;
import com.kandagar.rls.domain.criteria.RoleSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;

@Repository
public class RoleDaoImpl extends BaseHibernateDao implements RoleDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Role> getAll(RoleSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(Role.class);
		if (searchCriteria.getName() != null) {
			criteria.add(Restrictions.eq("name", searchCriteria.getName()));
		}
		return criteria.list();
	}

	@Override
	public long getAllCount(RoleSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(Role.class);
		if (searchCriteria.getName() != null) {
			criteria.add(Restrictions.eq("name", searchCriteria.getName()));
		}
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public CustomPaginatedList getAllPaginated(RoleSearchCriteria searchCriteria) {
		throw new BaseDaoException("Не реализовано!");
	}
	
	@Override
	public Role get(Integer id) {
		return (Role)getSession().get(Role.class, id);
	}
	
	@Override
	public void save(Role entity) throws IllegalArgumentException, BaseDaoException {
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
	public void update(Role entity) throws IllegalArgumentException, BaseDaoException {
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
			Query q = getSession().createQuery("DELETE FROM Role WHERE id = :id");
			q.setString("id", id.toString());
			q.executeUpdate();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
	}

	@Override
	public void remove(Role entity) throws IllegalArgumentException, BaseDaoException {
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
