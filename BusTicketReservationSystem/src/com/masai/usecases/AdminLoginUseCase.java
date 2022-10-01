package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AdminLoginUseCase {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Admin Email: ");
		String e = sc.next();
		
		System.out.println("Enter Admin Password: ");
		String p = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		Admin admin = dao.loginAdmin(e, p);
	}
	
}
