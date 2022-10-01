package com.masai.dao;

import java.util.List;

import com.masai.bean.Bus;
import com.masai.exceptions.BusException;

public interface BusDao {
	
	public String registerBus(Bus bus);
	public List<Bus> getAllBusDetails() throws BusException;
	public List<Bus> getBusDetails(String source, String destination) throws BusException;
	
}
