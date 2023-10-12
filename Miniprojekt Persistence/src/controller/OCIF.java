package controller;
import java.util.List;

import model.*;

public interface OCIF {

	public Staff addStaff(Staff Staff);
	public Staff findStaff(String name);
	public Customer findCustomer(int name);
	public Customer addCustomer(Customer customer);
	public void findAndAddProduct(String pName, int qty, String wName);
	public void createOrder();
	public void finalizeOrder();
	public List<OrderLine> getOrderLines();
}
