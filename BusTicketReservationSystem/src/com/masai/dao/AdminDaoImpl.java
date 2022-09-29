package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String registerAdmin(
			String busName, 
			String busRoute, 
			String AC, 
			int seatCapacity, 
			String arrival,
			String departure, 
			String userId, 
			String password) {
		
		String message = "Not Inserted ..!";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("insert into admin values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1, busName);
			ps.setString(2, busRoute);
			ps.setString(3, AC);
			ps.setInt(4, seatCapacity);
			ps.setString(5, arrival);
			ps.setString(6, departure);
			ps.setString(7, userId);
			ps.setString(8, password);
			
			int x = ps.executeUpdate();
			if (x > 0) {
				message = "Record Inserted successfully..!";
			}
			
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		return message;
	}

}
