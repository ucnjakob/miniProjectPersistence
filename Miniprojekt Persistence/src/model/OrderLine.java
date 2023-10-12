package model;

public class OrderLine {
	
	Product product;
	int qty;
	int priceSoldAt;
	SalesOrder order;

	public OrderLine(Product product, int qty) 
	{
		this.product = product;
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPriceSoldAt() {
		return priceSoldAt;
	}

	public void setPriceSoldAt(int priceSoldAt) {
		this.priceSoldAt = priceSoldAt;
	}


	public SalesOrder getSalesOrderID() {
		return order;
	}


	

	public String getTotalAmount() {
		// TODO Auto-generated method stub
		return null;
	}

}
