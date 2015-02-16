package com.kandagar.rls.converter;

import com.kandagar.rls.domain.Country;
import com.kandagar.rls.model.CountryModel;;

public class CountryConverter extends AbstractModelDaoConverter<CountryModel, Country>{

    @Override
    public  CountryModel convertToModel(Country dao) {
        CountryModel model = null;
        if(dao != null) {
        	model = new CountryModel();
        	model.setId(dao.getId());
        	model.setTitle(dao.getName());
        }
        return model;
    }

    @Override
    public  Country convertToDao(CountryModel model) {
    	Country dao = null;
    	if(model != null) {
    		dao = new Country();
    		dao.setSiteId(model.getId());
    		dao.setName(model.getTitle());
    	}
        return dao;
    }
    
}
