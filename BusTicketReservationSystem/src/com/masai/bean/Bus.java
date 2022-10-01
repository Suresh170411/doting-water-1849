package com.masai.bean;

public class Bus {
	
	private int busId;
	private String busName;
	private String source;
	private String destination;
	private String busType;
	private int busSeats;
	private int busAdminId;
	

	public Bus() {
		
	}


	public Bus(int busId, String busName, String source, String destination, String busType, int busSeats,
			int busAdminId) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.busType = busType;
		this.busSeats = busSeats;
		this.busAdminId = busAdminId;
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


	public int getBusSeats() {
		return busSeats;
	}


	public void setBusSeats(int busSeats) {
		this.busSeats = busSeats;
	}


	public int getBusAdminId() {
		return busAdminId;
	}


	public void setBusAdminId(int busAdminId) {
		this.busAdminId = busAdminId;
	}


	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", source=" + source + ", destination=" + destination
				+ ", busType=" + busType + ", busSeats=" + busSeats + ", busAdminId=" + busAdminId + "]";
	}


	
	
}
