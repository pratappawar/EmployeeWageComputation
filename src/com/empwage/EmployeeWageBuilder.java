package com.empwage;

class CompanyEmpWage {
	//Variable Declaration
	public final String company;
	public final int empRatePerHr;
	public final int workingDayPerMonth;
	public final int maxHrInMonth;
	public int totalEmpWage;

    // parameterized constructor calling
	public CompanyEmpWage(String company, int empRatePerHr, int workingDayPerMonth, int maxHrInMonth) {
		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.workingDayPerMonth = workingDayPerMonth;
		this.maxHrInMonth = maxHrInMonth;
	}

	// setters to set total Employee wage
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	// to string method to display purpose
	public String toString() {
		return "[Total Emp Wage for: " + company + " is: " + totalEmpWage + "]";
	}
}
//Employee Wage Builder Class
public class EmployeeWageBuilder {
	// Variable Declaration
	public final static int IS_FULL_TIME = 1;
	public final static int IS_PART_TIME = 0;
	private int noOfCompany = 0;
	private CompanyEmpWage[] companyWageArray; // Array Declaration for Multiple companies

	// Default constructor of EmployeeWageBuilder class and array initialization
	public EmployeeWageBuilder() {
		companyWageArray = new CompanyEmpWage[5];
	}

	// Add companyEmpWage method to add company and passing parameter list
	private void addCompanyEmpWage(String company, int empRatePerHr, int workingDayPerMonth, int maxHrInMonth) {
		companyWageArray[noOfCompany] = new CompanyEmpWage(company, empRatePerHr, workingDayPerMonth, maxHrInMonth);
		noOfCompany++;
	}
    //display array
	private void empWageCalculation() {
		for (int i = 0; i < noOfCompany; i++) {
			companyWageArray[i].setTotalEmpWage(empWageCalculation(companyWageArray[i]));
			System.out.println(companyWageArray[i]);
		}
	}
    //implementation of empWageCalculation method 
	private int empWageCalculation(CompanyEmpWage companyWage) {
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDay = 0;
		// Using switch Case
		while (totalEmpHrs < companyWage.maxHrInMonth && totalWorkingDay < companyWage.workingDayPerMonth) {
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
		return totalEmpHrs * companyWage.empRatePerHr;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation !!");
		EmployeeWageBuilder empwagebuilder = new EmployeeWageBuilder();
		empwagebuilder.addCompanyEmpWage("D-MART", 20, 2, 10);
		empwagebuilder.addCompanyEmpWage("JIO", 20, 2, 10);
		empwagebuilder.addCompanyEmpWage("Vivo", 25,5, 8);
		empwagebuilder.empWageCalculation();//Method calling
	}
}
