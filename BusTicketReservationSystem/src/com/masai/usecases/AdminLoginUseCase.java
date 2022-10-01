package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Admin;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exceptions.AdminException;
import com.masai.main.Application;
import com.masai.main.Main;

public class AdminLoginUseCase {
	
	public static void loginAsAdmin() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Admin Email ");
		String email = sc.nextLine();

		System.out.println("Enter Admin Password ");
		String password = sc.nextLine();

		AdminDao aDao = new AdminDaoImpl();

		try {
			Admin admin = aDao.loginAdmin(email, password);

			System.out.println("Login Successful... ");
			System.out.println("Welcome to Main Menu "+ admin.getaName());

			Main.selectOption();

		} catch (AdminException e) {
			System.out.println(e.getMessage() + "\nEnter Details again\n");
			Application.main(null);
		}

	}
	
}
