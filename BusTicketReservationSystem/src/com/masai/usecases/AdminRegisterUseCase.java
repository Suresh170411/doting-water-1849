package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AdminRegisterUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Admin ID:");
		int i = sc.nextInt();
		
		System.out.println("Enter Admin Name: ");
		String n = sc.next();
		
		System.out.println("Enter Admin Email: ");
		String e = sc.next();
		
		System.out.println("Enter Admin Password: ");
		String p = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		Admin admin = new Admin();
		admin.setAdminId(i);
		admin.setAdminName(n);
		admin.setAdminEmail(e);
		admin.setAdminPassword(p);
		
		String result = dao.registerAdmin(admin);
		
		System.out.println(result);
	}
	
}
