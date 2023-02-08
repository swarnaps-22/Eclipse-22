package com.sms.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Student;



public class studentController {
	public void createStudent()
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		Student studentdetails = new Student();
		t.commit();
		System.out.println("student successfully saved");
		factory.close();
		session.close();
	}

}
