package com.kandagar.rls.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kandagar.rls.dao.ResumeDao;
import com.kandagar.rls.domain.Resume;
import com.kandagar.rls.domain.criteria.ResumeSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;
import com.kandagar.rls.extension.paging.CustomPaginatedListImpl;

@Repository
public class ResumeDaoImpl extends BaseHibernateDao implements ResumeDao {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Resume> getAll(ResumeSearchCriteria searchCriteria) {
		Criteria criteria = initResumeCriteria(searchCriteria);
		return criteria.list();
	}

	@Override
	public long getAllCount(ResumeSearchCriteria searchCriteria) {
		Criteria criteria = initResumeCriteria(searchCriteria);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public CustomPaginatedList getAllPaginated(ResumeSearchCriteria searchCriteria) {
		CustomPaginatedList paginatedList = new CustomPaginatedListImpl(searchCriteria.getPage(),
				searchCriteria.getSortColumn(),
				searchCriteria.getSortOrder());
			paginatedList.setTotalNumberOfRows((int) getAllCount(searchCriteria));
			Criteria criteria = initResumeCriteria(searchCriteria);
			if (StringUtils.isNotEmpty(paginatedList.getSortCriterion())) {
			if (paginatedList.getSortDirection().equals(SortOrderEnum.ASCENDING))
			criteria.addOrder(Order.asc(paginatedList.getSortCriterion()));
			if (paginatedList.getSortDirection().equals(SortOrderEnum.DESCENDING))
			criteria.addOrder(Order.desc(paginatedList.getSortCriterion()));
			} else {
				criteria.addOrder(Order.desc("addDate"));
			}
			criteria.setFirstResult(paginatedList.getFirstRecordIndex());
			criteria.setMaxResults(paginatedList.getPageSize());
			paginatedList.setList(criteria.list());
			return paginatedList;
	}
	
	@Override
	public Resume get(Integer id) {
		return (Resume)getSession().get(Resume.class, id);
	}
	
	@Override
	public Resume getBySiteId(Integer id) {
		Resume resume = null;
		if(id == null) {
			return resume;
		}
		try {
			Query q = getSession().createQuery("FROM Resume WHERE siteId = :id");
			q.setString("id", id.toString());
			resume = (Resume) q.uniqueResult();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
		return resume;
	}
	
	@Override
	public void save(Resume entity) throws IllegalArgumentException, BaseDaoException {
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
	public void saveOrUpdate(Resume entity) throws IllegalArgumentException, BaseDaoException {
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
	public void update(Resume entity) throws IllegalArgumentException, BaseDaoException {
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
			Query q = getSession().createQuery("DELETE FROM Resume WHERE id = :id");
			q.setString("id", id.toString());
			q.executeUpdate();		
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
	}

	@Override
	public void remove(Resume entity) throws IllegalArgumentException, BaseDaoException {
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
	
	private Criteria initResumeCriteria(ResumeSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(Resume.class);
		if (searchCriteria.getRubricaId() != null){
			criteria.createAlias("rubrics", "rubricsAlias");
			criteria.add(Restrictions.eq("rubricsAlias.id", searchCriteria.getRubricaId()));
		}
		if (searchCriteria.getWorkingTypeId() != null) 
			criteria.add(Restrictions.eq("workingType.id", searchCriteria.getWorkingTypeId()));
		if (searchCriteria.getEducationId() != null) 
			criteria.add(Restrictions.eq("education.id", searchCriteria.getEducationId()));
		
		return criteria;
	}
}
