package com.masai.dao;

import java.util.List;
import com.masai.bean.Customer;
import com.masai.exceptions.CustomerException;

public interface CustomerDao {
	
	public String addCustomer(Customer customer);

	public List<Customer> getAllBookings(String mobile) throws CustomerException;

	public int getBusID(String mob, String source, String destination);

	public Customer getCustomer(String source, String destination, String mobile, int selectedSeats);
	
}
