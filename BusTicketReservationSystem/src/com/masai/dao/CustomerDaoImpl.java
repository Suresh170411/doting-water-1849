package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.masai.bean.Customer;
import com.masai.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String registerCustomer(Customer customer) {
		String message = "Not inserted..";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?)");
			ps.setString(1, customer.getMobile());
			ps.setInt(2, customer.getBusId());
			ps.setString(3, customer.getBusName());
			ps.setString(4, customer.getSource());
			ps.setString(5, customer.getDestination());
			ps.setString(6, customer.getBusType());
			ps.setInt(7, customer.getBookSeats());
			ps.setInt(8, customer.getBusAdminId());
			
			int x = ps.executeUpdate();
			if (x > 0) {
				message = "Inserted Successfully..";
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}

	

}
