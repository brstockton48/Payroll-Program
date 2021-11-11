//AUTHOR: [Billy Stockton]
//COURSE: CPT 237
//PURPOSE: [The class loads employee files for payroll processing
//and returns values to main]
//STARTDATE: [10/28/2020]
package edu.tridenttech.CPT237.program2;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Payroll {
	private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	private ArrayList<Employee> eeList = new ArrayList<>();
	private ArrayList<DailyHours> dailyHoursList = new ArrayList<>();

	//The Payroll class constructor
	public Payroll() {
	}
	//Load Employee txt file
	public void loadEmployees(String filename){
		File file = new File(filename);
		try {
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String [] fields = line.split(",");
				String employeeID = fields[0];
				String lastName = fields[1];
				String firstName = fields[2];
				String salStr = fields[4];
				Double salary = Double.parseDouble(salStr);
				char type = fields[3].charAt(0);
				Employee employee = null;				
				switch (type) {
				//Hourly Employee
				case 'H': {
					employee = new HourlyEmployee(employeeID, lastName, firstName, salary);
				} break;
				//Exempt Employee
				case 'E': {
					employee = new ExemptEmployee(employeeID, lastName, firstName, salary);
				} break;
				//Contract Employee
				case 'C': {
					employee = new ContractEmployee(employeeID, lastName, firstName, salary);
				} break;
				//Exceptions
				default: {
					System.out.printf("Unknown type: %c%n", type);
				} break;
				}
				//Adds employees to Array List
				if (employee != null) {
					eeList.add(employee);
				}
			}
			input.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	//Load Hours file
	public void loadHours(String filename){

		File file = new File(filename);
		try {
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String [] fields = line.split(",");
				String dateStr = fields[0];
				String employeeID = fields[1];
				String hoursStr = fields[2];
				Double hours = Double.parseDouble(hoursStr);
				//Finds hours for each employee and adds hours
				Employee ee = findEmployeeByID(employeeID);
				if (ee != null) {
					ee.addHours(hours);
				}
				Date date = formatter.parse(dateStr);
				findHoursByDate(date);

				DailyHours dailyHours = findHoursByDate(date);	
				//if (date != null) {
					dailyHours.addHours(hours);
					System.out.printf("%s%.1f",dailyHours.getDate(),dailyHours.getHours());
					
				
				//double currentDailyHours;				
				//	dailyHours.addHours(hours);				
				//	currentDailyHours=dailyHours.getHours();
				//	System.out.println(currentDailyHours);


				//find daily hours in list - assigned to current daily hours
				//if not in list
				//   create a new daily hours
				//   add hours to list
				//   set to be current daily hours
				//endif
				//add hours to current daily hours
				//DailyHours dHours = new DailyHours(date);
				//dailyHours.add(dHours);
				//findHoursbyDate(dailyHours, date, hours);	


			}
			input.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	//Returns Array List to Payroll Manager
	public List<Employee> getEmployeeList() {
		return Collections.unmodifiableList(eeList);
	}
	//This method finds employee by ID
	private Employee findEmployeeByID(String employeeID) {
		for (Employee employee : eeList) {
			if (employeeID.equalsIgnoreCase(employee.getEmployeeID())) {
				return employee;
			}
		}
		return null;
	
	}

	private DailyHours findHoursByDate(Date date) {
		for (DailyHours dateList : dailyHoursList) {
			if (date.equals(dateList.getDate())) {
				System.out.println(dailyHoursList);	
				return dateList;
			}
		}
		return null;
		}
}








