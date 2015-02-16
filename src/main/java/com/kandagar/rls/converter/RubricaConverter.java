package com.kandagar.rls.converter;

import com.kandagar.rls.domain.Rubrica;
import com.kandagar.rls.model.RubricaModel;

public class RubricaConverter extends AbstractModelDaoConverter<RubricaModel, Rubrica>  {

	 @Override
	    public  RubricaModel convertToModel(Rubrica dao) {
	        RubricaModel model = null;
	        if(dao != null){
	        	model = new RubricaModel();
	        	model.setId(dao.getId());
	        	model.setTitle(dao.getName());
	        }
	        return model;
	    }

	    @Override
	    public  Rubrica convertToDao(RubricaModel model) {
	    	Rubrica dao = null;
	    	if(model != null) {
	    		dao = new Rubrica();
	    		dao.setSiteId(model.getId());
	    		dao.setName(model.getTitle());
	    	}
	        return dao;
	    }
	    
}
