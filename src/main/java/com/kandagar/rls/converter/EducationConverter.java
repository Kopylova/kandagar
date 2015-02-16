package com.kandagar.rls.converter;

import com.kandagar.rls.domain.Education;
import com.kandagar.rls.model.EducationModel;;

public class EducationConverter extends AbstractModelDaoConverter<EducationModel, Education>{

    @Override
    public  EducationModel convertToModel(Education dao) {
        EducationModel model = null;
        if(dao != null){
        	model = new EducationModel();
        	model.setId(dao.getId());
        	model.setTitle(dao.getName());
        }
        return model;
    }

    @Override
    public  Education convertToDao(EducationModel model) {
    	Education dao = null;
    	if(model != null){
    		dao = new Education();
    		dao.setSiteId(model.getId());
    		dao.setName(model.getTitle());
    	}
        return dao;
    }
    
}
