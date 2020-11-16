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
			
			Addres add1=new Addres("Flemingo road","Hyd","Ts","50006");
			Employee emp1=new Employee(123,"bhanu","thandra",50000);
			emp1.setAddress(add1);
			client_1.insertData(emp1,add1);
			Addres add2=new Addres("Flemingo road","Hyd","Ts","50006");
			Employee emp2=new Employee(123,"bhanu","thandra",50000);
			emp1.setAddress(add2);
			client_1.insertData(emp2,add2);
			client_1.DisplayRecords();
		}catch(HibernateException e) {
			System.out.println("Exception is: "+e);
		}

	}
	private void insertData(Employee emp, Addres add) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(emp);
		session.save(add);
		tx.commit();
		System.out.println("Data inserted");
		session.close();
	}


	//Insert Record in db
	public void InsertRecordInDatabase(int id,String firstName,String lastName,int salary) throws HibernateException{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee e1=new Employee(id,firstName,lastName,salary);
		session.save(e1);
		tx.commit();
		session.close();
	}
	
	public void DisplayRecords() throws HibernateException{
		Session session = factory.openSession();
	/*	List empList = session.createQuery("From Employee").list();
		for(Iterator iterator = empList.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.println("First Name: "+emp.getFirstName());
			System.out.println("Last Name: "+emp.getLastName());
			System.out.println("Salary: "+emp.getSalary());
		}*/
		
		//using Criteria and Restrictions
		Criteria cr=session.createCriteria(Employee.class);
		cr.add(Restrictions.gt("salary",800));
		List employees=cr.list();
		
		for(Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.println("First Name: "+emp.getFirstName());
			System.out.println("Last Name: "+emp.getLastName());
			System.out.println("Salary: "+emp.getSalary());
		}
		session.close();
	}
	
	public void DisplayRecords_NativeSQL() throws HibernateException{
		Session session = factory.openSession();
		String sql = "SELECT * FROM hibernate_create_insert_update_delete where salary>8000";
		SQLQuery query = session.createSQLQuery(sql);
		List results = query.list();
		for(Iterator iterator = results.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.println("First Name: "+emp.getFirstName());
			System.out.println("Last Name: "+emp.getLastName());
			System.out.println("Salary: "+emp.getSalary());
		}
		session.close();
	}
	
	public void UpdateRecord(Integer EmployeeId,int salary) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class,EmployeeId);
		employee.setSalary(salary);
		session.update(employee);
		tx.commit();
		session.close();
	}
	
	public void DeleteRecord(Integer EmployeeId) throws HibernateException{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class,EmployeeId);
		session.delete(employee);
		tx.commit();
		session.close();
	}
}
