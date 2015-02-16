package com.kandagar.rls.converter;

import com.kandagar.rls.domain.Contact;
import com.kandagar.rls.model.ContactModel;;

public class ContactConverter extends AbstractModelDaoConverter<ContactModel, Contact>{

    @Override
    public  ContactModel convertToModel(Contact dao) {
        ContactModel model = null;
        if(dao != null) {
        	model = new ContactModel();
        	model.setEmail(dao.getEmail());
        	model.setName(dao.getName());
        }
        return model;
    }

    @Override
    public  Contact convertToDao(ContactModel model) {
    	Contact dao = null;
    	if(model != null) {
    		dao = new Contact();
    		dao.setEmail(model.getEmail());
    		dao.setName(model.getName());
    	}
        return dao;
    }
    
}
