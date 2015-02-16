package com.kandagar.rls.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResumeModel extends BaseModel {

	private String header;
	
	private String skills;
	
	private String info;
	
	private String salary;
	
	@SerializedName("personal_qualities")
	private String personalQualities;
	
	private String url;
	
	private String sex;
	
	private Integer age;
	
	@SerializedName("add_date")
	private String addDate;
	
	@SerializedName("mod_date")
	private String modDate;
	
	private String birthday;
	
	@SerializedName("education_description")
	private String educationDescription;
	
	private String experience;

	@SerializedName("has_child")
	private boolean hasChild;
	
	@SerializedName("cities_references")
	private List<CityModel> citiesReferences;
	
	private CountryModel citizenship;
	
	private ContactModel contact;
	
	private EducationModel education;
	
	@SerializedName("experience_length")
	private ExperienceLengthModel experienceLength;
	
	@SerializedName("working_type")
	private WorkingTypeModel workingType;
	
	private List<JobModel> jobs;
	
	private PhotoModel photo;
	
	private List<RubricaModel> rubrics;
	
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPersonalQualities() {
		return personalQualities;
	}

	public void setPersonalQualities(String personalQualities) {
		this.personalQualities = personalQualities;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEducationDescription() {
		return educationDescription;
	}

	public void setEducation_description(String educationDescription) {
		this.educationDescription = educationDescription;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public List<CityModel> getCitiesReferences() {
		return citiesReferences;
	}

	public void setCities_references(List<CityModel> citiesReferences) {
		this.citiesReferences = citiesReferences;
	}

	public CountryModel getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(CountryModel citizenship) {
		this.citizenship = citizenship;
	}

	public ContactModel getContact() {
		return contact;
	}

	public void setContact(ContactModel contact) {
		this.contact = contact;
	}

	public EducationModel getEducation() {
		return education;
	}

	public void setEducation(EducationModel education) {
		this.education = education;
	}

	public ExperienceLengthModel getExperienceLength() {
		return experienceLength;
	}

	public void setExperienceLength(ExperienceLengthModel experienceLength) {
		this.experienceLength = experienceLength;
	}

	public WorkingTypeModel getWorkingType() {
		return workingType;
	}

	public void setWorkingType(WorkingTypeModel workingType) {
		this.workingType = workingType;
	}

	public List<JobModel> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobModel> jobs) {
		this.jobs = jobs;
	}

	public PhotoModel getPhoto() {
		return photo;
	}

	public void setPhoto(PhotoModel photo) {
		this.photo = photo;
	}

	public List<RubricaModel> getRubrics() {
		return rubrics;
	}

	public void setRubrics(List<RubricaModel> rubrics) {
		this.rubrics = rubrics;
	}
	
}
