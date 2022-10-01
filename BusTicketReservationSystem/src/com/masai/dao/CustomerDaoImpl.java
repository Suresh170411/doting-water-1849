package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Bus;
import com.masai.bean.Customer;
import com.masai.exceptions.CustomerException;
import com.masai.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {
	
	@Override
	public String addCustomer(Customer customer) {
		String message = "Not inserted..!";
		
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into customers values (?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, customer.getMobile());
			ps.setInt(2, customer.getbId());
			ps.setString(3, customer.getbName());
			ps.setString(4, customer.getSource());
			ps.setString(5, customer.getDestination());
			ps.setString(6, customer.getbType());
			ps.setInt(7, customer.getBookedSeats());
			ps.setInt(8, customer.getbAdminId());
			ps.setString(9, customer.getbConPerName());
			ps.setString(10, customer.getbConPerMobile());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Customers added Successfully...";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
	}
	
	

	

	@Override
	public List<Customer> getAllBookings(String mobile) throws CustomerException {
		List<Customer> cList = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from customers where mob = ?");

			ps.setString(1, mobile);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String m = rs.getString("mobile");
				int i = rs.getInt("bId");
				String n = rs.getString("bName");
				String s = rs.getString("source");
				String d = rs.getString("destination");
				String t = rs.getString("bType");
				int bs = rs.getInt("bookedSeats");
				int ai = rs.getInt("bAdminId");
				String cn = rs.getString("bConPerName");
				String cm = rs.getString("bConPerMobile");

				Customer customer = new Customer(m,i,n,s,d,t,bs,ai,cn,cm);

				cList.add(customer);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (cList.size() == 0)
			throw new CustomerException("No bookings available for mobile no : " + mobile);

		return cList;
	}

	public int getBusID(String mob, String source, String destination) {
		int bId = 0;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select bId from customers where mobile = ? AND source = ? AND destination = ?");

			ps.setString(1, mob);
			ps.setString(2, source);
			ps.setString(3, destination);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				bId = rs.getInt("bId");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return bId;
	}

	@Override
	public Customer getCustomer(String source, String destination, String mobile, int selectedSeats) {
		Customer customer = new Customer();

		BusDao dao = new BusDaoImpl();

		Bus bus = dao.getBus(source, destination);

		customer.setMobile(mobile);
		customer.setbId(bus.getbId());
		customer.setbName(bus.getbName());
		customer.setSource(bus.getSource());
		customer.setDestination(bus.getDestination());
		customer.setbType(bus.getbType());
		customer.setBookedSeats(selectedSeats);
		customer.setbAdminId(bus.getbAdminId());
		customer.setbConPerName(bus.getbConPerName());
		customer.setbConPerMobile(bus.getbConPerMobile());

		return customer;
	}

}
