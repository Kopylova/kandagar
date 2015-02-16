package com.kandagar.rls.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="experience_length")
public class ExperienceLength extends BaseEntity {

	@Column(name="site_id")
	private Integer siteId;
	
	@Column(columnDefinition="TEXT")
	private String name;

	@OneToMany(mappedBy="experienceLength")
	private Set<Resume> resumes;
	
	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	
	public Set<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(Set<Resume> resumes) {
		this.resumes = resumes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
