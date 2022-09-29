package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
public class RegisterAdminUseCase {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Name");
		String name = sc.next();
		
		System.out.println("Enter Your UserID");
		String userId = sc.next();
		
		System.out.println("Enter Your Password");
		String password = sc.next();
		
		System.out.println("Enter Your Mobile");
		String mobile = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		Admin admin = new Admin();
		admin.setUserName(name);
		admin.setUserId(userId);
		admin.setPassword(password);
		admin.setMobile(mobile);
		
		
		dao.registerAdmin(admin);
	}
	
}
