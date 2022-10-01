package com.masai.bean;

public class Customer {
	
	private String mobile;
	private int busId;
	private String busName;
	private String source;
	private String destination;
	private String busType;
	private int bookSeats;
	private int busAdminId;
	
	
	public Customer() {
		
	}


	public Customer(String mobile, int busId, String busName, String source, String destination, String busType,
			int bookSeats, int busAdminId) {
		super();
		this.mobile = mobile;
		this.busId = busId;
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.busType = busType;
		this.bookSeats = bookSeats;
		this.busAdminId = busAdminId;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public int getBusId() {
		return busId;
	}


	public void setBusId(int busId) {
		this.busId = busId;
	}


	public String getBusName() {
		return busName;
	}


	public void setBusName(String busName) {
		this.busName = busName;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getBusType() {
		return busType;
	}


	public void setBusType(String busType) {
		this.busType = busType;
	}


	public int getBookSeats() {
		return bookSeats;
	}


	public void setBookSeats(int bookSeats) {
		this.bookSeats = bookSeats;
	}


	public int getBusAdminId() {
		return busAdminId;
	}


	public void setBusAdminId(int busAdminId) {
		this.busAdminId = busAdminId;
	}


	@Override
	public String toString() {
		return "Customer [mobile=" + mobile + ", busId=" + busId + ", busName=" + busName + ", source=" + source
				+ ", destination=" + destination + ", busType=" + busType + ", bookSeats=" + bookSeats + ", busAdminId="
				+ busAdminId + "]";
	}


	
	
	
}
