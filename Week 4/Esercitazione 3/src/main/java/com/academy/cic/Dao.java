package com.academy.cic;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import com.academy.cic.model.Course;
import com.academy.cic.model.Registration;
import com.academy.cic.model.Student;
import com.academy.cic.model.Module;
import com.academy.cic.util.JpaUtil;



public class Dao {
	
	private static final Logger logger = Logger.getLogger(Dao.class.getName());
	
	public void insertStudent(Student student){
		logger.info("insertStudent");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
	   
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(student); 
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			entityManager.close(); 
		}
	}
	
	public void insertCourse(Course course){
		logger.info("insertCourse");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
	   
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(course); 
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			entityManager.close(); 
		}
	}
	
	public void insertModule(Module module){
		logger.info("insertModule");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
	   
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(module); 
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			entityManager.close(); 
		}
	}
	
	
	public void insertModuleToCourse(Module module, int courseId){
		logger.info("insertModuleToCourse");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
	    Course course = null;
		try {
			course = entityManager.find(Course.class, courseId);
			course.getModules().add(module);
			entityManager.getTransaction().begin();
			entityManager.merge(course); 
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			entityManager.close(); 
		}
	}
	
	public void registryStudentCourse(Registration registration){
		logger.info("registryStudentCourse");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
	   
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(registration); 
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace(); 
		} finally {
			entityManager.close(); 
		}
	}
	
	public Course findCourseById(int courseId) {
		logger.info("findCourseById");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Course course = null;
		try {
			course = entityManager.find(Course.class, courseId);
			if(course != null) {
				Hibernate.initialize(course.getModules());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		
		return course;
	}
	
	public List<Module> findModulesByCourseId(int courseId){
		logger.info("findModulesByCourseId");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		List<Module> modules = null;
		try {
			Course course = entityManager.find(Course.class, courseId);
			if(course != null) {
				Hibernate.initialize(course.getModules());
				modules=course.getModules();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		return modules;
	}
	
	public List<Student> findByNameSurname(String name, String surname){
		logger.info("findByNameSurname");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		List<Student> students = null;
		try {
			TypedQuery<Student> query = entityManager.createNamedQuery("Student.findByNameSurnameNamedQuery", Student.class);
			query.setParameter("firstname", name);
			query.setParameter("surname", surname);
			students = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		return students;
	}

	public void updateCourseGradeById(int registrationId, int grade) {
		logger.info("updateCourseGradeById");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			Registration registration = entityManager.find(Registration.class, registrationId);
			registration.setGrade(grade);
			entityManager.getTransaction().begin();
			entityManager.merge(registration);
			entityManager.getTransaction().commit();
		} catch (HibernateException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
	}
	
	public Double findAvgGradeByStudentId(int studentId){
		logger.info("findAvgGradeByStudentId");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Double average = null;
		try {
			TypedQuery<Double> query =  entityManager.createNamedQuery("Registration.findAvgGradeByStudentIdNamedQuery", Double.class);
			query.setParameter("studentId", studentId);
			average = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		return average;
	}
	
	public Student findStudentData(int studentId){
		logger.info("findStudentData");
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		Student student = null;
		try {
			student = entityManager.find(Student.class, studentId);
			if(student != null) {
				Hibernate.initialize(student.getRegistrations());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close(); 
		}
		return student;
	}
	
//	public void deleteAllStudents() {
//		logger.info("deleteAllStudents");
//		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
//		try {
//			Query query = entityManager.createNativeQuery("Delete from Student");
//			query.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			entityManager.close(); 
//		}
//	}
//	
//	public void deleteAllCourses() {
//		logger.info("deleteAllCourses");
//		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
//		try {
//			Query query = entityManager.createNativeQuery("Delete from Course");
//			query.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			entityManager.close(); 
//		}
//	}
//	
//	public void deleteAllRegistrations() {
//		logger.info("deleteAllRegistrations");
//		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
//		try {
//			Query query = entityManager.createNativeQuery("Delete from Registration");
//			query.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			entityManager.close(); 
//		}
//	}
}
