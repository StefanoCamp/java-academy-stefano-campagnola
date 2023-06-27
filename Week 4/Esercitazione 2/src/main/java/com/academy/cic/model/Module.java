package com.academy.cic.model;

public class Module {
	
	private int id;
	private String name, teacher;
	
	public Module() {
		
	}
	
	public Module(String name, String teacher) {
		setName(name);
		setTeacher(teacher);
	}
	
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
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Module [id=" + id + ", name=" + name + ", teacher=" + teacher + "]";
	}
	
	

}
