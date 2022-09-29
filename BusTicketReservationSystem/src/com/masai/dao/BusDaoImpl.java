package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.masai.bean.Bus;
import com.masai.utility.DBUtil;

public class BusDaoImpl implements BusDao{

	@Override
	public String addBus(Bus bus) {
		
		String message = "Not inserted..!";
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps =  conn.prepareStatement("insert into bus values(?,?,?,?,?)");

			ps.setString(1, bus.getBusName());
			ps.setString(2, bus.getSource());
			ps.setString(3, bus.getDestination());
			ps.setInt(4, bus.getBusNo());
			ps.setInt(5, bus.getSeatCapacity());

			
			int x = ps.executeUpdate();
			if (x > 0) {
				message = "Record Inserted successfully..!";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return message;
		
	}

}
