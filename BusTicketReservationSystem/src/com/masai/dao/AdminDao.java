package com.masai.dao;

import com.masai.bean.Admin;
import com.masai.bean.Bus;

public interface AdminDao {
	
	public String addAdmin(Admin admin);
	public Bus adminLogin(String userName, String password);
}
