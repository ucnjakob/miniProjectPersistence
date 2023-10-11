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

}
