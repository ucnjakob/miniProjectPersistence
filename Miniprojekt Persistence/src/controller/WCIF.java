package controller;

import java.sql.Connection;

import model.OrderLine;
import model.Product;
import model.Warehouse;

public interface WCIF {
	
	public Warehouse findWarehouse(String wName);
	public boolean checkStock(Product product, String warehouseName, int qty);
	public void updateStock(OrderLine ol, Connection dbCon);
	

}

