package com.masai.utility;

import java.sql.Connection;

public class DBDemo {
	
	public static void main(String[] args) {
		
		Connection conn = DBUtil.provideConnection();
		
		if(conn != null) {
			System.out.println("Conncted to the DataBase..");
		}else {
			System.out.println("Connection Failed ..!");
		}
		
	}
	
}
