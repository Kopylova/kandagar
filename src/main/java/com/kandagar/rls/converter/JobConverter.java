package com.kandagar.rls.converter;

import com.kandagar.rls.domain.Job;
import com.kandagar.rls.model.JobModel;

public class JobConverter extends AbstractModelDaoConverter<JobModel, Job>  {

	 @Override
	    public  JobModel convertToModel(Job dao) {
	        JobModel model = null;
	        if(dao != null){
	        	model = new JobModel();
	        	model.setDescription(dao.getDescription());
	        }
	        return model;
	    }

	    @Override
	    public  Job convertToDao(JobModel model) {
	    	Job dao = null;
	    	if(model != null) {
	    		dao = new Job();
	    		dao.setDescription(model.getDescription());
	    	}
	        return dao;
	    }
	    
}
