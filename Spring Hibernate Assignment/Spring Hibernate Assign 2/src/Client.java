import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


public class Client {
	
	private static SessionFactory factory;
	
	//Obtain session factory
	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder =  new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object. "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			getSessionFactory();
			Client client_1 = new Client();
			
			//			/Add employees to the database/
			

				client_1.displayRecords();; 
//		
//			 client_1.DisplayRecords_NativeSQL(); 
//			
//			
//			client_1.UpdateRecord(5, 10000);
//			client_1.DisplayRecords();
//			
//			
//		
//			client_1.DeleteRecord(5);
//			client_1.DisplayRecords();
			
			
//			client_1.DisplayRecords2();
			
			Address add1 = new Address ("Flemingo Road", "WAshington DC", "USA", "532");
			Student s1 = new Student(3, "Praveen", "CSE", add1);
			s1.setAddress(add1);
			client_1.insertData(s1, add1);
			
			Address add2 = new Address ("KPHB", "Hyderabad", "IND", "50055");
			Student s2 = new Student (4, "Honey", "ECE", add2);
			s2.setAddress(add2);
			client_1.insertData(s2, add2);
			
		} catch(HibernateException | InterruptedException e) {
			System.out.println("Exception is :"+e);
		}
		
	}
	
	/* Insert into table*/
	public void insertData(Student stuObj, Address addObj)
	{
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(stuObj);
		session.save(addObj);
		tx.commit();
		
		System.out.println("Both Employee and Address are inserted in the databae...");
		session.close();
	}
//	/Display from table/
	public void displayRecords() throws InterruptedException {
		Session session = factory.openSession();
		List empList = (List) session.createQuery("FROM Student").list();
		for (Iterator iterator=empList.iterator(); iterator.hasNext(); ) {
			Student s = (Student) iterator.next();
			System.out.println("Student ID :"+s.getId());
			System.out.println("Student name :"+s.getName());
			System.out.println("Student Course :"+s.getCourse());
			
			Address add = s.getAddress();
			System.out.println("Address");
			System.out.println("\tStreet: " + add.getStreet());
			System.out.println("\tCity: "+add.getCity());
			System.out.println("\tState: "+add.getState());
			System.out.println("\tZipcode: : "+add.getZipcode());
		}
		session.close();
	}

}