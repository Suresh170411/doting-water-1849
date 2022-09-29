package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.bean.Customer;
import com.masai.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String registerCustomer(Customer customer) {
		
		String message = "Not instered..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps =  conn.prepareStatement("insert into customer values(?,?,?,?)");

			ps.setString(1, customer.getName());
			ps.setLong(2, customer.getMobile());
			ps.setString(3, customer.getSource());
			ps.setString(4, customer.getDestination());
			

			
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
