package com.kandagar.rls.converter;

import com.kandagar.rls.domain.Role;
import com.kandagar.rls.model.RoleModel;

public class RoleConverter extends AbstractModelDaoConverter<RoleModel, Role> {

    @Override
    public  RoleModel convertToModel(Role dao) {
        RoleModel model = null;
        if(dao != null){
        	model = new RoleModel();
        	model.setId(dao.getId());
        	model.setName(dao.getName());
        }
        return model;
    }

    @Override
    public  Role convertToDao(RoleModel model) {
    	Role dao = null;
    	if(model != null){
    		dao = new Role();
    		dao.setId(model.getId());
        	dao.setName(model.getName());
    	}
        return dao;
    }

}
