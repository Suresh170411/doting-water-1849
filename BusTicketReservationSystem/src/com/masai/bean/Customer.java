package com.masai.bean;

public class Customer {
	
	private String name;
	private long mobile;
	private String source;
	private String destination;
	
	public Customer() {
		
	}

	public Customer(String name, long mobile, String source, String destination) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.source = source;
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
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

	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobile=" + mobile + ", source=" + source + ", destination=" + destination
				+ "]";
	}
	
	
}
