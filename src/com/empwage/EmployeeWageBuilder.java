package com.empwage;

public class EmployeeWageBuilder {

	public final static int IS_FULL_TIME = 1;
	public final static int IS_PART_TIME = 0;

	public static void empWageCalculation(String company, int empRatePerHr, int workingDayPerMonth, int maxHrInMonth) {
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
		System.out.println("Total Emp Wage For Company:-->" + company + " is:" + totalEmpHrs * empRatePerHr);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation !!");
		empWageCalculation("D-MART", 20, 2, 10);
		empWageCalculation("JIO", 20, 2, 10);
	}
}
