//AUTHOR: [Billy Stockton]
//COURSE: CPT 237
//PURPOSE: [This is the parent class for employees and
//provides employee detail]
//STARTDATE: [10/28/2020]
package edu.tridenttech.CPT237.program2;

public class Employee {
	//Non-Constant Class Attributes
	String employeeID="";
	String firstName="";
	String lastName="";
	double salary=0.0;
	double hours=0.0;

	//The DailyHours class constructor
	public Employee(String employeeID, String firstName, String lastName, double salary) {
		this.employeeID=employeeID;
		this.firstName=firstName;
		this.lastName=lastName;
		this.salary=salary;				
	}
	//Returns EE ID
	public String getEmployeeID() {
		return employeeID;
	}
	//Returns firstName
	public String getFirstName() {
		return firstName;
	}
	//Returns lastName
	public String getLastName() {
		return lastName;
	}
	//Returns salary (Hourly Wage)
	public double getSalary() {
		return salary;
	}
	//Returns hours
	public double getHours() {
		return hours;
	}
	//Accumulates hours
	public void addHours(double hours){
		this.hours += hours;

	}
	//Calculates pay
	public double calculatePayAmount() {
		return hours*salary;
	}
	//Indicates whether EE earned OT
	public String getOTIndicator() {
		String OTIndicator="N";
		return OTIndicator;
	}
}
