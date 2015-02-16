package com.kandagar.rls.model;

public class BaseModel {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isNew(){
		return this.id==null;
	}
}
