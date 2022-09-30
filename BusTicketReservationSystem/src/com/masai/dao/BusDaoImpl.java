package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.bean.Bus;
import com.masai.utility.DBUtil;

public class BusDaoImpl implements BusDao {

	@Override
	public String addBus(Bus bus) {
		String message = "Not Inserted...";
		
			try(Connection conn = DBUtil.provideConnection()){
				
//				private int busId;
//				private String busName;
//				private String source;
//				private String destination;
//				private int seatCapacity;
				
				PreparedStatement ps = conn.prepareStatement("insert into bus values(?,?,?,?,?)");
				ps.setInt(1, bus.getBusId());
				ps.setString(2, bus.getBusName());
				ps.setString(3, bus.getSource());
				ps.setString(4, bus.getDestination());
				ps.setInt(5, bus.getSeatCapacity());
				
				int x = ps.executeUpdate();
				
				if(x > 0) {
					message = "Insertion successful..!";
				}
				
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return message;
	}

}
