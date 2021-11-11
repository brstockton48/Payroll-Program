package edu.tridenttech.CPT237.program2;

import java.util.Date;

public class DailyHours {
	//Non-Constant Class Attributes
	Date date;
	double hours=0.0;
	double pay=0.0;
	//The PurchaseItem class constructor
	public DailyHours(Date date) {
		super();
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public double getHours() {
		return hours;
	}
	public double getPay() {
		return pay;
	}
	
	public void addHours(double hours){
		this.hours += hours;
		
	}
	
	
	
	

}
