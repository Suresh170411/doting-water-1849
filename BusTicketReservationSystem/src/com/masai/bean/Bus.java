package com.masai.bean;

public class Bus {

	private int bId;
	private String bName;
	private String source;
	private String destination;
	private String bType;
	private int bSeats;
	private int bAdminId;
	private String bConPerName;
	private String bConPerMobile;

	public Bus() {
		
	}

	public Bus(int bId, String bName, String source, String destination, String bType, int bSeats, int bAdminId,
			String bConPerName, String bConPerMobile) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.source = source;
		this.destination = destination;
		this.bType = bType;
		this.bSeats = bSeats;
		this.bAdminId = bAdminId;
		this.bConPerName = bConPerName;
		this.bConPerMobile = bConPerMobile;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
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

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public int getbSeats() {
		return bSeats;
	}

	public void setbSeats(int bSeats) {
		this.bSeats = bSeats;
	}

	public int getbAdminId() {
		return bAdminId;
	}

	public void setbAdminId(int bAdminId) {
		this.bAdminId = bAdminId;
	}

	public String getbConPerName() {
		return bConPerName;
	}

	public void setbConPerName(String bConPerName) {
		this.bConPerName = bConPerName;
	}

	public String getbConPerMobile() {
		return bConPerMobile;
	}

	public void setbConPerMobile(String bConPerMobile) {
		this.bConPerMobile = bConPerMobile;
	}

	@Override
	public String toString() {
		return "Bus [bId=" + bId + ", bName=" + bName + ", source=" + source + ", destination=" + destination
				+ ", bType=" + bType + ", bSeats=" + bSeats + ", bAdminId=" + bAdminId + ", bConPerName=" + bConPerName
				+ ", bConPerMobile=" + bConPerMobile + "]";
	}

	

}