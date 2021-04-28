package com.empwage;

public class EmployeeWageBuilder {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation !!");
		EmployeeComputation ec = new EmployeeComputation();
		ec.computation();
	}

}

class EmployeeComputation {

	int is_Full_Time = 1;
	int is_part_time = 0;
	int wageperHr = 20;
	int FullDayHr = 8;
	int HalfDayHr = 4;
	int maxHr = 100;
	int maxDays = 20;
	int totalEmpHr = 0;
	int totalWorkingHr = 0;
	int totalWorkingDays = 0;
	int FullTimeDay = 0;
	int absent = 0;
	int partTimeDay = 0;

	public void computation() {
		
		double empCheck = Math.floor(Math.random() * 10) % 3;
		if (empCheck == is_Full_Time) {
			System.out.println("Employee is Present FULL Time!!");
			System.out.println("Employee Daily Wage is=" + (wageperHr * FullDayHr));
		} else {
			System.out.println("Employee is Present Part Time..");
			System.out.println("Employee Daily Half_Day Wage is=" + (wageperHr * HalfDayHr));
		}

		/// Using switch Case
		while (totalWorkingHr < maxHr && totalWorkingDays < maxDays) {
			totalWorkingDays++;
			int myCheck = (int) empCheck; // Type Casting
			switch (myCheck) {
			case 0:
				partTimeDay++;
				totalEmpHr = totalEmpHr + HalfDayHr;
				break;
			case 1:
				FullTimeDay++;
				totalEmpHr = totalEmpHr + (FullDayHr / 2);
				break;
			default:
				absent++;
				break;
			}
		}
		int full_time_incom = wageperHr * (FullDayHr * FullTimeDay);
		int part_time_incom = (partTimeDay * (FullDayHr / 2) * wageperHr);

		System.out.println("**************emp wages*********************");
		System.out.println("Full time Days in month:\t" + FullTimeDay);
		System.out.println("Part time Days in month:\t" + partTimeDay);
		System.out.println("Absent Days in month:\t\t" + absent);
		System.out.println("Total working Days in month:\t" + (FullTimeDay + partTimeDay));
		System.out.println("--------------------------------------------");
		System.out.println("Employee Full Time Income=" + full_time_incom);
		System.out.println("Employee part Time Income=" + part_time_incom);
		System.out.println("Total Salary:\t" + (full_time_incom + part_time_incom));
		System.out.println("--------------------------------------------");

	}

}
