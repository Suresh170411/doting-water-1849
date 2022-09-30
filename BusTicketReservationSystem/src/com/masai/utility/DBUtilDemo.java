package com.masai.utility;

import java.sql.Connection;

public class DBUtilDemo {
	public static void main(String[] args) {

		Connection conn= DBUtil.provideConnection();
		
		System.out.println(conn);
		
	}
}


