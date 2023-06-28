package com.academy.cic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "STUDENT")
@NamedQuery(name="Student.findByNameSurnameNamedQuery", query = "SELECT s FROM Student s WHERE s.firstName= :firstname and s.lastName = :surname")
public class Student extends Base{
	
	//private static final Logger logger = Logger.getLogger(Student.class.getName());
	
	@Column(name = "first_name", nullable = false, length = 32)
	private String firstName; 
	
	@Column(name = "last_name", nullable = false, length = 32)
	private String lastName;
	
	@Column(nullable = true)
	private int age;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Registration> registrations;
	
	public Student() {
		
	}
	
	public Student(String name,String surname, int age) {
		setFirstName(name);
		setLastName(surname);
		setAge(age);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return String.format("Name : %s, Surname : %s, Age : %d", getFirstName(),getLastName(),getAge());
	}
	
	
	
	
}
