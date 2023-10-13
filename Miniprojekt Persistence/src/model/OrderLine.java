package model;

public class OrderLine {
	
	Product product;
	int qty;
	int priceSoldAt;
	SalesOrder order;
	String warehouseName;

	public OrderLine(Product product, int qty, String warehouseName) 
	{
		this.product = product;
		this.qty = qty;
		this.warehouseName = warehouseName;
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
	
	public String getPname()
	{
		return product.getpName();
	}
	
	public String getWarehouseName()
	{
		return warehouseName;
	}
	

}
