package model;

public class Customer {

	int phoneNo;
	String fname;
	String lname;
	String customerAddress;
	String zipcode;
	String city;
	boolean isClub;
	
	public Customer(int phoneNo, String fname, String lname, String customerAddress, String zipcode, String city, boolean isClub)
	{
		this.phoneNo = phoneNo;
		this.fname = fname;
		this.lname = lname;
		this.customerAddress = customerAddress;
		this.zipcode = zipcode;
		this.city = city;
		this.isClub = isClub;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public boolean isClub() {
		return isClub;
	}

	public void setClub(boolean isClub) {
		this.isClub = isClub;
	}

}
