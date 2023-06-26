package com.academy.cic;

import java.sql.SQLException;
import java.util.List;

import com.academy.cic.model.Course;
import com.academy.cic.model.Registration;
import com.academy.cic.model.Student;
import com.academy.cic.model.StudentNumCourses;

public class Main {

	public static void main(String[] args) {
		Student s1 = new Student(0,"Stefano","Campagnola", 27);
		Student s2 = new Student(1,"Mario","Rossi", 30);
		Student s3 = new Student(2,"Stefano","Bianchi", 24);
		Course c1 = new Course(0,"Programmazione");
		Course c2 = new Course(1,"Architettura");
		Course c3 = new Course(2,"Calcolo");
		Course c4 = new Course(3,"Fisica");
		Registration r1 = new Registration(0,s1,c1,30);
		Registration r2 = new Registration(1,s1,c2,28);
		Registration r3 = new Registration(2,s1,c3,30);
		Registration r4 = new Registration(3,s1,c4,27);
		Registration r5 = new Registration(4,s2,c1,25);
		Registration r6 = new Registration(5,s3,c2,25);
		Registration r7 = new Registration(6,s3,c3,26);
		Registration r8 = new Registration(7,s3,c4,23);
		
		Dao dao = new Dao();
		try {
			dao.insertStudent(s1);
			dao.insertStudent(s2);
			dao.insertStudent(s3);
			dao.insertCourse(c1);
			dao.insertCourse(c2);
			dao.insertCourse(c3);
			dao.insertCourse(c4);
			dao.registryStudentCourse(r1);
			dao.registryStudentCourse(r2);
			dao.registryStudentCourse(r3);
			dao.registryStudentCourse(r4);
			dao.registryStudentCourse(r5);
			dao.registryStudentCourse(r6);
			dao.registryStudentCourse(r7);
			dao.registryStudentCourse(r8);
			
			System.out.println("---------------------------------------Print student-------------------------------------");
			Student student = dao.selectByNameSurname("Stefano", "Campagnola");
			System.out.println(student);
			
			System.out.println("\n---------------------------------------Print update grade operation-----------------------------");
			System.out.format("grade : %d",dao.selectRegByID(r2.getId()).getGrade());
			dao.updateCourseGradeById(r2.getId(), 30);
			System.out.format("\ngrade : %d",dao.selectRegByID(r2.getId()).getGrade());
			
			System.out.println("\n--------------------------------------Print courses for student 0-----------------------------");
			List<Course> courses = dao.findStudentCourses(0);
			for(Course c:courses) {
				System.out.println(c);
			}
			
			System.out.println("\n--------------------------------------Print number of courses with IDs only----------------------");
			List<StudentNumCourses> list1 = dao.findStudentIdNumCourses();
			for(StudentNumCourses s:list1) {
				s.printIdOnly();
			}
			
			
			System.out.println("\n-------------------------------------Print number of courses with all the data--------------------------");
			List<StudentNumCourses> list2 = dao.findStudentDataNumCourses();
			for(StudentNumCourses s:list2) {
				System.out.println(s);
			}
			
			
			dao.deleteAllRegistrations();
			dao.deleteAllCourses();
			dao.deleteAllStudents();
		}catch(SQLException ex) {
			System.out.println("Errore");
		}
		
		

	}

}
