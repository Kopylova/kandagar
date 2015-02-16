package com.kandagar.rls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kandagar.rls.converter.RubricaConverter;
import com.kandagar.rls.dao.RubricaDao;
import com.kandagar.rls.domain.Rubrica;
import com.kandagar.rls.domain.criteria.RubricaSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;
import com.kandagar.rls.model.RubricaModel;
import com.kandagar.rls.service.RubricaService;

@Service
public class RubricaServiceImpl implements RubricaService {

	@Autowired
	private RubricaDao rubricaDao;
	
	@Override
	@Transactional
	public List<RubricaModel> getAll(RubricaSearchCriteria searchCriteria) {
		RubricaConverter rubricaConverter = new RubricaConverter();
		return rubricaConverter.convertToModelList(rubricaDao.getAll(searchCriteria));
	}

	@Override
	@Transactional
	public long getAllCount(RubricaSearchCriteria searchCriteria) {
		return rubricaDao.getAllCount(searchCriteria);
	}

	@Override
	@Transactional
	public CustomPaginatedList getAllPaginated(RubricaSearchCriteria searchCriteria) {
		return rubricaDao.getAllPaginated(searchCriteria);
	}

	@Override
	@Transactional
	public RubricaModel get(Integer id) {
		RubricaConverter rubricaConverter = new RubricaConverter();
		return rubricaConverter.convertToModel(rubricaDao.get(id));
	}
	
	@Override
	@Transactional
	public void save(RubricaModel model) throws IllegalArgumentException, BaseDaoException {
		RubricaConverter rubricaConverter = new RubricaConverter();
		Rubrica entity = rubricaConverter.convertToDao(model);
		rubricaDao.save(entity);	
	}
	
	@Override
	@Transactional
	public void update(RubricaModel model) throws IllegalArgumentException, BaseDaoException {
		RubricaConverter rubricaConverter = new RubricaConverter();
		Rubrica entity = rubricaConverter.convertToDao(model);
		rubricaDao.update(entity);	
	}

	@Override
	@Transactional
	public void remove(Integer id) throws IllegalArgumentException, BaseDaoException {
		rubricaDao.remove(id);		
	}

	@Override
	@Transactional
	public void remove(RubricaModel model) throws IllegalArgumentException, BaseDaoException {
		RubricaConverter rubricaConverter = new RubricaConverter();
		Rubrica entity = rubricaConverter.convertToDao(model);
		rubricaDao.remove(entity);		
	}
}
