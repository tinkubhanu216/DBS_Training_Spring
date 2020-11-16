import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import oracle.net.TNSAddress.Address;

@Entity
@Table(name="EMPLOYEE_one_to_one")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	@OneToOne(targetEntity=Addres.class,cascade=CascadeType.ALL)
	private Addres address;
	
	public Employee() {}
	public Employee(int id,String firstName,String lastName,int salary) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.salary=salary;
	}
	public Employee(int id,String firstName,String lastName,int salary,Addres address) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.salary=salary;
		this.address=address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public Addres getAddress() {
		return address;
	}
	public void setAddress(Addres address2) {
		this.address=address2;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	
	
}
