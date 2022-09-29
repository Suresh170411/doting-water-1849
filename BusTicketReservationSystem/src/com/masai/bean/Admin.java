package com.masai.bean;

public class Admin {
	
	private String userName;
	private String userId;
	private String password;
	private String mobile;
	
	public Admin() {
		
	}

	public Admin(String userName, String userId, String password, String mobile) {
		this.userName = userName;
		this.userId = userId;
		this.password = password;
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", userId=" + userId + ", password=" + password + ", mobile=" + mobile
				+ "]";
	}
	
	
}
