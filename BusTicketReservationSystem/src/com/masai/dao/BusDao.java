package com.masai.dao;

import java.util.List;

import com.masai.bean.Bus;
import com.masai.exceptions.BusException;

public interface BusDao {
	
	public String registerNewBus(Bus bus);
	
	public List<Bus> getEmptyBuses() throws BusException;

	public String removeBusById(int bId);

	public List<Bus> getAllBusDetails() throws BusException;

	public Bus bookTicket(String source, String destination, int tickets, String mobileNo) throws BusException;

	public int noOfTicketsAval(String source, String destination);

	public Bus getBus(String source, String destination);
	
}
