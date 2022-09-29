package com.masai.usecases;

import java.util.Scanner;
import com.masai.bean.Bus;
import com.masai.dao.BusDao;
import com.masai.dao.BusDaoImpl;

public class AddBusUseCase1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Bus Name");
		String bus_name = sc.next();
		
		System.out.println("Enter Source");
		String source = sc.next();
		
		System.out.println("Enter Destination");
		String destination = sc.next();
		
		System.out.println("Enter Bus No");
		int bus_no = sc.nextInt();
		
		System.out.println("Enter Seat Capacity");
		int seat_capacity = sc.nextInt();
		
		BusDao dao = new BusDaoImpl();
		
		Bus bus = new Bus();
		
		bus.setBusName(bus_name);
		bus.setSource(source);
		bus.setDestination(destination);
		bus.setBusNo(bus_no);
		bus.setSeatCapacity(seat_capacity);
		
		
		dao.addBus(bus);
	}
}
