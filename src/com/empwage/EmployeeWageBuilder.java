package com.empwage;

public class EmployeeWageBuilder {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation !!");
		
		int is_Full_Time=1;
		int wageperHr=20;
		int FullDayHr=8;
		int HalfDayHr=4;
		double empCheck=Math.floor(Math.random()*10)%2;
		if(empCheck==is_Full_Time) {
			System.out.println("Employee is Present..");
			System.out.println("Employee Daily Wage is="+(wageperHr*FullDayHr));
		}
		else {
			System.out.println("Employee Daily Half_Day Wage is="+(wageperHr*HalfDayHr));
		}
			
	}
		
}


