package com.academy.cic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MODULE")
public class Module extends Base{
	
	@Column(name = "name", nullable =false, length = 64)
	private String name;
	
	@Column(name = "teacher", length = 64)
	private String teacher;
	
	@ManyToOne
	@JoinColumn(name="course_id", nullable = false)
	private Course courseModule;
	
	public Module() {
		
	}
	public Module(String name, String teacher, Course course) {
		setName(name);
		setTeacher(teacher);
		setCourse(course);
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

	public Course getCourse() {
		return courseModule;
	}

	public void setCourse(Course course) {
		this.courseModule = course;
	}

	@Override
	public String toString() {
		return "Module [name=" + name + ", teacher=" + teacher  + "]";
	}
	
	

}
