package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.masai.bean.Bus;
import com.masai.utility.DBUtil;


public class BusDaoImpl implements BusDao {

	@Override
	public String registerBus(Bus bus) {
		String message = "Not Inserted...";
		
			try(Connection conn = DBUtil.provideConnection()){
				
				PreparedStatement ps = conn.prepareStatement("insert into bus values(?,?,?,?,?,?,?)");
				ps.setInt(1, bus.getBusId());
				ps.setString(2, bus.getBusName());
				ps.setString(3, bus.getSource());
				ps.setString(4, bus.getDestination());
				ps.setString(5, bus.getBusType());
				ps.setInt(6, bus.getBusSeats());
				ps.setInt(7, bus.getBusAdminId());
				
				int x = ps.executeUpdate();
				
				if(x > 0) {
					message = "Insertion successful..!";
				}
				
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return message;
	}

//	@Override
//	public List<Bus> getBusDetails() {
//		List<Bus> list_bus = new LinkedList<>();
//		
//		
//		try(Connection conn = DBUtil.provideConnection()) {
//
//			PreparedStatement ps = conn.prepareStatement("select * from bus where source = ? AND destination = ?");
//			
//			Bus bus = new Bus();
//			
//			ps.setString(1, bus.getSource());
//			ps.setString(2, bus.getDestination());
//			
//			ps.executeUpdate();
//			
//			BusDao dao = new BusDaoImpl();
//			List<Bus> busList = dao.getBusDetails();
//			
//			
//			System.out.println(busList);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return list_bus;
//	}

	@Override
	public List<Bus> getBusDetails(String source, String destination) {
		
		List<Bus> list_bus = new LinkedList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from bus where source = ? AND destination = ?");
			
			ps.setString(1, source);
			ps.setString(2, destination);
			
			ResultSet rs = ps.executeQuery();
//			
//			private int busId;
//			private String busName;
//			private String source;
//			private String destination;
//			private String busType;
//			private int busSeats;
//			private int busAdminId;
			
			while (rs.next()) {
				int i = rs.getInt("busId");
				String n = rs.getString("busName");
				String s = rs.getString("source");
				String d = rs.getString("destination");
				String t = rs.getString("busType");
				int c = rs.getInt("busSeats");
				int ai = rs.getInt("busAdminId");
				
				
				Bus bus = new Bus(i,n,s,d,t,c,ai);
				list_bus.add(bus);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list_bus;
	}

}
