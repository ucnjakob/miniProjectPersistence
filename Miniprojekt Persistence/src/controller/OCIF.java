package controller;
import model.*;

public interface OCIF {

	public Staff addStaff(Staff Staff);
	public Staff findStaff(String name);
	public Customer findCustomer(String name);
	public Customer addCustomer(Customer customer);
	public Product findProduct(String name);
	public Product addProduct(Product product);
	public void createOrder();
	public void finalizeOrder();
}
