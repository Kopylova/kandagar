package com.kandagar.rls.service;

import java.util.List;

import com.kandagar.rls.domain.criteria.ResumeSearchCriteria;
import com.kandagar.rls.model.ResumeModel;

public interface ResumeService extends BaseService<ResumeModel, ResumeSearchCriteria > {
	
	List<ResumeModel> loadResume(String url);
	
	
}
