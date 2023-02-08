package jpa.entitymodels;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	private String cName;
	private String cInstructorName;
//	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "Student_Course", joinColumns = {
//			@JoinColumn(name = "sEmail") }, inverseJoinColumns = {
//					@JoinColumn(name = "cId") })
//    private List<Course> studentCourse;
	public Course()
	{
		
	}
	public Course(Integer cid,String cName,String insName)
	{
		super();
		this.cId = cid;
		this.cName = cName;
		this.cInstructorName = insName;
		
	}
	public Integer getCourseId() {
		return cId;
	}
	public void setCourseId(Integer courseId) {
		this.cId = courseId;
	}
	public String getCourseName() {
		return cName;
	}
	public void setCourseName(String courseName) {
		this.cName = courseName;
	}
	public String getInstructorName() {
		return cInstructorName;
	}
	public void setInstructorName(String instructorName) {
		this.cInstructorName = instructorName;
	}
	public String toString()
	{
		return  cId +"  "+cName+" "+cInstructorName;
	}
	
//	public List<Course> getstudentCourse()
//	{
//		return studentCourse;
//	}
//	public void setstudentCourse(List<Course>  studentc)
//	{
//		this.studentCourse =studentc;
//	}

}
