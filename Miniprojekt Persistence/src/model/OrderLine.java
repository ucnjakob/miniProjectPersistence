package model;

public class OrderLine {
	
	Product product;
	int qty;
	int priceSoldAt;
	String productName;
	int salesOrderID;

	public OrderLine() {
		// TODO Auto-generated constructor stub
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSalesOrderID() {
		return salesOrderID;
	}

	public void setSalesOrderID(int salesOrderID) {
		this.salesOrderID = salesOrderID;
	}

}
