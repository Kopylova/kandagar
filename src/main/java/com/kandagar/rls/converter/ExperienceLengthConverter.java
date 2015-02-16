package com.kandagar.rls.converter;

import com.kandagar.rls.domain.ExperienceLength;
import com.kandagar.rls.model.ExperienceLengthModel;;

public class ExperienceLengthConverter extends AbstractModelDaoConverter<ExperienceLengthModel, ExperienceLength>{

    @Override
    public  ExperienceLengthModel convertToModel(ExperienceLength dao) {
    	ExperienceLengthModel model = null;
    	if(dao != null) {
    		model = new ExperienceLengthModel();
    		model.setId(dao.getId());
        	model.setTitle(dao.getName());
    	}
        return model;
    }

    @Override
    public  ExperienceLength convertToDao(ExperienceLengthModel model) {
    	ExperienceLength dao = null;
    	if(model != null){
    		dao = new ExperienceLength();
    		dao.setSiteId(model.getId());
    		dao.setName(model.getTitle());
    	}
        return dao;
    }
    
}
