package jpa.service;

import java.util.List;

import jpa.dao.CourseDAOImpl;
import jpa.entitymodels.Course;


public class CourseService{
	
	private CourseDAOImpl myCourseDAO;
	public CourseService()
	{
		myCourseDAO = new CourseDAOImpl();
	}

	public List<Course> getAllCourses() {
		
		
		myCourseDAO.openCurrentSession();
        List<Course> Courses = myCourseDAO.getAllCourses();
        myCourseDAO.closeCurrentSession();
		return Courses;
	}
	
	//Course newCourse = courseService.GetCourseById(number).get(0);
	
	public Course GetCourseById(int cId)
	{
		myCourseDAO.openCurrentSession();
        Course course = myCourseDAO.GetCourseById(cId);
        myCourseDAO.closeCurrentSession();
		return course;
	
	}

}
