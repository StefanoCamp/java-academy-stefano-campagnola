package com.academy.cic;

import java.util.List;


import com.academy.cic.model.Course;
import com.academy.cic.model.Registration;
import com.academy.cic.model.Student;

public class Main {

	public static void main(String[] args) {
		
		Dao dao = new Dao();
		
		Student s1 = new Student("Stefano","Campagnola",27);
		Student s2 = new Student("Mario","Rossi",30);
		Student s3 = new Student("Stefano","Bianchi",24);
		Course c1 = new Course("Programmazione");
		Course c2 = new Course("Architettura");
		Course c3 = new Course("Fisica");
		Course c4 = new Course("Statistica");
		Course c5 = new Course("Calcolo");
		Course c6 = new Course("Reti");
		Registration r1 = new Registration(30,s1,c1);
		Registration r2 = new Registration(28,s1,c2);
		Registration r3 = new Registration(26,s1,c3);
		Registration r4 = new Registration(25,s2,c4);
		Registration r5 = new Registration(25,s2,c5);
		Registration r6 = new Registration(30,s3,c6);
		Registration r7 = new Registration(18,s3,c2);
		Registration r8 = new Registration(25,s3,c3);
		Registration r9 = new Registration(22,s3,c4);
		
		dao.insertStudent(s1);
		dao.insertStudent(s2);
		dao.insertStudent(s3);
		
		dao.insertCourse(c1);
		dao.insertCourse(c2);
		dao.insertCourse(c3);
		dao.insertCourse(c4);
		dao.insertCourse(c5);
		dao.insertCourse(c6);
		
		dao.registryStudentCourse(r1);
		dao.registryStudentCourse(r2);
		dao.registryStudentCourse(r3);
		dao.registryStudentCourse(r4);
		dao.registryStudentCourse(r5);
		dao.registryStudentCourse(r6);
		dao.registryStudentCourse(r7);
		dao.registryStudentCourse(r8);
		dao.registryStudentCourse(r9);
		
		List<Student> students = dao.findByNameSurname("Stefano", "Campagnola");
		for(Student s : students) {
			System.out.println(students);
		}
		

		dao.updateCourseGradeById(r2.getId(), 26);
		
		Double average = dao.findAvgGradeByStudentId(s1.getId());	
		System.out.println(average);
		
		Student student = dao.findStudentData(s1.getId());
		System.out.println(student);
		for(Registration r : student.getRegistrations()) {
			System.out.println(r);
		}


	}

}
