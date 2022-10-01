package com.masai.bean;

public class Customer {

	private String mobile;
	private int bId;
	private String bName;
	private String source;
	private String destination;
	private String bType;
	private int bookedSeats;
	private int bAdminId;
	private String bConPerName;
	private String bConPerMobile;

	public Customer() {
		
	}

	public Customer(String mobile, int bId, String bName, String source, String destination, String bType,
			int bookedSeats, int bAdminId, String bConPerName, String bConPerMobile) {
		super();
		this.mobile = mobile;
		this.bId = bId;
		this.bName = bName;
		this.source = source;
		this.destination = destination;
		this.bType = bType;
		this.bookedSeats = bookedSeats;
		this.bAdminId = bAdminId;
		this.bConPerName = bConPerName;
		this.bConPerMobile = bConPerMobile;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
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
		return "Customer [mobile=" + mobile + ", bId=" + bId + ", bName=" + bName + ", source=" + source
				+ ", destination=" + destination + ", bType=" + bType + ", bookedSeats=" + bookedSeats + ", bAdminId="
				+ bAdminId + ", bConPerName=" + bConPerName + ", bConPerMobile=" + bConPerMobile + "]";
	}

	

}
