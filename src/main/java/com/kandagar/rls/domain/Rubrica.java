package com.kandagar.rls.domain;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="rubrica")
public class Rubrica extends BaseEntity{

	@Column(name="site_id")
	private Integer siteId;
	
	@Column(columnDefinition="TEXT")
	private String name;
	
	@ManyToMany(mappedBy="rubrics")
    private Collection<Resume> resumes;
	 
	public Rubrica() {
	}
	
	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
 
	public Rubrica(String name) {
		this.setName(name);
	}
 
	public Rubrica(String name, Set<Resume> resumes) {
		this.setName(name);
		this.setResumes(resumes);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Resume> getResumes() {
		return this.resumes;
	}

	public void setResumes(Collection<Resume> resumes) {
		this.resumes = resumes;
	}
}
