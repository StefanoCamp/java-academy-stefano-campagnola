package com.academy.cic.model;

public class Registration {
	
	private int id;
	private Student student;
	private Course course;
	private int grade;
	
	public Registration() {
	
	}
	
	public Registration(int id,Student student,Course course,int grade) {
		setId(id);
		setStudent(student);
		setCourse(course);
		setGrade(grade);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", student=" + student + ", course=" + course + ", grade=" + grade + "]";
	}
	
	
	
	

}
