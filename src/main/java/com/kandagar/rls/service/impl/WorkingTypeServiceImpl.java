package com.kandagar.rls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kandagar.rls.converter.WorkingTypeConverter;
import com.kandagar.rls.dao.WorkingTypeDao;
import com.kandagar.rls.domain.WorkingType;
import com.kandagar.rls.domain.criteria.WorkingTypeSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;
import com.kandagar.rls.model.WorkingTypeModel;
import com.kandagar.rls.service.WorkingTypeService;

@Service
public class WorkingTypeServiceImpl implements WorkingTypeService {

	@Autowired
	private WorkingTypeDao workingTypeDao;
	
	@Override
	@Transactional
	public List<WorkingTypeModel> getAll(WorkingTypeSearchCriteria searchCriteria) {
		WorkingTypeConverter workingTypeConverter = new WorkingTypeConverter();
		return workingTypeConverter.convertToModelList(workingTypeDao.getAll(searchCriteria));
	}

	@Override
	@Transactional
	public long getAllCount(WorkingTypeSearchCriteria searchCriteria) {
		return workingTypeDao.getAllCount(searchCriteria);
	}

	@Override
	@Transactional
	public CustomPaginatedList getAllPaginated(WorkingTypeSearchCriteria searchCriteria) {
		return workingTypeDao.getAllPaginated(searchCriteria);
	}

	@Override
	@Transactional
	public WorkingTypeModel get(Integer id) {
		WorkingTypeConverter workingTypeConverter = new WorkingTypeConverter();
		return workingTypeConverter.convertToModel(workingTypeDao.get(id));
	}
	
	@Override
	@Transactional
	public void save(WorkingTypeModel model) throws IllegalArgumentException, BaseDaoException {
		WorkingTypeConverter workingTypeConverter = new WorkingTypeConverter();
		WorkingType entity = workingTypeConverter.convertToDao(model);
		workingTypeDao.save(entity);	
	}
	
	@Override
	@Transactional
	public void update(WorkingTypeModel model) throws IllegalArgumentException, BaseDaoException {
		WorkingTypeConverter workingTypeConverter = new WorkingTypeConverter();
		WorkingType entity = workingTypeConverter.convertToDao(model);
		workingTypeDao.update(entity);	
	}

	@Override
	@Transactional
	public void remove(Integer id) throws IllegalArgumentException, BaseDaoException {
		workingTypeDao.remove(id);		
	}

	@Override
	@Transactional
	public void remove(WorkingTypeModel model) throws IllegalArgumentException, BaseDaoException {
		WorkingTypeConverter workingTypeConverter = new WorkingTypeConverter();
		WorkingType entity = workingTypeConverter.convertToDao(model);
		workingTypeDao.remove(entity);		
	}
}
