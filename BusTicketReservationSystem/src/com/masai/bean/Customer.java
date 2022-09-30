package com.masai.bean;

public class Customer {
	
	private int customerId;
	private String name;
	private int mobile;
	private String source;
	private String destination;
	private int ticketNo;
	
	public Customer() {
		
	}


	public Customer(int customerId, String name, int mobile, String source, String destination, int ticketNo) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobile = mobile;
		this.source = source;
		this.destination = destination;
		this.ticketNo = ticketNo;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
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

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", customerId=" + customerId + ", mobile=" + mobile + ", source=" + source
				+ ", destination=" + destination + ", ticketNo=" + ticketNo + "]";
	}
	
	
}
