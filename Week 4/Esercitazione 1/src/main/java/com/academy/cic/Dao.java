package com.academy.cic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.academy.cic.model.*;
import com.academy.cic.util.JdbcUtil;

public class Dao {
	
	public void insertStudent(Student student) throws SQLException {
		String query = "INSERT INTO STUDENT (ID, FIRST_NAME, LAST_NAME, AGE) VALUES  (?, ?, ?, ?)";

    	Connection conn = null;
    	PreparedStatement pstm = null;

        try {
            conn = JdbcUtil.getConnection();

            pstm = conn.prepareStatement(query);
            pstm.setInt(1, student.getId());
            pstm.setString(2, student.getFirstName());
            pstm.setString(3, student.getLastName());
            pstm.setInt(4, student.getAge());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
    }
	
	public void insertCourse(Course course) throws SQLException {
		String query = "INSERT INTO COURSE (ID, NAME) VALUES  (?, ?)";

    	Connection conn = null;
    	PreparedStatement pstm = null;

        try {
            conn = JdbcUtil.getConnection();

            pstm = conn.prepareStatement(query);
            pstm.setInt(1, course.getId());
            pstm.setString(2, course.getName());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
    }
	
	public void registryStudentCourse(Registration registration) throws SQLException {
		String query = "INSERT INTO REGISTRATION (ID, STUDENT_ID, COURSE_ID, GRADE) VALUES  (?, ?, ?, ?)";

    	Connection conn = null;
    	PreparedStatement pstm = null;

        try {
            conn = JdbcUtil.getConnection();

            pstm = conn.prepareStatement(query);
            pstm.setInt(1, registration.getId());
            pstm.setInt(2, registration.getStudent().getId());
            pstm.setInt(3, registration.getCourse().getId());
            pstm.setInt(4, registration.getGrade());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
    }

	
	public Student selectByNameSurname(String name, String surname) throws SQLException {
    	String query = "SELECT S.* FROM STUDENT S WHERE S.FIRST_NAME = ? AND S.LAST_NAME = ?";

    	Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rs = null;
    	Student student = null;

        try {
        	conn = JdbcUtil.getConnection();

        	pstm = conn.prepareStatement(query);
        	pstm.setString(1, name);
        	pstm.setString(2, surname);

            rs = pstm.executeQuery();
            while(rs.next()) {
                student = new Student(rs.getInt("ID"),rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"),rs.getInt("AGE"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
        return student;
    }
	
	public Registration selectRegByID(int id) throws SQLException {
    	String query = "SELECT R.* FROM REGISTRATION R WHERE ID = ?";

    	Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rs = null;
    	Registration registration = null;

        try {
        	conn = JdbcUtil.getConnection();

        	pstm = conn.prepareStatement(query);
        	pstm.setInt(1, id);

            rs = pstm.executeQuery();
            if(rs.next()) {
            	registration = new Registration(rs.getInt("ID"),new Student(rs.getInt("STUDENT_ID"),null,null,0),new Course(rs.getInt("course_id"),null),rs.getInt("grade"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
        return registration;
	}
	
	public void updateCourseGradeById(int registrationID, int grade) throws SQLException {
    	String query = "UPDATE REGISTRATION SET GRADE = ? WHERE ID = ?";

    	Connection conn = null;
    	PreparedStatement pstm = null;

        try {
            conn = JdbcUtil.getConnection();

            pstm = conn.prepareStatement(query);
            pstm.setInt(1, grade);
            pstm.setInt(2, registrationID);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
    }
	
	public List<Course> findStudentCourses(int studentID) throws SQLException{
		List<Course> courses = new ArrayList<Course>();
		String query = "Select c.* from course c, registration r where r.student_Id = ? and r.course_id = c.id";
		
		Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rs = null;

        try {
        	conn = JdbcUtil.getConnection();

        	pstm = conn.prepareStatement(query);
        	pstm.setInt(1, studentID);

            rs = pstm.executeQuery();
            while (rs.next()) {
            	courses.add(new Course(rs.getInt("ID"),rs.getString("NAME")));
            }
            


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
		return courses;
	}
	
	public List<StudentNumCourses> findStudentIdNumCourses() throws SQLException{
		List<StudentNumCourses> list = new ArrayList<StudentNumCourses>();
		String query = "Select r.student_id, count(*) as numcourses from registration r group by r.student_id";
		
		Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rs = null;

        try {
        	conn = JdbcUtil.getConnection();

        	pstm = conn.prepareStatement(query);

            rs = pstm.executeQuery();
            while (rs.next()) {
            	list.add(new StudentNumCourses(new Student(rs.getInt("STUDENT_ID"),null,null,0),rs.getInt("NUMCOURSES")));
            }
            


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
		return list;
	}
	
	public List<StudentNumCourses> findStudentDataNumCourses() throws SQLException{
		List<StudentNumCourses> list = new ArrayList<StudentNumCourses>();
		String query = "Select s.*, count(*) as numcourses from registration r, student s where s.id=r.student_id group by r.student_id";
		
		Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rs = null;

        try {
        	conn = JdbcUtil.getConnection();

        	pstm = conn.prepareStatement(query);

            rs = pstm.executeQuery();
            while (rs.next()) {
            	list.add(new StudentNumCourses(new Student(rs.getInt("ID"),rs.getString("first_name"),rs.getString("last_name"),rs.getInt("age")),rs.getInt("NUMCOURSES")));
            }
            


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
		return list;
	}
	
	public void deleteAllRegistrations() throws SQLException {
		String query = "delete from registration;";
		
		Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rs = null;

        try {
        	conn = JdbcUtil.getConnection();

        	pstm = conn.prepareStatement(query);

            pstm.executeUpdate();
            


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
	}
	
	public void deleteAllCourses() throws SQLException {
		String query = "delete from course;";
		
		Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rs = null;

        try {
        	conn = JdbcUtil.getConnection();

        	pstm = conn.prepareStatement(query);

            pstm.executeUpdate();
            


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
	}
	
	public void deleteAllStudents() throws SQLException {
		String query = "delete from student;";
		
		Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rs = null;

        try {
        	conn = JdbcUtil.getConnection();

        	pstm = conn.prepareStatement(query);

            pstm.executeUpdate();
            


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstm);
        	JdbcUtil.closeConnection(conn);
        }
	}

}
