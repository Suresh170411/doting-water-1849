package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AdminRegisterUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Admin ID:");
		String i = sc.next();
		
		System.out.println("Enter Admin User Name: ");
		String n = sc.next();
		
		System.out.println("Enter Admin Password: ");
		String p = sc.next();
		
		System.out.println("Enter Admin Mobile Number: ");
		String m = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		Admin admin = new Admin();
		admin.setUserId(i);
		admin.setUserName(n);
		admin.setPassword(p);
		admin.setMobile(m);
		
		String result = dao.addAdmin(admin);
		
		System.out.println(result);
	}
	
}
