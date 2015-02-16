package com.kandagar.rls.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.kandagar.rls.domain.Contact;
import com.kandagar.rls.domain.Country;
import com.kandagar.rls.domain.Education;
import com.kandagar.rls.domain.ExperienceLength;
import com.kandagar.rls.domain.Job;
import com.kandagar.rls.domain.WorkingType;

@Entity
@Table(name="resume")
public class Resume extends BaseEntity {
	
	@Column(name="site_id")
	private Integer siteId;

	@Column(columnDefinition="TEXT")
	private String header;
	
	@Column(columnDefinition="TEXT")
	private String skills;
	
	@Column(columnDefinition="TEXT")
	private String info;
	
	private String salary;
	
	@Column(name="personal_qualities", columnDefinition="TEXT")
	private String personalQualities;
	
	private String url;
	
	private String sex;
	
	private Integer age;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	@Column(name="add_date")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date addDate;
	
	@Column(name="modDate")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name="education_description", columnDefinition="TEXT")
	private String educationDescription;
	
	@Column(columnDefinition="TEXT")
	private String experience;

	@Column(name="has_child", nullable=false, columnDefinition="BIT", length=1)
	private boolean hasChild;

	@ManyToOne
    @JoinColumn(name="country_id")
	private Country country;
	
	@ManyToOne
    @JoinColumn(name="contact_id")
	private Contact contact;
	
	@ManyToOne
    @JoinColumn(name="education_id")
	private Education education;
	
	@ManyToOne
    @JoinColumn(name="experience_length_id")
	private ExperienceLength experienceLength;
	
	@ManyToOne
    @JoinColumn(name="working_type_id")
	private WorkingType workingType;
	
	@ManyToMany 
    private Collection<Job> jobs;

	@ManyToMany 
    private Collection<Rubrica> rubrics;
	
	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	
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

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
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

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public ExperienceLength getExperienceLength() {
		return experienceLength;
	}

	public void setExperienceLength(ExperienceLength experienceLength) {
		this.experienceLength = experienceLength;
	}

	public WorkingType getWorkingType() {
		return workingType;
	}

	public void setWorkingType(WorkingType workingType) {
		this.workingType = workingType;
	}

	public Collection<Rubrica> getRubrics() {
		return this.rubrics;
	}

	public void setRubrics(Collection<Rubrica> rubrics) {
		this.rubrics = rubrics;
	}

	public Collection<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(Collection<Job> jobs) {
		this.jobs = jobs;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
