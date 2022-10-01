package com.masai.usecases;


import java.util.List;
import java.util.Scanner;

import com.masai.bean.Bus;
import com.masai.dao.BusDao;
import com.masai.dao.BusDaoImpl;
import com.masai.exceptions.BusException;


public class ShowBusDetailsUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter source :");
		String s = sc.next();
		
		System.out.println("Enter destination: ");
		String d = sc.next();
		
		BusDao dao = new BusDaoImpl();
		
		try {
			List<Bus> bus_list = dao.getBusDetails(s, d);
			
			bus_list.forEach(val->{
				System.out.println("Bus Id: "+val.getBusId());
				System.out.println("Bus Name : "+val.getBusName());
				System.out.println("Source : "+val.getSource());
				System.out.println("Destination: "+val.getDestination());
				System.out.println("Bus Type: "+val.getBusType());
				System.out.println("Seat Capacity: "+val.getBusSeats());
				System.out.println("====================================");
			});
		}catch (BusException b) {
			b.getMessage();
		}
		
	}
	
}
