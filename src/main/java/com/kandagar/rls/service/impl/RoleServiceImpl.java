package com.kandagar.rls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kandagar.rls.converter.RoleConverter;
import com.kandagar.rls.dao.RoleDao;
import com.kandagar.rls.model.RoleModel;
import com.kandagar.rls.domain.Role;
import com.kandagar.rls.domain.criteria.RoleSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;
import com.kandagar.rls.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	@Transactional
	public List<RoleModel> getAll(RoleSearchCriteria searchCriteria) {
		RoleConverter roleConverter = new RoleConverter();
		return roleConverter.convertToModelList(roleDao.getAll(searchCriteria));
	}

	@Override
	@Transactional
	public long getAllCount(RoleSearchCriteria searchCriteria) {
		return roleDao.getAllCount(searchCriteria);
	}

	@Override
	@Transactional
	public CustomPaginatedList getAllPaginated(RoleSearchCriteria searchCriteria) {
		return roleDao.getAllPaginated(searchCriteria);
	}

	@Override
	@Transactional
	public RoleModel get(Integer id) {
		RoleConverter roleConverter = new RoleConverter();
		return roleConverter.convertToModel(roleDao.get(id));
	}
	
	@Override
	@Transactional
	public void save(RoleModel model) throws IllegalArgumentException, BaseDaoException {
		RoleConverter roleConverter = new RoleConverter();
		Role entity = roleConverter.convertToDao(model); 
		roleDao.save(entity);
	}
	
	@Override
	@Transactional
	public void update(RoleModel model) throws IllegalArgumentException, BaseDaoException {
		RoleConverter roleConverter = new RoleConverter();
		Role entity = roleConverter.convertToDao(model); 
		roleDao.update(entity);
	}

	@Override
	@Transactional
	public void remove(Integer id) throws IllegalArgumentException, BaseDaoException {
		roleDao.remove(id);
	}

	@Override
	@Transactional
	public void remove(RoleModel model) throws IllegalArgumentException, BaseDaoException {
		RoleConverter roleConverter = new RoleConverter();
		Role entity = roleConverter.convertToDao(model); 
		roleDao.remove(entity);	
	}

	@Override
	@Transactional
	public List<RoleModel> getAll() {
		RoleConverter roleConverter = new RoleConverter();
		return roleConverter.convertToModelList(roleDao.getAll(new RoleSearchCriteria()));
	}
}
