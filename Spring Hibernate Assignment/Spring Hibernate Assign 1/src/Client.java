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


public class Client {
	private static SessionFactory factory;
	
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
	

	public static void main(String[] args) {
		try {
			getSessionFactory();
			Client client_1=new Client();
//			client_1.InsertRecordInDatabase(123,"bhanu","thandra",10000);
//			client_1.UpdateRecord(123, 4000);
//			client_1.DeleteRecord(123);
//			client_1.DisplayRecords_NativeSQL();
//			client_1.DisplayRecords();
//			System.out.println("success");
			
			Insurance inc=new Insurance(1234,"bhanu",12,10000);
			client_1.insertData(inc);
			client_1.DisplayRecords();
		}catch(HibernateException e) {
			System.out.println("Exception is: "+e);
		}

	}
	private void insertData(Insurance inc) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(inc);
		tx.commit();
		System.out.println("Data inserted");
		session.close();
	}


	//Insert Record in db
	public void InsertRecordInDatabase(int policyNumber,String name,int tensure,int amount) throws HibernateException{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Insurance inc=new Insurance(policyNumber,name,tensure,amount);
		session.save(inc);
		tx.commit();
		session.close();
	}
	
	public void DisplayRecords() throws HibernateException{
		Session session = factory.openSession();
		List insList = session.createQuery("From Insurance").list();
		for(Iterator iterator = insList.iterator(); iterator.hasNext();) {
			Insurance ins = (Insurance) iterator.next();
			System.out.println("Policy Number: "+ins.getPolicyNumber());
			System.out.println("Name: "+ins.getName());
			System.out.println("Tensure: "+ins.getTensure());
			System.out.println("Amount: "+ins.getAmount());
		}
		
		//using Criteria and Restrictions
//		Criteria cr=session.createCriteria(Insurance.class);
//		cr.add(Restrictions.gt("amount",800));
//		List insurances=cr.list();
//		
//		for(Iterator iterator = insurances.iterator(); iterator.hasNext();) {
//			Insurance ins = (Insurance) iterator.next();
//			System.out.println("Policy Number: "+ins.getPolicyNumber());
//			System.out.println("Name: "+ins.getName());
//			System.out.println("Tensure: "+ins.getTensure());
//			System.out.println("Amount: "+ins.getAmount());
//		}
		session.close();
	}
	
	public void DisplayRecords_NativeSQL() throws HibernateException{
		Session session = factory.openSession();
		String sql = "SELECT * FROM hibernate_create_insert_update_delete where amount>8000";
		SQLQuery query = session.createSQLQuery(sql);
		List results = query.list();
		for(Iterator iterator = results.iterator(); iterator.hasNext();) {
			Insurance ins = (Insurance) iterator.next();
			System.out.println("Policy Number: "+ins.getPolicyNumber());
			System.out.println("Name: "+ins.getName());
			System.out.println("Tensure: "+ins.getTensure());
			System.out.println("Amount: "+ins.getAmount());
		}
		session.close();
	}
	
	public void UpdateRecord(Integer InsuranceId,int amount) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance insurance = (Insurance) session.get(Insurance.class,InsuranceId);
		insurance.setAmount(amount);
		session.update(insurance);
		tx.commit();
		session.close();
	}
	
	public void DeleteRecord(Integer InsuranceId) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Insurance insurance = (Insurance) session.get(Insurance.class,InsuranceId);
		session.delete(insurance);
		tx.commit();
		session.close();
	}
}
