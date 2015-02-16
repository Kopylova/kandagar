package com.kandagar.rls.dao;

import com.kandagar.rls.domain.User;
import com.kandagar.rls.domain.criteria.UserSearchCriteria;

public interface UserDao extends BaseDao<User, UserSearchCriteria > {

	boolean isEmailExist(String email);
	
	boolean isLoginExist(String login);
	
	User findUserByName(String username);
	
}
