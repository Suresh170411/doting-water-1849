package com.masai.usecases;

import java.util.Scanner;
import com.masai.bean.Customer;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;


public class CustomerRegisterUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer ID: ");
		int i = sc.nextInt();
		
		System.out.println("Enter Customer Name: ");
		String n = sc.next();
		
		System.out.println("Enter Mobile Number: ");
		int m = sc.nextInt();
		
		System.out.println("Enter Source: ");
		String s = sc.next();
		
		System.out.println("Enter Destination: ");
		String d = sc.next();
		
		System.out.println("Enter Number of Tickets: ");
		int t = sc.nextInt();
		
		
		Customer customer = new Customer();
		customer.setCustomerId(i);
		customer.setName(n);
		customer.setMobile(m);
		customer.setSource(s);
		customer.setDestination(d);
		customer.setTicketNo(t);
		
		CustomerDao dao = new CustomerDaoImpl();
		String res = dao.addCustomer(customer);
		
		System.out.println(res);
	}
	
}
