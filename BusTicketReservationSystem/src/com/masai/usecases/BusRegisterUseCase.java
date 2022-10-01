package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Bus;
import com.masai.dao.BusDao;
import com.masai.dao.BusDaoImpl;

public class BusRegisterUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter Bus ID: ");
		int i = sc.nextInt();
		
		System.out.println("Enter Bus Name: ");
		String n = sc.next();
		
		System.out.println("Enter Source: ");
		String s = sc.next();
		
		System.out.println("Enter Destination: ");
		String d = sc.next();
		
		System.out.println("Enter Bus Type: ");
		String t = sc.next();
		
		System.out.println("Enter Seat Capacity: ");
		int c = sc.nextInt();
		
		System.out.println("Enter Bus Admin ID: ");
		int a = sc.nextInt();
		
		Bus bus = new Bus();
		
		bus.setBusId(i);
		bus.setBusName(n);
		bus.setSource(s);
		bus.setDestination(d);
		bus.setBusType(t);
		bus.setBusSeats(c);
		bus.setBusAdminId(a);
		
		BusDao dao = new BusDaoImpl();
		String res = dao.registerBus(bus);
		
		System.out.println(res);
		
	}
	
}
