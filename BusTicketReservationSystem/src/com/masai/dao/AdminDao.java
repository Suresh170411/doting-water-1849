package com.masai.dao;

import com.masai.bean.Admin;
import com.masai.bean.Bus;

public interface AdminDao {
	
	public String registerAdmin(Admin admin);
	public Admin loginAdmin(String adminEmail, String adminPassword);
}
