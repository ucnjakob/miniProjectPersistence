package model;

public class Staff {
String fname;
String lname;
int phoneNo;
String email;
String pw;
boolean isAdmin;
String logInID;

	public Staff(String fname, String lname, int phoneNo, String email, String pw, boolean isAdmin, String logInID) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phoneNo = phoneNo;
		this.email = email;
		this.pw = pw;
		this.isAdmin = isAdmin;
		this.logInID = logInID;
	}
	
	public String getLoginId()
	{
		return logInID;
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

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getLogInID() {
		return logInID;
	}

	public void setLogInID(String logInID) {
		this.logInID = logInID;
	}

}
