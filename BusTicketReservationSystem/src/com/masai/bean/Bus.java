package com.masai.bean;

public class Bus {
	
	private int busId;
	private String busName;
	private String source;
	private String destination;
	private int seatCapacity;
	
	
	
	public Bus() {
		
	}


	public Bus(int busId, String busName, String source, String destination, int seatCapacity) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.seatCapacity = seatCapacity;
	}



	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
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

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Bus [busName=" + busName + ", busId=" + busId + ", source=" + source + ", destination=" + destination
				+ ", seatCapacity=" + seatCapacity + "]";
	}
	
	
	
}
