package jpa.service;

import java.util.ArrayList;
import java.util.List;

import jpa.dao.CourseDAOImpl;
import jpa.dao.StudentCourseDAOImpl;
import jpa.entitymodels.Course;

public class StudentCourseService {
	
	private StudentCourseDAOImpl myStudentCourseDAO;
	public StudentCourseService()
	{
		myStudentCourseDAO = new StudentCourseDAOImpl();
	}

	
	 public List<Course> getAllStudentCourses(String semail)
	 {
		myStudentCourseDAO.openCurrentSession();
		List<Course> listOfCourses = myStudentCourseDAO.getAllStudentCourses(semail);
		myStudentCourseDAO.closeCurrentSession();
		return listOfCourses;
	 }

}
