package com.masai.dao;

public interface AdminDao {
	
	public String registerAdmin(String busName, String busRoute, String AC, int seatCapacity, String arrival, String departure, String userId, String password);
	
	
}
