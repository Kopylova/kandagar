package com.kandagar.rls.converter;

import com.kandagar.rls.domain.WorkingType;
import com.kandagar.rls.model.WorkingTypeModel;;

public class WorkingTypeConverter extends AbstractModelDaoConverter<WorkingTypeModel, WorkingType>{

    @Override
    public  WorkingTypeModel convertToModel(WorkingType dao) {
    	WorkingTypeModel model = null;
    	if(dao != null) {
    		model = new WorkingTypeModel();
    		model.setId(dao.getId());
    		model.setTitle(dao.getName());
    	}
        return model;
    }

    @Override
    public  WorkingType convertToDao(WorkingTypeModel model) {
    	WorkingType dao = null;
    	if(model != null){
    		dao = new WorkingType();
    		dao.setSiteId(model.getId());
    		dao.setName(model.getTitle());
    	}
        return dao;
    }
    
}
