//AUTHOR: [Billy Stockton]
//COURSE: CPT 237
//PURPOSE: [This is the child class Hourly 
//that extends Employee class 
//STARTDATE: [10/28/2020]
package edu.tridenttech.CPT237.program2;

public class HourlyEmployee extends Employee {
	static final double OVERTIME_CUTOFF = 40.00; 
	final double OT_WAGE=1.5;
	public HourlyEmployee(String employeeID, String firstName, String lastName, double salary) {
		super(employeeID, firstName, lastName, salary);
	}
	//Overides calculatePayAmount to time and a half for hours in excess of 40
	@Override
	public double calculatePayAmount() {
		double pay=0.0;
		if(hours<=OVERTIME_CUTOFF) {
			pay=salary*hours;
		}
		else {
			pay=((hours-OVERTIME_CUTOFF)*(salary*OT_WAGE))+(OVERTIME_CUTOFF*salary);
		}
		return pay;
	}
	//Overrides OTIndicator in Employee to indicate overtime for hourly employees when over 40 
	@Override
	public String getOTIndicator() {
		String OTIndicator="";
		if(hours>OVERTIME_CUTOFF) {
			OTIndicator="Y";
		}
		else {
			OTIndicator="N";
		}
		return OTIndicator;
	}
}
