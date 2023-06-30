package com.academy.cic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course extends Base{

	@Column(name = "name", nullable = false, length = 64)
	private String name;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private List<Registration> registrations;
	
	@OneToMany(mappedBy = "courseModule", fetch = FetchType.LAZY)
	private List<Module> modules;
	
	public Course() {
		
	}
	
	public Course(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@Override
	public String toString() {
		return String.format("Course name : %s", getName());
	}
	
	
	
}
