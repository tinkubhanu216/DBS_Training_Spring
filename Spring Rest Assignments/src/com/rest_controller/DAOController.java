package com.rest_controller;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.rest_model.User;

public class DAOController {
	private static SessionFactory factory;
	
	DAOController(){
		try {
			getSessionFactory();
		}catch(HibernateException e) {
			System.out.println("Exception is: "+e);
		}
	}
	
	public static void getSessionFactory() {
		try {
			Configuration conf=new Configuration().configure();
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory=conf.buildSessionFactory(builder.build());
		}catch(Throwable ex) {
			System.out.println("Failed to create session factory oject"+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public String validateUser(String username,String password) {
		Session session=factory.openSession();
		System.out.println(username+" and "+password);
        
		List usrList = session.createQuery("From User").list();
		for(Iterator iterator = usrList.iterator(); iterator.hasNext();) {
			User usr = (User) iterator.next();
			if (usr.getUsername().equals(username) && usr.getPassword().equals(password)) {
				return "Valid User";
			}
		}
		session.close();
		return "Invalid User";
	}

}
