package com.sms.controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;




public class courseController {
	public void createCourse()
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		Course coursedetails = new Course();
		t.commit();
		System.out.println("course successfully saved");
		factory.close();
		session.close();
	}
	 

}
