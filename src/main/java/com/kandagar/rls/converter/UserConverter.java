package com.kandagar.rls.converter;

import com.kandagar.rls.domain.User;
import com.kandagar.rls.model.UserModel;

public class UserConverter extends AbstractModelDaoConverter<UserModel, User> {

    @Override
    public  UserModel convertToModel(User dao) {
        UserModel model = null;
        if(dao != null){
        	model = new UserModel();
	        model.setId(dao.getId());
	        model.setAdditionalInformation(dao.getAdditionalInformation());
	        model.setEmail(dao.getEmail());
	        model.setIsActive(dao.getIsActive());
	        model.setLogin(dao.getLogin());
	        model.setName(dao.getName());
	        model.setPassword(dao.getPassword());
	        model.setOldPassword(dao.getPassword());
	        RoleConverter roleConverter = new RoleConverter();
	        model.setRole(roleConverter.convertToModel(dao.getRole()));
        }
        return model;
    }

    @Override
    public  User convertToDao(UserModel model) {
    	User dao = null;
    	if(model != null) {
    		dao = new User();
	        dao.setId(model.getId());
	        dao.setAdditionalInformation(model.getAdditionalInformation());
	        dao.setEmail(model.getEmail());
	        dao.setIsActive(model.getIsActive());
	        dao.setLogin(model.getLogin());
	        dao.setName(model.getName());
	        dao.setPassword(model.getPassword());
	        RoleConverter roleConverter = new RoleConverter();
	        dao.setRole(roleConverter.convertToDao((model.getRole())));
    	}
        return dao;
    }


}
