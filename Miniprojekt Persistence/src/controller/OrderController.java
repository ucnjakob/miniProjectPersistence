package controller;
import java.util.List;

import database.*;
import model.Customer;
import model.OrderLine;
import model.Product;
import model.SalesOrder;
import model.Staff;

public class OrderController implements OCIF{
	
	CCIF ccif = new CustomerController();
	SCIF scif = new StaffController();
	PCIF pcif = new ProductController();
	WCIF wcif = new WarehouseController();
	SODBIF sodbif = new SalesOrderDB();
	private SalesOrder currentOrder;
	
	public OrderController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Staff addStaff(Staff Staff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Staff findStaff(String name) {
		Staff foundStaff = scif.findStaff(name);
		return foundStaff;
	}

	@Override
	public Customer findCustomer(int name) {
		Customer foundCustomer = ccif.findCustomer(name);
		return foundCustomer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAndAddProduct(String pName, int qty, String wName) 
	{
		Product foundProduct = pcif.findSProduct(pName);
		if(wcif.checkStock(foundProduct, wName, qty))
			{
				OrderLine ol = new OrderLine(foundProduct, qty);
				currentOrder.addOrderline(ol);
			}
	} 


	@Override
	public void createOrder() {
		
		
	}

	@Override
	public void finalizeOrder() {
		// TODO Auto-generated method stub
		
	}

	public List<OrderLine> getOrderLines() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
