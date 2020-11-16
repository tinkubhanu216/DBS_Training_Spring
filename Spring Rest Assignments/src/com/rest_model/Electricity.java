package com.rest_model;

import java.util.Date;

public class Electricity {
	private int meter_no;
	private int consumed_units;
	private int costperunit;
	private int amount;
	private Date lastdate;
	
	public Electricity(int meter_no,int consumed_units,int costperunit,int amount,Date lastdate){
		this.meter_no=meter_no;
		this.consumed_units=consumed_units;
		this.costperunit=costperunit;
		this.amount=amount;
		this.lastdate=lastdate;
	}
	
	public void setMeter_no(int meter_no) {
		this.meter_no=meter_no;
	}
	public int getMeter_no() {
		return meter_no;
	}
	
	public void setConsumed_units(int consumed_units) {
		this.consumed_units=consumed_units;
	}
	public int getConsumed_units() {
		return consumed_units;
	}
	
	public void setCostperunit(int costperunit) {
		this.costperunit=costperunit;
	}
	public int getCostperunit() {
		return costperunit;
	}
	
	public void setAmount(int amount) {
		this.amount=amount;
	}
	public int getAmount() {
		return amount;
	}
	
	public void setLastdate(Date lastdate) {
		this.lastdate=lastdate;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public String toString() {
		return "meter_no: "+meter_no+" consumed_units: "+consumed_units+" costperunit: "+costperunit+" amount: "+ amount+" lastdate: "+lastdate;
	}
	
}
