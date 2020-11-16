//Mapping is specified here in Employee class using OnetoOne Annotation
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Student")


public class Student{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	private String name;
	private String course;
	@OneToOne(targetEntity=Address.class, cascade=CascadeType.ALL)
	private Address address;
	
	public Student() {}
	public Student(int id, String name , String course, Address address) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address addr) {
		this.address = addr;
	}
}