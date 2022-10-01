package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.masai.bean.Bus;
import com.masai.exceptions.BusException;
import com.masai.utility.DBUtil;


public class BusDaoImpl implements BusDao {

	

	public List<Bus> getEmptyBuses() throws BusException {

		List<Bus> buses = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from buses where bSeats = 0");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
			int i = rs.getInt("bId");
			String n = rs.getString("bName");
			String s = rs.getString("source");
			String d = rs.getString("destination");
			String t = rs.getString("bType");
			int c = rs.getInt("bSeats");
			int ai = rs.getInt("bAdminId");
			String bn = rs.getString("bConPerName");
			String m = rs.getString("bConPerMobile");

			Bus bus = new Bus(i,n,s,d,t,c,ai,bn,m);
				
				buses.add(bus);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (buses.size() == 0)
			throw new BusException("No bus found with 0 seats for this Search.");

		return buses;

	}

	public String removeBusById(int bId) {
		String message = "Bus not found with ID " + bId;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("delete from buses where bId = ? AND bSeats = 0");

			ps.setInt(1, bId);

			int x = ps.executeUpdate();

			if (x > 0)
				message = " Bus with ID " + bId + " removed from database.";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public String registerNewBus(Bus bus) {
		String message = "Enterd data is Already Present.";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into buses values (?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, bus.getbId());
			ps.setString(2, bus.getbName());
			ps.setString(3, bus.getSource());
			ps.setString(4, bus.getDestination());
			ps.setString(5, bus.getbType());
			ps.setInt(6, bus.getbSeats());
			ps.setInt(7, bus.getbAdminId());
			ps.setString(8, bus.getbConPerName());
			ps.setString(9, bus.getbConPerMobile());

			int x = ps.executeUpdate();

			if (x > 0)
				message = bus.getbName() + " Bus Registered Succesfully...";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	
	
	@Override
	public List<Bus> getAllBusDetails() throws BusException {
		List<Bus> buses = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from buses");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int i = rs.getInt("bId");
				String n = rs.getString("bName");
				String s = rs.getString("source");
				String d = rs.getString("destination");
				String t = rs.getString("bType");
				int c = rs.getInt("bSeats");
				int ai = rs.getInt("bAdminId");
				String bn = rs.getString("bConPerName");
				String m = rs.getString("bConPerMobile");

				Bus bus = new Bus(i,n,s,d,t,c,ai,bn,m);

				buses.add(bus);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (buses.size() == 0)
			throw new BusException("No Buses are Available right Now..");

		return buses;
	}

	public Bus bookTicket(String source, String destination, int tickets, String mobileNo) throws BusException {

		Bus bus = new Bus();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement pst = conn.prepareStatement("update buses set bSeats = bSeats - ? where source = ? AND destination = ?");

			pst.setInt(1, tickets);
			pst.setString(2, source);
			pst.setString(3, destination);

			int x = pst.executeUpdate();

			if (x > 0) {

				PreparedStatement ps = conn.prepareStatement("select * from buses where source = ? AND destination = ?");

				ps.setString(1, source);
				ps.setString(2, destination);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					int i = rs.getInt("bId");
					String n = rs.getString("bName");
					String s = rs.getString("source");
					String d = rs.getString("destination");
					String t = rs.getString("bType");
					int c = rs.getInt("bSeats");
					int ai = rs.getInt("bAdminId");
					String bn = rs.getString("bConPerName");
					String m = rs.getString("bConPerMobile");

					bus = new Bus(i,n,s,d,t,c,ai,bn,m);

				}
			}

		} catch (SQLException e) {
			int avalTickets = this.noOfTicketsAval(source, destination);
			if (avalTickets == 0)
				throw new BusException("This Bus is already Full. Please select another Bus");
			else
				throw new BusException("Ticket not available.\nOnly " + avalTickets + " tickets avaliable right now.");
		}

		return bus;
	}

	@Override
	public int noOfTicketsAval(String source, String destination) {
		int avalTicket = 0;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select bSeats from buses where source = ? AND destination = ?");

			ps.setString(1, source);
			ps.setString(2, destination);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				avalTicket = rs.getInt("bSeats");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return avalTicket;
	}

	@Override
	public Bus getBus(String source, String destination) {
		Bus bus = new Bus();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from buses where source = ? AND destination = ?");

			ps.setString(1, source);
			ps.setString(2, destination);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int i = rs.getInt("bId");
				String n = rs.getString("bName");
				String s = rs.getString("source");
				String d = rs.getString("destination");
				String t = rs.getString("bType");
				int c = rs.getInt("bSeats");
				int ai = rs.getInt("bAdminId");
				String bn = rs.getString("bConPerName");
				String m = rs.getString("bConPerMobile");

				bus = new Bus(i,n,s,d,t,c,ai,bn,m);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return bus;
	}
}
