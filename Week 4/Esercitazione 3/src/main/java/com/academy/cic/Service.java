package com.academy.cic;

import java.util.List;

import com.academy.cic.exception.BadRequestException;
import com.academy.cic.exception.EntityNotFoundException;
import com.academy.cic.model.Course;
import com.academy.cic.model.Module;

public class Service {
	
	private static final String COURSE_NOT_FOUND_MSG = "Course not found";
	private static final String lIMIT_REACHED_MSG = "No more than 10 modules can be added to a course";
	
	private Dao dao;
	
	public Service(Dao dao) {
		this.dao = dao;
	}
	
	public int addModuleToCourse(Module module, int courseId) throws EntityNotFoundException, BadRequestException {
		
		Course course = dao.findCourseById(courseId);
		if(course==null) {
			throw new EntityNotFoundException(COURSE_NOT_FOUND_MSG);
		}
		
		List<Module> modules = dao.findModulesByCourseId(courseId);
		if(modules.size()>=10) {
			throw new BadRequestException(lIMIT_REACHED_MSG);
		}
		
		dao.insertModuleToCourse(module,courseId);
		
		return modules.size()+1;
	}

}
