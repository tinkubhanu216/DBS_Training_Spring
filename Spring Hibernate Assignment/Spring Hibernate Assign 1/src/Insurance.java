import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="insurance")
public class Insurance {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int id;
	private int policyNumber;
	private String name;
	private int tensure;
	private int amount;
	
	public Insurance() {}
	public Insurance(int policyNumber,String name,int tensure,int amount) {
		this.policyNumber=policyNumber;
		this.name=name;
		this.tensure=tensure;
		this.amount=amount;
	}
	public Insurance(int id,int policyNumber,String name,int tensure,int amount) {
		this.id=id;
		this.policyNumber=policyNumber;
		this.name=name;
		this.tensure=tensure;
		this.amount=amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber=policyNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getTensure() {
		return tensure;
	}
	public void setTensure(int tensure) {
		this.tensure=tensure;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount=amount;
	}
	

}
