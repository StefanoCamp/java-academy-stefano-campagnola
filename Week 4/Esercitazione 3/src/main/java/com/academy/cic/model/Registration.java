package com.academy.cic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "REGISTRATION")
@NamedQuery(name="Registration.findAvgGradeByStudentIdNamedQuery", query = "SELECT avg(grade) FROM Registration r WHERE r.student.id= :studentId")
public class Registration extends Base{
	
	@Column(name = "grade")
	private int grade;
	
	@ManyToOne
	@JoinColumn(name="student_id", nullable = false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="course_id", nullable = false)
	private Course course;
	
	public Registration() {
		
	}
	
	public Registration(int grade,Student student,Course course) {
		setGrade(grade);
		setStudent(student);
		setCourse(course);
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
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

	@Override
	public String toString() {
		return "Registration [grade=" + grade + ", course=" + course + "]";
	}
	
	

}
