package jpa.entitymodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table
//@NamedQueries({
//	@NamedQuery( name="CoursesByStudent", query="Select sEmail,cId,cName from Student left join Course on Student= :email")
//})

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length = 200)
	private String sEmail;
	private String sName;
	private String sPass;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course", joinColumns = {
			@JoinColumn(name = "sEmail") }, inverseJoinColumns = {
					@JoinColumn(name = "cId") })
	private List<Course> sCourses ;
	
	public Student()
	{
		
	}
	public Student(String stdEmail,String stdName,String stdPassword,List<Course> sCourses )
	{
		super();
		this.sEmail = stdEmail;
		this.sName = stdName;
		this.sPass = stdPassword;
		this.sCourses = sCourses;
	}
	public String getStudentEmail() {
		return sEmail;
	}
	public void setStudenttEmail(String email) {
		this.sEmail = email;
	}
	public String getStudentdName() {
		return sName;
	}
	public void setStudentName(String name) {
		this.sName = name;
	}
	public String getStudentPassword() {
		return sPass;
	}
	public void setStudentPassword(String password) {
		this.sPass = password;
	}
	public List<Course> getStudentCourse() {
		return sCourses;
	}
	public void setStudentCourse(List<Course> courses) {
		this.sCourses = courses;
	}
	public String toString()
	{
		return sEmail +" "+sName+" "+sPass+" registered course is"+ sCourses;
	}
	

}
