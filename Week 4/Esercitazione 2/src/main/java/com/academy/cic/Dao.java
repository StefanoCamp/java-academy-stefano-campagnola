package com.academy.cic;


import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.TypedQuery;

import com.academy.cic.util.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.academy.cic.model.*;
import com.academy.cic.model.Module;

public class Dao {
	
private static final Logger logger = Logger.getLogger(Dao.class.getName());
	
	public Integer insertCourse(Course course){
		logger.info("insertCourse");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer id = null;
	   
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(course); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return id;

	}
	
	public Course findCourseByName(String name) {
		logger.info("findCourseByName");
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Course> course = null;
		try {
			TypedQuery<Course> query = session.createQuery("SELECT c FROM Course c WHERE c.name=:name", Course.class);
			query.setParameter("name", name);
			course = query.getResultList(); 
			if (course != null) {
				for(Course c : course) {
					Hibernate.initialize(c.getModules());
				}
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
		return course.get(0);

	}

	public void addModuleToCourse(Module module, int courseid) {
		logger.info("addModuleToCourse");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Course course = null;
		try {
			course = session.get(Course.class, courseid);
			if (course != null) {
				course.getModules().add(module);
				session.update(course);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}

	}

	public Set<Module> findCourseModules(int courseId) {
		logger.info("findCourseModules");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Course course = null;
		Set<Module> modules = null;
		
		try {
			course = session.get(Course.class, courseId);
			if (course != null) {
				Hibernate.initialize(course.getModules());
				modules = course.getModules();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
		
		return modules;

	}
	
	public List<Course>  findStartingCourseInRange(Date from, Date to) {
		logger.info("findStartingCourseInRange");
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Course> course = null;
		try {
			TypedQuery<Course> query  = session.createQuery("SELECT c FROM Course c WHERE c.startDate BETWEEN :startDate and :endDate", Course.class);
			query.setParameter("startDate", from);
			query.setParameter("endDate", to);
			course = query.getResultList();
			if (course != null) {
				for(Course c : course) {
					Hibernate.initialize(c.getModules());
				}
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close(); 
		}
		return course;

	}
	
	public void updateStartDate(Date startDate, int courseId){
		logger.info("updateStartDate");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Course course = session.get(Course.class, courseId);
			course.setStartDate(startDate);
			session.update(course);
			tx.commit(); 
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close(); 
		}

	}
	
	public void deleteCourse(int courseId){
		logger.info("deleteCourse");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Course course = session.get(Course.class, courseId); 
			session.delete(course); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}

	}
	
	public void deleteAllCourses(){
		logger.info("deleteAllCourses");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.createQuery("DELETE FROM Course").executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	public void deleteAllModules(){
		logger.info("deleteAllModules");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.createQuery("DELETE FROM Module").executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}

}
