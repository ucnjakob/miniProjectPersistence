package controller;
import database.*;
public class OrderController implements OCIF{
	
	CCIF ccif = new CustomerController();
	SCIF scif = new StaffController();
	PCIF pcif = new ProductController();
	WCIF wcif = new WarehouseController();
	SODBIF sodbif = new SalesOrderDB();
	
	public OrderController() {
		// TODO Auto-generated constructor stub
	}

}
