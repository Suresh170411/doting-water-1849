package com.masai.usecases;

import java.util.Scanner;
import com.masai.bean.Customer;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;

public class CustomerUseCase {
	
	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer Name");
		String name = sc.next();
		
		System.out.println("Enter Mobile No");
		int mobile_no = sc.nextInt();
		
		System.out.println("Enter Source");
		String source = sc.next();
		
		System.out.println("Enter Destination");
		String destination = sc.next();
		
		
		CustomerDao dao = new CustomerDaoImpl();
		
		Customer customer = new Customer();
		
		customer.setName(name);
		customer.setMobile(mobile_no);	
		customer.setSource(source);
		customer.setDestination(destination);
		
		
		dao.registerCustomer(customer);
		
	}
	
}
