package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Admin;
import com.masai.bean.Bus;
import com.masai.exceptions.BusException;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String registerAdmin(Admin admin) {
		String message = "Not Registered...!";
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into admin values(?,?,?,?)");
			
			ps.setInt(1, admin.getAdminId());
			ps.setString(2, admin.getAdminName());
			ps.setString(3, admin.getAdminEmail());
			ps.setString(4, admin.getAdminPassword());
			
			int x = ps.executeUpdate();
			if (x>0) {
				message = "Registration succussful..";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return message;
	}

	@Override
	public Admin loginAdmin(String adminEmail, String adminPassword) {
		Admin admin = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from admin where adminEmail = ? AND adminPassword = ?");
			
			ps.setString(1, adminEmail);
			ps.setString(2, adminPassword);
			
//			int x = ps.executeUpdate();
			ResultSet rs =  ps.executeQuery();

			
			if (rs.next()) {
				System.out.println("Login Successful..");
			}else {
				System.out.println("Invalid credentials...!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return admin;
	}

	
	
}
