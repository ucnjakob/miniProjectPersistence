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
	private Staff staff;
	private Customer customer;
	
	public OrderController() {
		// TODO Auto-generated constructor stub
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
	public void addCustomer(Customer customer) {
		currentOrder.setCustomer(customer);
	}

	@Override
	public void findAndAddProduct(String pName, int qty, String wName) 
	{
		Product foundProduct = pcif.findSProduct(pName);
		System.out.println(foundProduct.getpName());
		if(wcif.checkStock(foundProduct, wName, qty))
			{
				OrderLine ol = new OrderLine(foundProduct, qty);
				currentOrder.addOrderline(ol);
				System.out.println(ol.getQty());
			}
	} 


	@Override
	public void createOrder() {
		currentOrder = new SalesOrder(staff);
		
	}

	@Override
	public void finalizeOrder() 
	{
		sodbif.insertOrder(currentOrder);
		
	}

	public List<OrderLine> getOrderLines() {
		return currentOrder.getOrderLines();
	}
	
	public void setStaff(Staff staff)
	{
		this.staff = staff;
	}
	
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
	

	

}
