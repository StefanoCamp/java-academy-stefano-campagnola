package com.academy.cic.model;

import java.sql.Date;
import java.util.Set;

public class Course {
	
	private int id;
	private String name;
	private Date startDate, endDate;
	private Set<Module> modules;
	
	/*public Course() {
		
	}
	
	public Course(String name, Date startDate, Date endDate) {
		setName(name);
		setStartDate(startDate);
		setEndDate(endDate);
	}*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	

}
