package com.academy.cic.model;

public class StudentNumCourses  extends Student{

	private int numCourses;
	
	public StudentNumCourses() {
		super();
	}
	
	public StudentNumCourses(Student student, int numCourses) {
		super(student.getId(),student.getFirstName(),student.getLastName(),student.getAge());
		setNumCourses(numCourses);
	}

	public int getNumCourses() {
		return numCourses;
	}

	public void setNumCourses(int numCourses) {
		this.numCourses = numCourses;
	}

	@Override
	public String toString() {
		return String.format("Number of courses : %d, " + super.toString(), getNumCourses());
	}
	
	public void printIdOnly() {
		System.out.format("Number of courses : %d" + ", Id : "+getId()+"%n",getNumCourses());
	}
	
	
	
}
