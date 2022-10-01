package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.masai.bean.Bus;
import com.masai.exceptions.BusException;
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
		if(list_bus.size() == 0)
			throw new BusException("No Records found..");
		
		return list_bus;
		
	}



	@Override
	public List<Bus> getAllBusDetails() throws BusException {
		
		List<Bus> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from bus");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int i = rs.getInt("busId");
				String n = rs.getString("busName");
				String s = rs.getString("source");
				String d = rs.getString("destination");
				String t = rs.getString("busType");
				int c = rs.getInt("busSeats");
				int ai = rs.getInt("busAdminId");
				
				
				Bus bus = new Bus(i,n,s,d,t,c,ai);
				list.add(bus);
			}
			
			
			
		}catch (BusException b) {
			System.out.println(b.getMessage());
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		if(list.size() == 0)
			throw new BusException("No Records found..");
		
		return list;
	}



	@Override
	public String bookTickets(String source, String destination, int tickets) throws BusException {
		
		String message = "Please Provide valid input";
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE bus set busSeats = busSeats - ? where source = ? AND destination = ?");
			
			ps.setString(2, source);
			ps.setString(3, destination);
			ps.setInt(1, tickets);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Ticket booked Successfully..";
			}
//			
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				int t = rs.getInt(tickets);
//				message = "Ticket booked successfully..";
//			}
			
		} catch (SQLException e) {
			int availabeTickets = this.availableTickets(source, destination);
			if(availabeTickets == 0) {
				throw new BusException("Bus is full Try another bus..");
			}else {
				throw new BusException("available tickcets"+availabeTickets);
			}
		}
		
		return message;
		
	}



	@Override
	public int availableTickets(String source, String destination) throws BusException {
		int x = 0;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select busSeats from bus where source=? AND destination=?");
			
			
			ps.setString(1, source);
			ps.setString(2, destination);
			
			ResultSet rs = ps.executeQuery();
			
//			if(n > 0) {
//				Bus bus = new Bus();
//				x = bus.getBusSeats();
//			}
			if (rs.next()) {
				x = rs.getInt("busSeats");
				
			}
			
		} catch (SQLException e) {
			throw new BusException("No seats available for this bus..");
		}
		
		return x;
	}

}
