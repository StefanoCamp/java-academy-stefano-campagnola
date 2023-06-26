package com.academy.cic.model;

public class Student {
	
	private int id, age;
	private String firstName,lastName;
	
	public Student() {
		
	}
	
	public Student(int id, String firstName,String lastName, int age) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return String.format("id : %d, name : %s, surname : %s, age : %d",getId(),getFirstName(),getLastName(),getAge());
	}
	
	

}
