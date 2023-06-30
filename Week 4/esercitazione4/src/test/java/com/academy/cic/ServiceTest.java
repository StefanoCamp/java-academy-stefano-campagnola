package com.academy.cic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import com.academy.cic.exception.BadRequestException;
import com.academy.cic.exception.EntityNotFoundException;
import com.academy.cic.entity.Apartment;

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
	void should_ReturnException_When_NotFoundApartment() {
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(null);
		
		Executable executable = () -> service.rateApartment(1);
		
		EntityNotFoundException e = assertThrows(EntityNotFoundException.class, executable);
		assertEquals(String.format("Apartment with id %d not found",1), e.getMessage());
	}
	

	@ParameterizedTest
	@CsvSource(value = {"0.0, 6000.0,-1", "72.0, 250000.0,0","48.0, 350000.0,1", "30.0, 600000.0,2"})
	void should_ReturnMinus1_When_Area0(double area, BigDecimal price, int rating) throws EntityNotFoundException {
		Apartment apartment = new Apartment(area,price);
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
		
		int result = service.rateApartment(1);
		
		assertEquals(rating,result);
	}
	
//	@Test
//	void should_ReturnMinus1_When_Area0() throws EntityNotFoundException {
//		Apartment apartment = new Apartment(0.0,new BigDecimal(6000.0));
//		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
//		
//		int result = service.rateApartment(1);
//		
//		assertEquals(-1, result);
//	}
//
//	@Test
//	void should_Return0_When_RatioLesserThanCheapThreshold() throws EntityNotFoundException {
//		Apartment apartment = new Apartment(72.0,new BigDecimal(250000.0));
//		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
//		
//		int result = service.rateApartment(1);
//		
//		assertEquals(0, result);
//	}
//	
//	@Test
//	void should_Return1_When_RatioLesserThanCheapThreshold() throws EntityNotFoundException {
//		Apartment apartment = new Apartment(48.0,new BigDecimal(350000.0));
//		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
//		
//		int result = service.rateApartment(1);
//		
//		assertEquals(1, result);
//	}
//	
//	@Test
//	void should_Return2_When_RatioLesserThanCheapThreshold() throws EntityNotFoundException {
//		Apartment apartment = new Apartment(30.0,new BigDecimal(600000.0));
//		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
//		
//		int result = service.rateApartment(1);
//		
//		assertEquals(2, result);
//	}
	
	@Test
	void should_ReturnException_When_AreaGreaterThan1000() {
		
		Executable executable = () -> service.updateArea(1,10000);
		
		BadRequestException e = assertThrows(BadRequestException.class, executable);
		assertEquals("Cannot update area to a value greater than 1000", e.getMessage());
	}
	
	@Test
	void should_ReturnException_When_NotFoundApartment2() {
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(null);
		
		Executable executable = () -> service.updateArea(1,100);
		
		EntityNotFoundException e = assertThrows(EntityNotFoundException.class, executable);
		assertEquals(String.format("Apartment with id %d not found",1), e.getMessage());
	}
	
	@Test
	void should_ReturnANumberBetweenMinus1And2_When_AssertionNotNull() throws BadRequestException, EntityNotFoundException {
		Apartment apartment = new Apartment(30.0,new BigDecimal(600000.0));
		Mockito.when(dao.findApartment(Mockito.anyInt())).thenReturn(apartment);
		Mockito.when(dao.updateApartment(Mockito.any())).thenReturn(apartment);
		
		int result = service.updateArea(1,30.0);
		
		assertEquals(2, result);
	}
}
