package com.academy.cic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import java.util.List;
import java.util.ArrayList;

import com.academy.cic.exception.BadRequestException;
import com.academy.cic.exception.EntityNotFoundException;
import com.academy.cic.model.Course;
import com.academy.cic.model.Module;

public class ServiceTest {
	
	private static Dao dao;
	
	private static Service service;
	
	@BeforeAll
	static void init() {
		// creazione mock dao
		dao = Mockito.mock(Dao.class);
		service = new Service(dao);
	}
	
	@Test
	void should_ReturnException_When_NotFoundCourse() {
		Mockito.when(dao.findCourseById(Mockito.anyInt())).thenReturn(null);
		
		Executable executable = () -> service.addModuleToCourse(null,1);
		
		EntityNotFoundException e = assertThrows(EntityNotFoundException.class, executable);
		assertEquals("Course not found", e.getMessage());
	}
	
	@Test
	void should_ReturnException_When_LimitNumberReached() {
		Course course = new Course("Magistrale Computer Science");
		List<Module> modules = new ArrayList<Module>();
		modules.add(new Module("Modulo 1", "Mario Rossi",course));
		modules.add(new Module("Modulo 2", "Stefano Rossi",course));
		modules.add(new Module("Modulo 3", "Giulio Rossi",course));
		modules.add(new Module("Modulo 4", "Stefano Verdi",course));
		modules.add(new Module("Modulo 5", "Giulio Verdi",course));
		modules.add(new Module("Modulo 6", "Mario Verdi",course));
		modules.add(new Module("Modulo 7", "Stefano Bianchi",course));
		modules.add(new Module("Modulo 8", "Giulio Bianchi",course));
		modules.add(new Module("Modulo 9", "Mario Bianchi",course));
		modules.add(new Module("Modulo 10", "Stefano Neri",course));
		Mockito.when(dao.findCourseById(Mockito.anyInt())).thenReturn(course);
		Mockito.when(dao.findModulesByCourseId(Mockito.anyInt())).thenReturn(modules);
		Executable executable = () -> service.addModuleToCourse(null,1);
		
		BadRequestException e = assertThrows(BadRequestException.class, executable);
		assertEquals("No more than 10 modules can be added to a course", e.getMessage());
	}
	
	@Test
	void should_ReturnSizePlusOne_When_EverythingOk() throws EntityNotFoundException, BadRequestException {
		Course course = new Course("Magistrale Computer Science");
		List<Module> modules = new ArrayList<Module>();
		modules.add(new Module("Modulo 1", "Mario Rossi",course));
		modules.add(new Module("Modulo 2", "Stefano Rossi",course));
		modules.add(new Module("Modulo 3", "Giulio Rossi",course));
		modules.add(new Module("Modulo 4", "Stefano Verdi",course));
		modules.add(new Module("Modulo 5", "Giulio Verdi",course));
		modules.add(new Module("Modulo 6", "Mario Verdi",course));
		Module module = new Module("Module 7","Stefano Campagnola",course);
		Mockito.when(dao.findCourseById(Mockito.anyInt())).thenReturn(course);
		Mockito.when(dao.findModulesByCourseId(Mockito.anyInt())).thenReturn(modules);
		Mockito.doNothing().when(dao).insertModuleToCourse(Mockito.any(), Mockito.anyInt());
		int result = service.addModuleToCourse(module,1);
		assertEquals(7, result);
	}

}
