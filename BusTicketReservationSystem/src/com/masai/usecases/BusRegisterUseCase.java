package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Bus;
import com.masai.dao.BusDao;
import com.masai.dao.BusDaoImpl;

public class BusRegisterUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		private int busId;
//		private String busName;
//		private String source;
//		private String destination;
//		private int seatCapacity;
		
		System.out.println("Enter Bus ID: ");
		int i = sc.nextInt();
		
		System.out.println("Enter Bus Name: ");
		String n = sc.next();
		
		System.out.println("Enter Source: ");
		String s = sc.next();
		
		System.out.println("Enter Destination: ");
		String d = sc.next();
		
		System.out.println("Enter Seat Capacity: ");
		int c = sc.nextInt();
		
		Bus bus = new Bus();
		
		bus.setBusId(i);
		bus.setBusName(n);
		bus.setSource(s);
		bus.setDestination(d);
		bus.setSeatCapacity(c);
		
		BusDao dao = new BusDaoImpl();
		String res = dao.addBus(bus);
		
		System.out.println(res);
		
	}
	
}
