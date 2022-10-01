package com.masai.operations;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Bus;
import com.masai.bean.Customer;
import com.masai.dao.BusDao;
import com.masai.dao.BusDaoImpl;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exceptions.BusException;
import com.masai.exceptions.CustomerException;

public class AdminOperations {
	
	
	// <-------------------------------------------- VIEW ALL BUSES ---------------------------------------------------->
	
	public static void viewBuses() {

		BusDao bus_dao = new BusDaoImpl();

		try {
			List<Bus> buses = bus_dao.getAllBusDetails();

			buses.forEach(b -> {

				System.out.println("Bus Name : " + b.getbName());
				System.out.println("Bus type : " + b.getbType());
				System.out.println("Seats : " + b.getbSeats());
				System.out.println("Bus Route : " + b.getSource() + "-" + b.getDestination());

				System.out.println("++++++++++++++++++++++++++++++++++++++++++");
			});

		} catch (BusException e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	
	// <---------------------------------------------- ADD BUS FUNCTION -------------------------------------------------->
	
	
	public static void addBus() {

		Scanner sc = new Scanner(System.in);

		System.out.println("\nEnter Bus Details : \n");
		System.out.println("Enter Combination of Bus ID & Bus Name as mentioned below : ");
		
		System.out.println("BUS Id = 1100 AND Name = BANADURGA");
		System.out.println("BUS Id = 1200 AND Name = KALYANI");
		System.out.println("BUS Id = 1300 AND Name = MONALISHA");
		System.out.println("BUS Id = 1400 AND Name = KADAMBINI");
		System.out.println("BUS Id = 1500 AND Name = MOHAPATRA");
		System.out.println("BUS Id = 1600 AND Name = GAJANANA");
		System.out.println("BUS Id = 1700 AND Name = SRIGANESH");
		System.out.println("BUS Id = 1800 AND Name = SAYONARA");
		System.out.println("BUS Id = 1900 AND Name = KAPILASH");
		System.out.println("BUS Id = 2000 AND Name = SRIRAMJI");

		System.out.println("Enter Bus Id : ");
		int i = sc.nextInt();

		System.out.println("Enter Bus Name (As shown on the ID with Name): ");
		String n = sc.next();

		System.out.println("Enter Source : ");
		String s = sc.next();

		System.out.println("Enter Destination : ");
		String d = sc.next();

		System.out.println("Enter Bus Type (AC / NONAC) : ");
		String t = sc.next();

		System.out.println("Enter Seats Available : ");
		int c = sc.nextInt();


		System.out.println("Enter Bus Administrator ID (110 OR 210): ");
		int aid = sc.nextInt();

		sc.nextLine();
		System.out.println("Enter Passenger Name : ");
		String cm = sc.next();

		System.out.println("Enter Passenger's Contact No. : ");
		String cn = sc.next();
		sc.close();
		
		BusDao bDao = new BusDaoImpl();

		Bus bus = new Bus(i, n, s, d, t, c,aid, cm, cn);

		String result = bDao.registerNewBus(bus);

//		System.out.println(result);
	}
	
	
	
	// <----------------------------------- BOOK TICKET FUNCTION --------------------------------------------------->
	
	
	public static void book(String source, String destination, int tickets, String mobileNo) {

		BusDao bDao = new BusDaoImpl();

		try {
			Bus bus = bDao.bookTicket(source, destination, tickets, mobileNo);

			String bName = bus.getbName();
			String route = bus.getSource() + "-" + bus.getDestination();
			int seats = tickets;
			String n = bus.getbConPerName();
			String m = bus.getbConPerMobile();

			int busId = AdminOperations.addCustomerRecord(source, destination, mobileNo, seats);
			System.out.println("------------------------------");
			System.out.println("Your Booking is Confirmed...");
			System.out.println("-------------------------------");
			System.out.println("See Your Ticket Here..\n");
			System.out.println("Bus ID : " + busId);
			System.out.println("Bus Name : " + bName);
			System.out.println("Bus Route : " + route);
			System.out.println("Booked Seats : " + seats);
			System.out.println(" Passenger Name : " + n);
			System.out.println("Contact No : " + m+"\n");

		} catch (BusException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	// <----------------------------- ADD CUSTOMER DETAILS INTO DATABASE FUNCTION ------------------------------------------->
	

	public static int addCustomerRecord(String source, String destination, String mobile, int selectedSeats) {

		CustomerDao cDao = new CustomerDaoImpl();

		Customer customer = cDao.getCustomer(source, destination, mobile, selectedSeats);

		cDao.addCustomer(customer);

		int busId = cDao.getBusID(mobile, source, destination);

		return busId;
	}

	public static void getBookings(String mobile) {

		CustomerDao dao = new CustomerDaoImpl();

		List<Customer> list = null;

		try {
			list = dao.getAllBookings(mobile);

			System.out.println("\nBooking Contanct No. : " + mobile);

			for (Customer c : list) {

				System.out.println("Bus Name : " + c.getbName());
				System.out.println("Seats Booked : " + c.getBookedSeats());
				System.out.println("Bus Route : " + c.getSource() + "-" + c.getDestination());
				System.out.println("Mobile No : " + c.getbConPerMobile());
				System.out.println("++++++++++++++++++++++++++++++++++++++++++");
			}

		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	// <-------------------------------------- DISPLAY ALL BUSES FUNCTION ------------------------------------------->
	
	
	public static int displayBuses() {

		int total = 0;

		BusDao bDao = new BusDaoImpl();

		try {
			List<Bus> buses = bDao.getEmptyBuses();

			total = buses.size();

			System.out.println("Showing all the filled buses : ");
			buses.forEach(b -> {
				int bId = b.getbId();
				String bName = b.getbName();
				String bRoute = b.getSource() + "-" + b.getDestination();
				int avalSeats = b.getbSeats();
				System.out.println("Bus ID : " + bId);
				System.out.println("Name : " + bName);
				System.out.println("Route : " + bRoute);
				System.out.println("Seats : " + avalSeats);
				System.out.println("Status : FULLY OCCUPIED");
				System.out.println("+++++++++++++++++++++++++");
			});

		} catch (BusException e) {
			System.out.println(e.getMessage());
		}

		return total;
	}
	
	

	// <------------------------------------------- REMOVE BUS FUNCTION ------------------------------------------>
	
	
	public static void removeBus() {

		int totalBuses = AdminOperations.displayBuses();

		if (totalBuses == 0) {
			return;
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter bus ID : ");
		int bId = sc.nextInt();
		sc.close();
		
		BusDao bDao = new BusDaoImpl();

		String message = bDao.removeBusById(bId);
		System.out.println(message);

		if (totalBuses == 0)
			return;
		else
			AdminOperations.removeBus();
	}
	
	
	
}
