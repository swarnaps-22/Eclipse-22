package jpa.service;

import java.util.List;

import jpa.dao.StudentDAO;
import jpa.dao.StudentDAOImpl;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService {

	private StudentDAOImpl myStudentDAO;
	public StudentService()
	{
		myStudentDAO = new StudentDAOImpl();
	}
	
	
	public List<Student> getAllStudents() {
		myStudentDAO.openCurrentSession();
        List<Student> students = myStudentDAO.getAllStudents();
        myStudentDAO.closeCurrentSession();
		return students;
	}

	public List<Student> getStudentByEmail(String semail) {
		myStudentDAO.openCurrentSession();
		List<Student> studentsDetail = myStudentDAO.getStudentByEmail(semail);
		// TODO Auto-generated method stub
		return studentsDetail;
	}

	public boolean validateStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean registerStudentToCourse(String semail, Course course) {
		myStudentDAO.openCurrentSession();
		boolean success = myStudentDAO.registerStudentToCourse(semail,course);
		System.out.println(success);
		// TODO Auto-generated method stub
		return success;
	}

	public List<Course> getStudentCourses(String studentemail) {
		myStudentDAO.openCurrentSession();
		List<Course> studentCourses = myStudentDAO.getStudentCourses(studentemail);
		// TODO Auto-generated method stub
		return studentCourses;
	}

}
