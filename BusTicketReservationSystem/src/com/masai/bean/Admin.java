package com.masai.bean;

public class Admin {

	private int aId;
	private String aName;
	private String aEmail;
	private String aPass;

	public Admin() {
		
	}

	public Admin(int aId, String aName, String aEmail, String aPass) {
		this.aId = aId;
		this.aName = aName;
		this.aEmail = aEmail;
		this.aPass = aPass;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaPass() {
		return aPass;
	}

	public void setaPass(String aPass) {
		this.aPass = aPass;
	}

	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + ", aEmail=" + aEmail + ", aPass=" + aPass + "]";
	}

	

}
