package com.kandagar.rls.model;

public class DateModel {

	private DateType from;
	
	private DateType to;

	public DateType getFrom() {
		return from;
	}

	public void setFrom(DateType from) {
		this.from = from;
	}

	public DateType getTo() {
		return to;
	}

	public void setTo(DateType to) {
		this.to = to;
	}
}

class DateType {

	private String date;
	
	private String month;
	
	private String year;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}

