package com.oajs.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AverageSalaryOfEmp {

	public static void main(String[] args) {

		//srinivas
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the No of Employee");
			try {
			int size = sc.nextInt();
			System.out.println("Enter Employe Salarys");
			
			int num[] = new int[size];
			double total =0;
			for(int i=0; i<num.length;i++) {
				num[i]= sc.nextInt();
				total = total+num[i];
			}
			double avrg = total/num.length;
			System.out.println(avrg);
			}
			catch (InputMismatchException e) {
				System.out.println("Please Enter Numer");

			}
	}
}
