package com.kandagar.rls.converter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kandagar.rls.domain.Job;
import com.kandagar.rls.domain.Resume;
import com.kandagar.rls.domain.Rubrica;
import com.kandagar.rls.extension.AppConstants;
import com.kandagar.rls.extension.Utils;
import com.kandagar.rls.model.PhotoModel;
import com.kandagar.rls.model.ResumeModel;

public class ResumeConverter extends AbstractModelDaoConverter<ResumeModel, Resume>{

    @Override
    public  ResumeModel convertToModel(Resume dao) {
        ResumeModel model = null;
        if(dao != null) {
        	model = new ResumeModel();
	        model.setId(dao.getId());
	        if(dao.getAddDate()!=null)
	        model.setAddDate(dao.getAddDate().toString());
	        model.setAge(dao.getAge());
	        if(dao.getBirthday()!=null)
	        model.setBirthday(dao.getBirthday().toString());
	        model.setEducation_description(dao.getEducationDescription());
	        model.setExperience(dao.getExperience());
	        model.setHasChild(dao.isHasChild());
	        model.setHeader(dao.getHeader());
	        model.setInfo(dao.getInfo());
	        if(dao.getModDate()!=null)
	        model.setModDate(dao.getModDate().toString());
	        model.setPersonalQualities(dao.getPersonalQualities());
	        model.setSalary(dao.getSalary());
	        model.setSex(dao.getSex());
	        model.setSkills(dao.getSkills());
	        model.setUrl(dao.getUrl());
	        CountryConverter countryConverter = new CountryConverter();
	        model.setCitizenship(countryConverter.convertToModel(dao.getCountry()));
	        EducationConverter educationConverter = new EducationConverter();
	        model.setEducation(educationConverter.convertToModel(dao.getEducation()));
	        ContactConverter contactConverter = new ContactConverter();
	        model.setContact(contactConverter.convertToModel(dao.getContact()));
	        WorkingTypeConverter workingTypeConverter = new WorkingTypeConverter();
	        model.setWorkingType(workingTypeConverter.convertToModel(dao.getWorkingType()));
	        ExperienceLengthConverter experienceLengthConverter = new ExperienceLengthConverter();
	        model.setExperienceLength(experienceLengthConverter.convertToModel(dao.getExperienceLength()));
	        JobConverter jobConverter = new JobConverter();
	        model.setJobs(jobConverter.convertToModelList((List<Job>) dao.getJobs()));
	        RubricaConverter rubricaConverter = new RubricaConverter();
	        model.setRubrics(rubricaConverter.convertToModelList((List<Rubrica>) dao.getRubrics()));
	        PhotoModel photoModel = new PhotoModel();
	        photoModel.setUrl(dao.getPhotoUrl());
        }
        return model;
    }

    @Override
    public  Resume convertToDao(ResumeModel model) {
    	Resume dao = null;
    	if(model!=null){
    		dao = new Resume();
	    	dao.setSiteId(model.getId());
	    	dao.setAddDate(Utils.convertStringToDate(model.getAddDate(), AppConstants.DATE_FORMAT_YYYYMMDD_MMSSH));
	        dao.setAge(model.getAge());
	        dao.setBirthday(Utils.convertStringToDate(model.getBirthday(), AppConstants.DATE_FORMAT_YYYYMMDD));
	        dao.setEducation_description(model.getEducationDescription());
	        dao.setExperience(model.getExperience());
	        dao.setHasChild(model.isHasChild());
	        dao.setHeader(model.getHeader());
	        dao.setInfo(model.getInfo());
	        dao.setModDate(Utils.convertStringToDate(model.getModDate(), AppConstants.DATE_FORMAT_YYYYMMDD_MMSSH));
	        dao.setPersonalQualities(model.getPersonalQualities());
	        dao.setSalary(model.getSalary());
	        dao.setSex(model.getSex());
	        dao.setSkills(model.getSkills());
	        dao.setUrl(model.getUrl());
	        CountryConverter countryConverter = new CountryConverter();
	        dao.setCountry(countryConverter.convertToDao(model.getCitizenship()));
	        EducationConverter educationConverter = new EducationConverter();
	        dao.setEducation(educationConverter.convertToDao(model.getEducation()));
	        ContactConverter contactConverter = new ContactConverter();
	        dao.setContact(contactConverter.convertToDao(model.getContact()));
	        WorkingTypeConverter workingTypeConverter = new WorkingTypeConverter();
	        dao.setWorkingType(workingTypeConverter.convertToDao(model.getWorkingType()));
	        ExperienceLengthConverter experienceLengthConverter = new ExperienceLengthConverter();
	        dao.setExperienceLength(experienceLengthConverter.convertToDao(model.getExperienceLength()));
	        JobConverter jobConverter = new JobConverter();
	        dao.setJobs(jobConverter.convertToDaoList(model.getJobs()));
	        RubricaConverter rubricaConverter = new RubricaConverter();
	        dao.setRubrics(rubricaConverter.convertToDaoList(model.getRubrics()));
	        if(model.getPhoto()!=null && StringUtils.isNotEmpty(model.getPhoto().getUrl()) )
	        dao.setPhotoUrl(model.getPhoto().getUrl().substring(5));
    	}
        return dao;
    }

    
}
