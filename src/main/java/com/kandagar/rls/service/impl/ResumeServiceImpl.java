package com.kandagar.rls.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kandagar.rls.model.Response;
import com.kandagar.rls.model.ResumeModel;
import com.kandagar.rls.converter.ResumeConverter;
import com.kandagar.rls.dao.ContactDao;
import com.kandagar.rls.dao.CountryDao;
import com.kandagar.rls.dao.EducationDao;
import com.kandagar.rls.dao.ExperienceLengthDao;
import com.kandagar.rls.dao.JobDao;
import com.kandagar.rls.dao.ResumeDao;
import com.kandagar.rls.dao.RubricaDao;
import com.kandagar.rls.dao.WorkingTypeDao;
import com.kandagar.rls.domain.Country;
import com.kandagar.rls.domain.Education;
import com.kandagar.rls.domain.ExperienceLength;
import com.kandagar.rls.domain.Job;
import com.kandagar.rls.domain.Resume;
import com.kandagar.rls.domain.Rubrica;
import com.kandagar.rls.domain.WorkingType;
import com.kandagar.rls.domain.criteria.ResumeSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.extension.paging.CustomPaginatedList;
import com.kandagar.rls.service.ResumeService;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDao resumeDao;
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private EducationDao educationDao;
	
	@Autowired
	private ContactDao contactDao;
	
	@Autowired
	private WorkingTypeDao workingTypeDao;
	
	@Autowired
	private ExperienceLengthDao experienceLengthDao;
	
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private RubricaDao rubricaDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger( ResumeServiceImpl.class );
	
	@Override
	@Transactional
	public List<ResumeModel> getAll(ResumeSearchCriteria searchCriteria) {
		ResumeConverter resumeConverter = new ResumeConverter();
		return resumeConverter.convertToModelList(resumeDao.getAll(searchCriteria));
	}

	@Override
	@Transactional
	public long getAllCount(ResumeSearchCriteria searchCriteria) {
		return resumeDao.getAllCount(searchCriteria);
	}

	@Override
	@Transactional
	public CustomPaginatedList getAllPaginated(
			ResumeSearchCriteria searchCriteria) {
		return resumeDao.getAllPaginated(searchCriteria);
	}

	@Override
	@Transactional
	public ResumeModel get(Integer id) {
		ResumeConverter resumeConverter = new ResumeConverter();
		return resumeConverter.convertToModel(resumeDao.get(id));
	}

	@Override
	@Transactional
	public void save(ResumeModel resumeModel) throws IllegalArgumentException,
			BaseDaoException {
		try{
		Resume resume = prepareResume(resumeModel);
		if(resume.getId() == null || resume.getId() > -1) {
			if(resume.getCountry()!=null){
				countryDao.saveOrUpdate(resume.getCountry());
			}
			if(resume.getContact() != null){
				contactDao.saveOrUpdate(resume.getContact());
			}
			if(resume.getEducation() != null){
				educationDao.saveOrUpdate(resume.getEducation());
			}
			if(resume.getWorkingType() != null){
				workingTypeDao.saveOrUpdate(resume.getWorkingType());
			}
			if(resume.getExperienceLength() != null){
				experienceLengthDao.saveOrUpdate(resume.getExperienceLength());
			}
		    for (Job job : resume.getJobs()) {
		       	if(job != null)
		    	jobDao.saveOrUpdate(job);
			}
		    for (Rubrica rubrica : resume.getRubrics()) {
		       	if(rubrica != null)
		    	rubricaDao.saveOrUpdate(rubrica);
			}
		    if(resume != null) 	resumeDao.saveOrUpdate(resume);  
		}
		} catch(Exception e){
			LOGGER.error(ExceptionUtils.getFullStackTrace(e));
		}
	}

	@Override
	@Transactional
	public void update(ResumeModel entity) throws IllegalArgumentException,
			BaseDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void remove(Integer id) throws IllegalArgumentException,
			BaseDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void remove(ResumeModel entity) throws IllegalArgumentException,
			BaseDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ResumeModel> loadResume(String url) {
		List<ResumeModel> loadResumes = new ArrayList<ResumeModel>();
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
	            HttpGet request = new HttpGet(url);
	            request.addHeader("content-type", "application/json");
	            HttpResponse result = httpClient.execute(request);
	            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
	
	            com.google.gson.Gson gson = new com.google.gson.Gson();
	            Response response = gson.fromJson(json, Response.class);
	            loadResumes.addAll(response.getResumes());
	        } catch (Exception ex) {
	        	
	        }
		return loadResumes;
	}
	
	private Resume prepareResume(ResumeModel resumeModel){
		ResumeConverter resumeConverter = new ResumeConverter(); 
		Resume resume = resumeConverter.convertToDao(resumeModel);
		if(resume != null){
			if(resume.getCountry() != null){
				Country oldCountryEntity = countryDao.getBySiteId(resume.getCountry().getSiteId());
		        if(oldCountryEntity != null){
		        	resume.getCountry().setId(oldCountryEntity.getId());
		        }
			}
	        if(resume.getEducation() != null){
		        Education oldEducationEntity = educationDao.getBySiteId(resume.getEducation().getSiteId());
		        if(oldEducationEntity != null){
		        	resume.getEducation().setId(oldEducationEntity.getId());
		        }
	        }
	        if(resume.getExperienceLength() != null){
		        ExperienceLength oldExperienceLengthEntity = experienceLengthDao.getBySiteId(resume.getExperienceLength().getSiteId());
		        if(oldExperienceLengthEntity != null){
		        	resume.getExperienceLength().setId(oldExperienceLengthEntity.getId());
		        }
	        }
	        if(resume.getWorkingType() != null){
		        WorkingType oldWorkingTypeEntity = workingTypeDao.getBySiteId(resume.getWorkingType().getSiteId());
		        if(oldWorkingTypeEntity != null){
		        	resume.getWorkingType().setId(oldWorkingTypeEntity.getId());
		        }
	        }
	        for (Rubrica rubrica : resume.getRubrics()) {
	        	if(rubrica != null){
	        		Rubrica oldRubricaEntity = rubricaDao.getBySiteId(rubrica.getSiteId());
	        		if(oldRubricaEntity != null){
	        			rubrica.setId(oldRubricaEntity.getId());
	 		        }
	        	}
			}
	        Resume oldResumeEntity = resumeDao.getBySiteId(resume.getSiteId());
	        if(oldResumeEntity != null){
	        	if(oldResumeEntity.getModDate().before(resume.getModDate())){
	        	resume.setId(oldResumeEntity.getId());
	        	} else{
	        		resume.setId(-1);
	        	}
	        }
		}
		return resume;
	}
	
}
