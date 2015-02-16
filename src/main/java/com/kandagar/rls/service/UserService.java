package com.kandagar.rls.service;

import com.kandagar.rls.domain.criteria.UserSearchCriteria;
import com.kandagar.rls.model.UserModel;

public interface UserService extends BaseService<UserModel, UserSearchCriteria > {

	boolean isEmailExist(String email);
	
	boolean isLoginExist(String login);
	
	UserModel findUserByName(String username);
	
}
