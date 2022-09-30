package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.bean.Admin;
import com.masai.bean.Bus;
import com.masai.exceptions.BusException;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String addAdmin(Admin admin) {
		
		String message = "Not Inserted..";
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into admin values(?,?,?,?)");
			
			ps.setString(1,admin.getUserId());
			ps.setString(2,admin.getUserName());
			ps.setString(3,admin.getPassword());
			ps.setString(4,admin.getMobile());
			
			int x = ps.executeUpdate();
			
			if (x > 0) {
				message = "Successfully inserted Admin data";
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return message;
		
	}

	@Override
	public Bus adminLogin(String userName, String password) {
		
		Bus bus = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from bus where admin.userId='1100' AND admin.password='12345'");
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("BUS Details");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return bus;
		
	}
	
}
