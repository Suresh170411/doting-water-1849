package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class RegisterAdminUseCase {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Bus Name: ");
		String busName = sc.next();
		
		System.out.println("Enter the Bus Route: ");
		String busRoute = sc.next();
		
		System.out.println("A/C");
		String AC = sc.next();
		
		System.out.println("Enter Seat Capacity: ");
		int seatCapacity = sc.nextInt();
		
		System.out.println("Enter Arrival Time");
		String arrival = sc.next();
		
		System.out.println("Enter Departure Time: ");
		String departure = sc.next();
		
		System.out.println("Enter Your User ID: ");
		String userId = sc.next();
		
		System.out.println("Enter Your Password: ");
		String password = sc.next();
		
		
		AdminDao dao = new AdminDaoImpl();
		
		String result = dao.registerAdmin(busName, busRoute, AC, seatCapacity, arrival, departure, userId, password);
		
		System.out.println(result);
	}
	
}
