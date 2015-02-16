package com.kandagar.rls.domain;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="job")
public class Job extends BaseEntity  {
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	@ManyToMany(mappedBy="jobs")
    private Collection<Resume> resumes;
	 
	public Job() {
	}
 
	public Job(String description) {
		this.setDescription(description);
	}
 
	public Job(String description, Set<Resume> resumes) {
		this.setDescription(description);
		this.setResumes(resumes);
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Resume> getResumes() {
		return this.resumes;
	}

	public void setResumes(Collection<Resume> resumes) {
		this.resumes = resumes;
	}
}
