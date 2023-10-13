package controller;
import java.sql.Connection;

import database.*;
import model.OrderLine;
import model.Product;
import model.Warehouse;

public class WarehouseController implements WCIF{
	WDBIF wdbif = new WarehouseDB();
	
	public WarehouseController() {
		// TODO Auto-generated constructor stub
	}
    public Warehouse findWarehouse(String wName) {
        return wdbif.findWarehouse(wName);
    }
    
    public boolean checkStock(Product product, String warehouseName, int qty)
    {
    	return wdbif.checkStock(product, warehouseName, qty);
    }
    
    public void updateStock(OrderLine ol, Connection dbCon)
    	{
    		wdbif.updateStock(ol, dbCon);
    	}
    }
	

