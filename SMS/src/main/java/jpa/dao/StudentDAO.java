package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
	List<Student> getAllStudents();

	List<Student> getStudentByEmail(String semail);

	boolean validateStudent();

	boolean registerStudentToCourse(String semail,Course course);

	List<Course> getStudentCourses(String semail);

}
