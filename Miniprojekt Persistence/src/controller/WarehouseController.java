package controller;
import database.*;
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

	
}
