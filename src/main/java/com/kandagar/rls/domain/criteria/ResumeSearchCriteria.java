package com.kandagar.rls.domain.criteria;

public class ResumeSearchCriteria extends BaseSearchCriteria {
	
	private Integer workingTypeId;
	
	private Integer educationId;

	private Integer rubricaId;
	
	public Integer getRubricaId() {
		return rubricaId;
	}

	public void setRubricaId(Integer rubricaId) {
		this.rubricaId = rubricaId;
	}

	public Integer getWorkingTypeId() {
		return workingTypeId;
	}

	public void setWorkingTypeId(Integer workingTypeId) {
		this.workingTypeId = workingTypeId;
	}

	public Integer getEducationId() {
		return educationId;
	}

	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}
}
