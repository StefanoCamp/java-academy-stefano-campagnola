package com.academy.cic;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.academy.cic.model.Module;
import com.academy.cic.model.Course;

public class Main {

	public static void main(String[] args) {
		Dao dao = new Dao();
		Module m1 = new Module("Programmazione","Mario Rossi");
		Module m2 = new Module("Architettura","Stefano Bianchi");
		Module m3 = new Module("Fisica","Mario Bianchi");
		Module m4 = new Module("Storia","Maria Verde");
		Module m5 = new Module("Letteratura","Giulia Bianchi");
		Course c1 = new Course("Informatica",Date.valueOf("2023-07-07"),Date.valueOf("2024-08-12"));
		Course c2 = new Course("Lingue",Date.valueOf("2024-07-07"),Date.valueOf("2025-08-12"));
		Set<Module> modules1 = new HashSet<Module>();
		modules1.add(m1);
		modules1.add(m2);
		modules1.add(m3);
		c1.setModules(modules1);
		Set<Module> modules2 = new HashSet<Module>();
		modules2.add(m4);
		modules2.add(m5);
		c2.setModules(modules2);
		
		
		dao.insertCourse(c1);
		dao.insertCourse(c2);
		
		Course c3 = dao.findCourseByName("Informatica");
		
		
		Module m6 = new Module("Statistica","Giulio Bianchi");
		dao.addModuleToCourse(m6, c3.getId());
		
		Set<Module> modules3 = dao.findCourseModules(c3.getId());
		System.out.println(modules3);
		
		List<Course> coursesRange = dao.findStartingCourseInRange(Date.valueOf("2022-06-06"), Date.valueOf("2025-06-08"));
		for(Course c : coursesRange) {
			System.out.println(c);
		}
		
		dao.updateStartDate(Date.valueOf("2022-06-06"), c3.getId());
		
		dao.deleteCourse(c3.getId());
		
		dao.deleteAllModules();
		dao.deleteAllCourses();

	}

}
