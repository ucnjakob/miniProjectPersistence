package controller;

import model.Product;
import model.Warehouse;

public interface WCIF {
	
	public Warehouse findWarehouse(String wName);
	public boolean checkStock(Product product, String warehouseName, int qty);

}

