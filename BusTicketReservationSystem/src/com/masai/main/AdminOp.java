package com.masai.main;

import java.util.Scanner;
import com.masai.operations.AdminOperations;

public class AdminOp {
	
	private static AdminOperations operation = new AdminOperations();

	public static void selectOption() {

		Scanner sc = new Scanner(System.in);

		System.out.println("<--Bus Reservation System-->");
		
		System.out.println("1. Register new bus.");
		System.out.println("2. Remove Full buses.");
		System.out.println("3. Return to Main Menu.");

		int opt = sc.nextInt();
		sc.nextLine();

		switch (opt) {
		case 1:
			operation.addBus();

			AdminOp.selectOption();
			break;

		case 2:
			operation.removeBus();

			AdminOp.selectOption();
			break;

		case 3:
			System.out.println("Returning to main menu.");
			break;

		default:
			break;
		}
	}
}
