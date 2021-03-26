package com.oajs.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeAge {

	public static void empAge(int age[]) {
		int temp = 0;
		for (int i = 0; i < age.length; i++) {

			for (int j = i + 1; j < age.length; j++) {

				if (age[i] > age[j]) {
					temp = age[i];
					age[i] = age[j];
					age[j] = temp;

				}
			}

		}
		for (int i : age)
			System.out.println(i);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
		System.out.println("Enter Number Of Employes");
		int size = sc.nextInt();

		System.out.println("Enter Employe Age");
		int age[] = new int[size];

		for (int i = 0; i < age.length; i++) {
			age[i] = sc.nextInt();
		}

		empAge(age);
	}catch (InputMismatchException e) {

		System.out.println("Please Enter Number");
	
	}
}
}
