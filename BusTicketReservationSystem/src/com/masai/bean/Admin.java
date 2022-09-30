package com.masai.bean;

public class Admin {
	
	private String userId;
	private String userName;
	private String password;
	private String mobile;
	
	public Admin() {
		
	}


	public Admin(String userId, String userName, String password, String mobile) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + ", userId=" + userId + ", mobile=" + mobile
				+ "]";
	}

	
	
	
}
