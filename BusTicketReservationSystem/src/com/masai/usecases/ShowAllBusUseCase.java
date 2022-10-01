package com.masai.usecases;

import java.util.List;

import com.masai.bean.Bus;
import com.masai.dao.BusDao;
import com.masai.dao.BusDaoImpl;

public class ShowAllBusUseCase {
	
	public static void main(String[] args) {
		BusDao dao = new BusDaoImpl();
		
		List<Bus> list = dao.getAllBusDetails();
		
		list.forEach(s->{
			System.out.println("The Bus ID is: "+s.getBusId());
			System.out.println("Bus Name is: "+s.getBusName());
			System.out.println("Bus Route: From-"+s.getSource()+" "+"To-"+s.getDestination());
			System.out.println("Bus Type: "+s.getBusType());
			System.out.println("Seats Capacity: "+s.getBusSeats());
			System.out.println("==================================");
		});
		
	}
	
}
