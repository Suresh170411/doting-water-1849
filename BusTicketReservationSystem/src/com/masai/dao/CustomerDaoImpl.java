package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.bean.Customer;
import com.masai.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String addCustomer(Customer customer) {
		
		String message = "Not Insetred..!";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into customer values(?,?,?,?,?,?)");

			
			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getMobile());
			ps.setString(4, customer.getSource());
			ps.setString(5, customer.getDestination());
			ps.setInt(6, customer.getTicketNo());
			
			int x = ps.executeUpdate();
			if (x > 0) {
				message = "Inserted record successful..";
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
		
	}

}
