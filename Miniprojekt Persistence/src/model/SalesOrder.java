package model;

public class SalesOrder {
	String orderDate;
	String deliveryStatus;
	boolean isRentalProduct;
	int ID;
	String staffLogInID;
	int customerPhoneNo;
	int invoiceID;
	
	public SalesOrder() {
		// TODO Auto-generated constructor stub
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

	public String getStaffLogInID() {
		return staffLogInID;
	}

	public void setStaffLogInID(String staffLogInID) {
		this.staffLogInID = staffLogInID;
	}

	public int getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(int customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

}
