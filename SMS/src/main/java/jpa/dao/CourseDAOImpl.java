package jpa.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class CourseDAOImpl implements CourseDAO{

	private Session currentSession;
    
    private Transaction currentTransaction;
 
    public CourseDAOImpl() {
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
	public List<Course> getAllCourses() {
	@SuppressWarnings("unchecked")
	List<Course> listOfCourses= (List<Course> )getCurrentSession().createQuery("from Course").list();
		
		return listOfCourses;
	}

	
	public Course GetCourseById(Integer cId) {
		
		Query q = (getCurrentSession().createQuery("from Course c where c.cId=:id"));
		q.setParameter("id", cId);
		@SuppressWarnings("unchecked")
		List<Course> listOfCourses= (List<Course> ) q.getResultList();
		System.out.println(listOfCourses);
		return listOfCourses.get(0);
	}

}