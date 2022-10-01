package com.masai.usecases;

import java.util.Scanner;
import com.masai.bean.Customer;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;


public class CustomerRegisterUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Mobile Number: ");
		String m = sc.next();
		
		System.out.println("Enter Customer ID: ");
		int i = sc.nextInt();
		
		System.out.println("Enter Customer Name: ");
		String n = sc.next();
		
		System.out.println("Enter Source: ");
		String s = sc.next();
		
		System.out.println("Enter Destination: ");
		String d = sc.next();
		
		System.out.println("Enter Bus Type");
		String t = sc.next();
		
		System.out.println("Enter Number of Tickets: ");
		int ti = sc.nextInt();
		
		
		System.out.println("Enter Bus Admin ID: ");
		int ad = sc.nextInt();
		
		
		Customer customer = new Customer();
		customer.setMobile(m);
		customer.setBusId(i);
		customer.setBusName(n);
		customer.setSource(s);
		customer.setDestination(d);
		customer.setBusType(t);
		customer.setBookSeats(ti);
		customer.setBusAdminId(ad);
		
		
		CustomerDao dao = new CustomerDaoImpl();
		String res = dao.registerCustomer(customer);
		
		System.out.println(res);
	}
	
}
