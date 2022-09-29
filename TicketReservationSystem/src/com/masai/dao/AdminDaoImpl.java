package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String registerAdmin(String name, String userId, String password) {
		
		String message = "Log in Unsuccessful..";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("insert into admin values(?,?,?)");
			
			
			ps.setString(1, name);
			ps.setString(2, userId);
			ps.setString(3, password);
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Insertion is successful ..";
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return message;
	}
	
}
