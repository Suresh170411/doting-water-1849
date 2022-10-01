package com.masai.main;

import java.util.Scanner;

import com.masai.operations.AdminOperations;

public class Main {
	
	private static AdminOperations operation = new AdminOperations();

	public static void selectOption() {

		System.out.println("<--BUS TICKET RESERVATION SYSTEM-->");
		System.out.println("-----------------------------------");
		
		System.out.println("1. For Adding/Removing bus.");
		System.out.println("2. View all buses.");
		System.out.println("3. Book a ticket.");
		System.out.println("4. Cancel a ticket.");
		System.out.println("5. Exit");

		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		scan.nextLine();

		switch (choice) {

		case 1:
			AdminOp.selectOption();

			Main.selectOption();
			break;

		case 2:
			operation.viewBuses();

			Main.selectOption();
			break;

		case 3:

			System.out.print("Enter source location : ");
			String source = scan.nextLine();

			System.out.print("Enter destination : ");
			String destination = scan.nextLine();

			System.out.print("Enter no of tickets : ");
			int tickets = scan.nextInt();

			scan.nextLine();
			System.out.print("Enter your mobile no : ");
			String mobileNo = scan.nextLine();

			operation.book(source, destination, tickets, mobileNo);

			Main.selectOption();
			break;

		case 4:
			System.out.print("Enter your Mobile No :");
			String mob = scan.nextLine();

			operation.getBookings(mob);

			Main.selectOption();
			break;

		case 5:
			System.out.println("Thank You...!!!");
			break;

		default:
			Main.selectOption();
			break;
		}
	}
}
