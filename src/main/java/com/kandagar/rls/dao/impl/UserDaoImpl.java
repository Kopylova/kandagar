package com.kandagar.rls.dao.impl;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kandagar.rls.dao.UserDao;
import com.kandagar.rls.domain.User;
import com.kandagar.rls.domain.criteria.UserSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;
import com.kandagar.rls.extension.paging.CustomPaginatedListImpl;

@Repository
public class UserDaoImpl extends BaseHibernateDao implements UserDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAll(UserSearchCriteria searchCriteria) {
		Criteria criteria = initUserCriteria(searchCriteria);
		return criteria.list();
	}

	@Override
	public long getAllCount(UserSearchCriteria searchCriteria) {
		Criteria criteria = initUserCriteria(searchCriteria);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public CustomPaginatedList getAllPaginated(UserSearchCriteria searchCriteria) {
		CustomPaginatedList paginatedList = new CustomPaginatedListImpl(searchCriteria.getPage(),
																		searchCriteria.getSortColumn(),
																		searchCriteria.getSortOrder());
		paginatedList.setTotalNumberOfRows((int) getAllCount(searchCriteria));
		Criteria criteria = initUserCriteria(searchCriteria);
		if (paginatedList.getSortCriterion() != null) {
			if (paginatedList.getSortDirection().equals(SortOrderEnum.ASCENDING))
				criteria.addOrder(Order.asc(paginatedList.getSortCriterion()));
			if (paginatedList.getSortDirection().equals(SortOrderEnum.DESCENDING))
				criteria.addOrder(Order.desc(paginatedList.getSortCriterion()));
		}
		criteria.setFirstResult(paginatedList.getFirstRecordIndex());
		criteria.setMaxResults(paginatedList.getPageSize());
		paginatedList.setList(criteria.list());
		return paginatedList;
	}

	@Override
	public User get(Integer id) {
		return (User)getSession().get(User.class, id);
	}
	
	@Override
	public void save(User entity) throws IllegalArgumentException, BaseDaoException {
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
	public void update(User entity) throws IllegalArgumentException, BaseDaoException {
		if(entity == null) {
			throw new IllegalArgumentException("Не определен!");
		}
		try {
			getSession().flush();
			getSession().update(entity);	
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}		
	}

	@Override
	public void remove(Integer id) throws IllegalArgumentException, BaseDaoException {
		if(id == null) {
			throw new IllegalArgumentException("Первычный ключ не определен!");
		}
		try {
			Query q = getSession().createQuery("DELETE FROM User WHERE id = :id");
			q.setString("id", id.toString());
			q.executeUpdate();			
		}
		catch(Exception e) {
			throw new BaseDaoException(e);
		}
	}

	@Override
	public void remove(User entity) throws IllegalArgumentException, BaseDaoException {
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
	
	private Criteria initUserCriteria(UserSearchCriteria searchCriteria) {
		Criteria criteria = getSession().createCriteria(User.class);
		if (searchCriteria.getFirstName() != null)
			criteria.add(Restrictions.like("name", searchCriteria.getFirstName(), MatchMode.ANYWHERE));
		if (searchCriteria.getLastName() != null)
			criteria.add(Restrictions.like("login", searchCriteria.getLastName(), MatchMode.ANYWHERE));
		if (searchCriteria.getEmail() != null)
			criteria.add(Restrictions.like("email", searchCriteria.getEmail(), MatchMode.ANYWHERE));
		if (searchCriteria.getRoleId() != null)
			criteria.add(Restrictions.eq("role.id", searchCriteria.getRoleId()));
		return criteria;
	}

	@Override
	public boolean isEmailExist(String email) {
		Query q = getSession().createQuery("SELECT id FROM User WHERE email = :email");
		q.setString("email", email);
		return (q.uniqueResult() != null);
	}

	@Override
	public boolean isLoginExist(String login) {
		Query q = getSession().createQuery("SELECT id FROM User WHERE login = :login");
		q.setString("login", login);
		return (q.uniqueResult() != null);
	}
	
	@Override
	public User findUserByName(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("login", username));		
		return (User) criteria.uniqueResult();
	}
}
