package com.oajs.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HighSalary {

	public static int highSalary(int sal[]) {
		int high = sal[0];
		for (int i = 0; i < sal.length; i++) {
			if (high < sal[i]) {
				high = sal[i];
			}

		}
		return high;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter  Number of Employe");
			int size = sc.nextInt();
			System.out.println("Enter salries");
			int sal[] = new int[size];

			for (int i = 0; i < sal.length; i++) {
				sal[i] = sc.nextInt();
			}
			System.out.println("Hight Salary");
			System.out.println(highSalary(sal));

		} catch (InputMismatchException e) {
			System.out.println("Please Enter Number");
		}
	}

}
