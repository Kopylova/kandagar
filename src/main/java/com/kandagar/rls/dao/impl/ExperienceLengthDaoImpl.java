package com.kandagar.rls.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.kandagar.rls.dao.ExperienceLengthDao;
import com.kandagar.rls.domain.ExperienceLength;
import com.kandagar.rls.domain.criteria.BaseSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;

@Repository
public class ExperienceLengthDaoImpl extends BaseHibernateDao implements ExperienceLengthDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ExperienceLength> getAll(BaseSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(ExperienceLength.class);
		return criteria.list();
	}

	@Override
	public long getAllCount(BaseSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(ExperienceLength.class);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public CustomPaginatedList getAllPaginated(BaseSearchCriteria searchCriteria) {
		throw new BaseDaoException("Не реализовано!");
	}
	
	@Override
	public ExperienceLength get(Integer id) {
		return (ExperienceLength)getSession().get(ExperienceLength.class, id);
	}
	
	
	@Override
	public ExperienceLength getBySiteId(Integer id) {
		ExperienceLength experienceLength = null;
		if(id == null) {
			return experienceLength;
		}
		try {
			Query q = getSession().createQuery("FROM ExperienceLength WHERE siteId = :id");
			q.setString("id", id.toString());
			experienceLength = (ExperienceLength) q.uniqueResult();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
		return experienceLength;
	}
	@Override
	public void save(ExperienceLength entity) throws IllegalArgumentException, BaseDaoException {
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
	public void saveOrUpdate(ExperienceLength entity) throws IllegalArgumentException, BaseDaoException {
		if(entity == null) {
			throw new IllegalArgumentException("ExperienceLength не определен!");
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
	public void update(ExperienceLength entity) throws IllegalArgumentException, BaseDaoException {
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
			Query q = getSession().createQuery("DELETE FROM ExperienceLength WHERE id = :id");
			q.setString("id", id.toString());
			q.executeUpdate();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
	}

	@Override
	public void remove(ExperienceLength entity) throws IllegalArgumentException, BaseDaoException {
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
