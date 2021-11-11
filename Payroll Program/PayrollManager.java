//AUTHOR: [Billy Stockton]
//COURSE: CPT 237
//PURPOSE: [This program calculates payroll for Hourly, Contract
//and Exempt Employees]
//STARTDATE: [10/28/2020]
package edu.tridenttech.CPT237.program2;

public class PayrollManager {

	public static void main(String[] args) {
		Payroll payroll = new Payroll();
		//Calls Method to Load Employee List
		payroll.loadEmployees("EmployeeList.txt");
		//Calls Method to Load daily log
		payroll.loadHours("dailyLog.txt");
		displayEmployeeList(payroll);

	}
	//Void Methods
	//Displays EE List
	public static void displayEmployeeList(Payroll payroll) {
		double totalPay=0.0;
		String otIndicator="N";

		System.out.printf("%-8s%-10s%-16s%-9s%-9s%-8s%-6s%n","ID","Last","First","Wage","Hours","Pay","OT");
		for (Employee employee : payroll.getEmployeeList()) {
			otIndicator=employee.getOTIndicator();
			totalPay += employee.calculatePayAmount();
			System.out.printf("%-8s%-10s%-12s%9.2f%9.2f%9.2f%5s%n", employee.getEmployeeID(),employee.getLastName(),employee.getFirstName(),
					employee.getSalary(),employee.getHours(),employee.calculatePayAmount(),otIndicator);
		}
		System.out.printf("%-5s%52.2f","Total",totalPay);
	}
}


