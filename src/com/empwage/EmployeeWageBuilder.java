package com.empwage;

public class EmployeeWageBuilder {

	//declaring variables
	public final static int IS_FULL_TIME = 1;
	public final static int IS_PART_TIME = 0;
	private final String company;
	private final int empRatePerHr;
	private final int workingDayPerMonth;
	private final int maxHrInMonth;
	private int totalEmpWage;

	//parameterized constructor calling
	public EmployeeWageBuilder(String company, int empRatePerHr, int workingDayPerMonth, int maxHrInMonth) {
		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.workingDayPerMonth = workingDayPerMonth;
		this.maxHrInMonth = maxHrInMonth;
	}
    //method implementation
	public void empWageCalculation() {
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDay = 0;
		// Using switch Case
		while (totalEmpHrs < maxHrInMonth && totalWorkingDay < workingDayPerMonth) {
			totalWorkingDay++;
			int myCheck = (int) Math.floor(Math.random() * 10) % 3;
			switch (myCheck) {
			case IS_PART_TIME:
				empHrs = 4;
				break;
			case IS_FULL_TIME:
				empHrs = 8;
				break;
			default:
				empHrs = 0;
				break;
			}
			totalEmpHrs += empHrs;
			System.out.println("Total Working Days: " + totalWorkingDay + " " + "Total EMP Hours:" + totalEmpHrs);
		}
		totalEmpWage = totalEmpHrs * empRatePerHr;	
	}
	//to string method for displaying purpose
	public String toString() {
		return "[Total Emp Wage for: "+company+" is: " + totalEmpWage + "]";
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation !!");
		EmployeeWageBuilder dmart = new EmployeeWageBuilder("D-MART", 20, 2, 10);//initialize object with parameter
		EmployeeWageBuilder jio = new EmployeeWageBuilder("JIO", 20, 2, 10);//initialize object with parameter
		dmart.empWageCalculation();//Method calling
		System.out.println(dmart);//displaying dmart object
		jio.empWageCalculation();//Method calling
		System.out.println(jio);//displaying dmart object
		
	}
}
