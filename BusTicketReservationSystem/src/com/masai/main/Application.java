package com.masai.main;

import com.masai.usecases.AdminLoginUseCase;

public class Application {
	
public static void main(String[] args) {
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("WELCOME TO BUS TICKET RESERVATION SYSTEM");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		
		System.out.println("Login to the System (ADMIN)");
		
		AdminLoginUseCase.loginAsAdmin();
		
	}
	
}
