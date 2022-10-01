package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.BusDao;
import com.masai.dao.BusDaoImpl;
import com.masai.exceptions.BusException;

public class ConfirmTicketUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter source: ");
		String s = sc.next();
		
		System.out.println("Enter Destination: ");
		String d = sc.next();
		
		System.out.println("Enter Number of Tickets : ");
		int n = sc.nextInt();
		
		BusDao dao = new BusDaoImpl();
		
		String str = dao.bookTickets(s, d, n);
		
		System.out.println(str);
		
		
	}
	
}
