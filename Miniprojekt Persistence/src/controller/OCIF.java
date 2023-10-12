package controller;
import java.util.List;

import model.*;

public interface OCIF {

	
	public void setCustomer(Customer customer);
	public void setStaff(Staff staff);
	public Staff findStaff(String name);
	public Customer findCustomer(int name);
	public void addCustomer(Customer customer);
	public void findAndAddProduct(String pName, int qty, String wName);
	public void createOrder();
	public void finalizeOrder();
	public List<OrderLine> getOrderLines();
}
