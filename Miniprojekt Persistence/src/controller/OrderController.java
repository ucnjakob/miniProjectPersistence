package controller;
import database.*;
import model.Customer;
import model.Product;
import model.Staff;

public class OrderController implements OCIF{
	
	CCIF ccif = new CustomerController();
	SCIF scif = new StaffController();
	PCIF pcif = new ProductController();
	WCIF wcif = new WarehouseController();
	SODBIF sodbif = new SalesOrderDB();
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizeOrder() {
		// TODO Auto-generated method stub
		
	}

}
