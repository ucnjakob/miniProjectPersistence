package controller;
import database.*;
import model.Customer;

public class CustomerController implements CCIF{
	
	CDBIF cdbif = new CustomerDB();

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}
    public Customer findCustomer(int phoneNo) {
        return cdbif.findCustomer(phoneNo);
    }
}


