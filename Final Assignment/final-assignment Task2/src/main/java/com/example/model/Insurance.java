package com.example.model;

import javax.persistence.Column;
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
	@Column
	private int policyno;
	@Column
	private String name;
	@Column
	private int tensure;
	@Column
	private int amount;
	
	
	public int getPolicyNumber() {
		return policyno;
	}
	public void setPolicyNumber(int policyno) {
		this.policyno=policyno;
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
