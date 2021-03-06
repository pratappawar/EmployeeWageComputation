package com.empwage;
import java.util.ArrayList;
import java.util.HashMap;

//defining interface computeEmpWage with empty body
interface ComputeEmpWage {

	public void addCompanyEmpWage(String company, int empRatePerHr, int workingDayPerMonth, int maxHrInMonth);
	public void empWageCalculation();
	public int getTotalEmpWage(String company);
}

//Declared class
class CompanyEmpWage {
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

//Employee Wage Builder Class implements interface
public class EmployeeWageBuilder implements ComputeEmpWage {
	// Variable Declaration
	public final static int IS_FULL_TIME = 1;
	public final static int IS_PART_TIME = 0;
	private ArrayList<CompanyEmpWage> companyWageList; // ArrayList Declaration for Multiple companies of type CompanyEmpWage
	private HashMap<String,CompanyEmpWage>companyEmpWageMap=new HashMap<String,CompanyEmpWage>();

	// Default constructor of EmployeeWageBuilder class 
	public EmployeeWageBuilder() {
		companyWageList = new ArrayList<CompanyEmpWage>();
	}
	// Add companyEmpWage method to add company and passing parameter list
	public void addCompanyEmpWage(String company, int empRatePerHr, int workingDayPerMonth, int maxHrInMonth) {
		CompanyEmpWage companyWage = new CompanyEmpWage(company, empRatePerHr, workingDayPerMonth, maxHrInMonth);//passing parameter to constructor
		companyWageList.add(companyWage);//adding Company wage object in the arraylist.
		companyEmpWageMap.put(company, companyWage);// adding key as a company and value as companyWage
	}
    //ArrayList Display Method  
	public void empWageCalculation() {
		for (int i = 0; i < companyWageList.size(); i++) {
			CompanyEmpWage companyWage = companyWageList.get(i);
			companyWage.setTotalEmpWage(empWageCalculation(companyWage));
			System.out.println("Arraylist Element:"+companyWage);
		}
	}
	
	//get the Total Wage when queried by Company
	public int getTotalEmpWage(String company) {	
		return companyEmpWageMap.get(company).totalEmpWage;
	}
	
    //Employee Wage Calculation method to calculate the Total EmpWage
	public int empWageCalculation(CompanyEmpWage companyWage) {
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
			System.out.println("Total Working Days: " + totalWorkingDay + "  " + "Total EMP Hours:" + totalEmpHrs);
			int dailyWage=empHrs*companyWage.empRatePerHr;
			System.out.println("Daily Employee Wage:= "+dailyWage);//Daily Employee wage Along with Total EmpWage
		}
		return totalEmpHrs * companyWage.empRatePerHr;             //return total emp wage
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation !!");
		ComputeEmpWage empwagebuilder = new EmployeeWageBuilder(); // interface reference referencing class EmployeeWageBuilder object
		empwagebuilder.addCompanyEmpWage("D-MART", 20, 2, 10);
		empwagebuilder.addCompanyEmpWage("JIO", 20, 2, 10);
		empwagebuilder.addCompanyEmpWage("Vivo", 25, 5, 8);
		empwagebuilder.addCompanyEmpWage("DELL", 30, 10, 7);
		empwagebuilder.empWageCalculation();
		System.out.println("----------------------------------------------------------");
		System.out.println("Total wage for D-MART Company:"+empwagebuilder.getTotalEmpWage("D-MART"));//getting Total Emp Wage for querying company
	}
}
