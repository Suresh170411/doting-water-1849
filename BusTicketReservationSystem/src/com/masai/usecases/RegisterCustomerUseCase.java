package com.masai.usecases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.bean.Customer;
import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.exceptions.CustomerException;
import com.masai.utility.DBUtil;


public class RegisterCustomerUseCase {
	
	public static void main(String[] args) {


		
		try {
			CustomerDao dao = new CustomerDaoImpl();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Mobile Number");
			String m = sc.next();
			
			System.out.println("Enter Bus ID");
			int cid = sc.nextInt();
			
			System.out.println("Enter Bus Name");
			String bn = sc.next();
			
			System.out.println("Enter Source");
			String s = sc.next();
			
			System.out.println("Enter Destination");
			String d = sc.next();
			
			System.out.println("Enter bus type (AC / NONAC) ");
			String t = sc.next();
			
			System.out.println("Enter No of seat booked..");
			int sb = sc.nextInt();
			
			System.out.println("Enter admin ID");
			int aid = sc.nextInt();
			
			System.out.println("Get contact name");
			String cn = sc.next();
			
			System.out.println("Enter contact mobile");
			String mob = sc.next();
			
			Customer c = new Customer();
			
			
//			dao.addCustomer(customer);
			
		}catch (CustomerException e) {
			e.printStackTrace();
		}
	}
	
}
