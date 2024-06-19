package com.ilp04.entity;

public class Customer {
	private int customerCode;
	private String customerFirstname;
	private String customerLastnamek;
	private String address;
	private long phoneNo;
	private long aadharNo;
	
	public Customer(int customerCode, String customerFirstname, String customerLastnamek, String address, long phoneNo,
			long aadharNo) {
		this.customerCode = customerCode;
		this.customerFirstname = customerFirstname;
		this.customerLastnamek = customerLastnamek;
		this.address = address;
		this.phoneNo = phoneNo;
		this.aadharNo = aadharNo;
	}
	
	public Customer( String customerFirstname, String customerLastnamek, String address, long phoneNo,
			long aadharNo) {
		this.customerFirstname = customerFirstname;
		this.customerLastnamek = customerLastnamek;
		this.address = address;
		this.phoneNo = phoneNo;
		this.aadharNo = aadharNo;
	}
	
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerFirstname() {
		return customerFirstname;
	}
	public void setCustomerFirstname(String customerFirstname) {
		this.customerFirstname = customerFirstname;
	}
	public String getCustomerLastName() {
		return customerLastnamek;
	}
	public void setCustomerLastname(String customerLastnamek) {
		this.customerLastnamek = customerLastnamek;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
}
