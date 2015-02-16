package com.kandagar.rls.model;

public class JobModel {

	private CityModel city;
	
	private CompanyModel company;
	
	private DateModel date;
	
	private String description;

	public CityModel getCity() {
		return city;
	}

	public void setCity(CityModel city) {
		this.city = city;
	}

	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateModel getDate() {
		return date;
	}

	public void setDate(DateModel date) {
		this.date = date;
	}
}
