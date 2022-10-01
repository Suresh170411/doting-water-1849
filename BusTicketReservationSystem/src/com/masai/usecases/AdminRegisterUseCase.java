package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AdminRegisterUseCase {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter admin details : ");

		System.out.println("Enter admin ID : ");
		int id = sc.nextInt();

		sc.nextLine();
		System.out.println("Enter admin name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter admin email : ");
		String email = sc.nextLine();

		System.out.println("Enter admin password : ");
		String pass = sc.nextLine();
		
		sc.close();
		
		AdminDao dao = new AdminDaoImpl();
		
		Admin admin = new Admin();
		
		admin.setaId(id);
		admin.setaName(name);
		admin.setaEmail(email);
		admin.setaPass(pass);
		
		String result = dao.registerAdmin(admin);

		System.out.println(result);

	}
	
}
