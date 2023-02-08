package jpa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentDAOImpl implements StudentDAO {

	private Session currentSession;
    
    private Transaction currentTransaction;
 
    public StudentDAOImpl() {
    }
 
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		
		List<Student> listOfStudents= (List<Student> )getCurrentSession().createQuery("from Student").list();
		
		return listOfStudents;
	}

	@Override
	public List<Student> getStudentByEmail(String semail) {
		// TODO Auto-generated method stub
		System.out.println(semail);
		Query q = getCurrentSession().createQuery("from Student s Where s.sEmail=:email");
		q.setParameter("email", semail);
		@SuppressWarnings("unchecked")
		List<Student> DetailsOfStudent = (List<Student> ) q.getResultList();
		System.out.println(DetailsOfStudent);
		return DetailsOfStudent;
	}

	@Override
	public boolean validateStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerStudentToCourse(String semail,Course course) {
		
		
		Student s = getStudentByEmail(semail).get(0);
		
		List<Course> listcourses = s.getStudentCourse();
		for(int i=0; i< listcourses.size();i++)
		{
			if(listcourses.get(i).getCourseId() == course.getCourseId())
			{
				System.out.println("course is already registered ");
				return true;
			}			
		}
			
		//List<Course> listcourses = s.getStudentCourse();
		listcourses.add(course);
		System.out.println("course being added "+course);
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		s.setStudentCourse(listcourses);
		System.out.println("Student details"+ s);
		session.save(s);
		session.flush();
		tx.commit();
		session.close();
		
		
		return true;
	}
		
		//Query q= openCurrentSessionwithTransaction().createQuery("update Student s set s.sCourses=:coursesList where s.sEmail=:email");
		
//		Query q= openCurrentSessionwithTransaction().createQuery("update Student  set sCourses= :listcourses where sEmail=:email");
//		
//		//q.setParameterList("listcourses",listcourses );
//		q.setParameter("email",semail );
//		q.setParameter("listcourses",listcourses );
		
//		int n = q.executeUpdate();
//		if (n>0)
//		{
//			return true;
//		}
//		return false;
		


	@Override
	public List<Course> getStudentCourses(String semail) {
		
		Query q = getCurrentSession().createQuery("from Student s Where s.sEmail=:email ");
		q.setParameter("email", semail);
		
		@SuppressWarnings("unchecked")
		List<Student> CoursesOfStudent = (List<Student> ) q.getResultList();
		
		// TODO Auto-generated method stub
		return CoursesOfStudent.get(0).getStudentCourse();
	}

}

