package com.kandagar.rls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kandagar.rls.converter.EducationConverter;
import com.kandagar.rls.dao.EducationDao;
import com.kandagar.rls.domain.Education;
import com.kandagar.rls.domain.criteria.EducationSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;
import com.kandagar.rls.model.EducationModel;
import com.kandagar.rls.service.EducationService;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationDao educationDao;
	
	@Override
	@Transactional
	public List<EducationModel> getAll(EducationSearchCriteria searchCriteria) {
		EducationConverter educationConverter = new EducationConverter();
		return educationConverter.convertToModelList(educationDao.getAll(searchCriteria));
	}

	@Override
	@Transactional
	public long getAllCount(EducationSearchCriteria searchCriteria) {
		return educationDao.getAllCount(searchCriteria);
	}

	@Override
	@Transactional
	public CustomPaginatedList getAllPaginated(EducationSearchCriteria searchCriteria) {
		return educationDao.getAllPaginated(searchCriteria);
	}

	@Override
	@Transactional
	public EducationModel get(Integer id) {
		EducationConverter educationConverter = new EducationConverter();
		return educationConverter.convertToModel(educationDao.get(id));
	}
	
	@Override
	@Transactional
	public void save(EducationModel model) throws IllegalArgumentException, BaseDaoException {
		EducationConverter educationConverter = new EducationConverter();
		Education entity = educationConverter.convertToDao(model);
		educationDao.save(entity);	
	}
	
	@Override
	@Transactional
	public void update(EducationModel model) throws IllegalArgumentException, BaseDaoException {
		EducationConverter educationConverter = new EducationConverter();
		Education entity = educationConverter.convertToDao(model);
		educationDao.update(entity);	
	}

	@Override
	@Transactional
	public void remove(Integer id) throws IllegalArgumentException, BaseDaoException {
		educationDao.remove(id);		
	}

	@Override
	@Transactional
	public void remove(EducationModel model) throws IllegalArgumentException, BaseDaoException {
		EducationConverter educationConverter = new EducationConverter();
		Education entity = educationConverter.convertToDao(model);
		educationDao.remove(entity);		
	}
}
