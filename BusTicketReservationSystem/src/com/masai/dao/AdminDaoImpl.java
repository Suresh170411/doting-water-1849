package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.masai.bean.Admin;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String registerAdmin(Admin admin) {
		
		String message = "Not Inserted ..!";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("insert into admin values(?,?,?,?)");

			ps.setString(1, admin.getUserName());
			ps.setString(2, admin.getUserId());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getMobile());

			
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
