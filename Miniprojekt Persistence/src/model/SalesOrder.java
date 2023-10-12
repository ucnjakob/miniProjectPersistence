package model;
import java.util.ArrayList;
import java.util.Date;

public class SalesOrder {
	String orderDate;
	String deliveryStatus;
	boolean isRentalProduct;
	int ID;
	Staff staff;
	Customer customer;
	int invoiceID;
	ArrayList<OrderLine> orderLines;
	
	
	public SalesOrder()
	{
		
		
	}

	public void addOrderline(OrderLine ol) 
	{
		orderLines.add(ol);
	}
	
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public boolean isRentalProduct() {
		return isRentalProduct;
	}

	public void setRentalProduct(boolean isRentalProduct) {
		this.isRentalProduct = isRentalProduct;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}


	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	
	public boolean getIsRentalProduct()
	{
		return isRentalProduct;
	}
	
	public Staff getStaff()
	{
		return staff;
	}
	
	public Customer getCustomer()
	{
		return customer;
	}
	
	public ArrayList<OrderLine> getOrderLines()
	{
		return orderLines;
	}

}
