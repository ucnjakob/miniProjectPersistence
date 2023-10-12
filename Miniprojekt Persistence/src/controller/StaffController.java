package controller;
import database.*;
import model.Staff;

public class StaffController implements SCIF{
	SDBIF sdbif = new StaffDB();
	
	public StaffController() {
		// TODO Auto-generated constructor stub
	}

	    public Staff findStaff(String logInId) {
	        return sdbif.findStaff(logInId);
	    }
	}
