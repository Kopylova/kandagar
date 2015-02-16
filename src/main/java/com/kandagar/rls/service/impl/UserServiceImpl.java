package com.kandagar.rls.service.impl;

import java.util.List;

import com.google.common.base.Strings;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kandagar.rls.converter.UserConverter;
import com.kandagar.rls.dao.UserDao;
import com.kandagar.rls.model.UserModel;
import com.kandagar.rls.domain.User;
import com.kandagar.rls.domain.criteria.UserSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;
import com.kandagar.rls.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public List<UserModel> getAll(UserSearchCriteria searchCriteria) {
		UserConverter userConverter = new UserConverter();
		return userConverter.convertToModelList(userDao.getAll(searchCriteria));
	}

	@Override
	@Transactional
	public long getAllCount(UserSearchCriteria searchCriteria) {
		return userDao.getAllCount(searchCriteria);
	}

	@Override
	@Transactional
	public CustomPaginatedList getAllPaginated(UserSearchCriteria searchCriteria) {
		return userDao.getAllPaginated(searchCriteria);
	}

	@Override
	@Transactional
	public UserModel get(Integer id) {
		UserConverter userConverter = new UserConverter();
		return userConverter.convertToModel(userDao.get(id));
	}
	
	@Override
	@Transactional
	public void save(UserModel model) throws IllegalArgumentException, BaseDaoException {
		UserConverter userConverter = new UserConverter();
		User entity = userConverter.convertToDao(model);
		entity.setPassword(DigestUtils.md5Hex(model.getPassword()));
		userDao.save(entity);
		
	}

	@Override
	@Transactional
	public void update(UserModel model) throws IllegalArgumentException, BaseDaoException {
		if(Strings.isNullOrEmpty(model.getPassword())){
			model.setPassword(model.getOldPassword());
		} else {
			model.setPassword(DigestUtils.md5Hex(model.getPassword()));
		}
		UserConverter userConverter = new UserConverter();
		User entity = userConverter.convertToDao(model);
		userDao.update(entity);
		
	}
	
	@Override
	@Transactional
	public void remove(Integer id) throws IllegalArgumentException, BaseDaoException {
		userDao.remove(id);
		
	}

	@Override
	@Transactional
	public void remove(UserModel model) throws IllegalArgumentException, BaseDaoException {
		UserConverter userConverter = new UserConverter();
		User entity = userConverter.convertToDao(model);
		userDao.remove(entity);
	}

	@Override
	@Transactional
	public boolean isEmailExist(String email) {
		return userDao.isEmailExist(email);
	}

	@Override
	@Transactional
	public boolean isLoginExist(String login) {
		return userDao.isLoginExist(login);
	}
	
	@Override
	@Transactional
	public UserModel findUserByName(String login) {
		UserConverter userConverter = new UserConverter();
		return userConverter.convertToModel(userDao.findUserByName(login));
	}
}
