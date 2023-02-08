package jpa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentCourseDAOImpl implements StudentCourseDAO{

private Session currentSession;
    
    private Transaction currentTransaction;
 
    public StudentCourseDAOImpl() {
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
    
    public List<Course> GetAllCourses() {
		
		Query q = (getCurrentSession().createQuery("from Course"));
		@SuppressWarnings("unchecked")
		List<Course> listOfCourses= (List<Course> ) q.getResultList();
		System.out.println(listOfCourses);
		return listOfCourses;
	}

    
	@Override
	public List<Course> getAllStudentCourses(String semail) {
			
		//Session session = getCurrentSession();
		Query q = getCurrentSession().createQuery("from Student s Where s.sEmail=:email");
		q.setParameter("email", semail);
		@SuppressWarnings("unchecked")
		List<Student> DetailsOfStudent = (List<Student> ) q.getResultList();
		System.out.println(DetailsOfStudent);
		
		List<Course> sCourseList = DetailsOfStudent.get(0).getStudentCourse();
		
		List<Integer> listOfCourseId = new ArrayList<Integer>();
		for(int i=0; i<sCourseList.size();++i)
		{
			listOfCourseId.add(sCourseList.get(i).getCourseId());
		}
		
		
		List<Course> q1 = GetAllCourses();
		
		List<Course> listOfCourseToReturn = new ArrayList<Course> ();
		for(int i =0; i<q1.size();i++)
		{
			if(listOfCourseId.contains(q1.get(i).getCourseId()))
			{
				listOfCourseToReturn.add(q1.get(i));
			}
		}
		
		return listOfCourseToReturn;
	}

}















