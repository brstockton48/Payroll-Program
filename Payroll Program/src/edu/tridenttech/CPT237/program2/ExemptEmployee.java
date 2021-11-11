//AUTHOR: [Billy Stockton]
//COURSE: CPT 237
//PURPOSE: [This is the child class Exempt 
//that extends Employee class 
//STARTDATE: [10/28/2020]
package edu.tridenttech.CPT237.program2;

public class ExemptEmployee extends Employee {
	static final double WEEKLY_HOURS = 40.00; 
	public ExemptEmployee(String employeeID, String firstName, String lastName, double salary) {
		super(employeeID, firstName, lastName, salary);
	}		
	//Overides calculatePayAmount to always pay 40 hours * wage regardless of hours
	@Override
	public double calculatePayAmount() {
		return salary*WEEKLY_HOURS;
	}
}