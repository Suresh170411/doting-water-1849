package com.masai.bean;

public class Bus {
	
	private String busName;
	private String source;
	private String destination;
	private int busNo;
	private int seatCapacity;
	
	public Bus() {
		
	}

	public Bus(String busName, String source, String destination, int busNo, int seatCapacity) {
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.busNo = busNo;
		this.seatCapacity = seatCapacity;
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

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Bus [busName=" + busName + ", source=" + source + ", destination=" + destination + ", busNo=" + busNo
				+ ", seatCapacity=" + seatCapacity + "]";
	}
	
	
}
