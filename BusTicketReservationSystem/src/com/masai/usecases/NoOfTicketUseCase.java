package com.masai.usecases;

import java.util.Scanner;
import com.masai.dao.BusDao;
import com.masai.dao.BusDaoImpl;
import com.masai.exceptions.BusException;

public class NoOfTicketUseCase {
	
	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Enter Source : ");
			String s = sc.next();
			
			System.out.println("Enter Destination: ");
			String d = sc.next();
			
			
			BusDao dao = new BusDaoImpl();
			
			int x = dao.availableTickets(s, d);
			
			System.out.println("Number of Seats available is "+x);
			
		} catch (BusException e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
}
