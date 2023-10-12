package controller;
import database.*;
import model.Warehouse;

public class WarehouseController implements WCIF{
	WDBIF wdbif = new WarehouseDB();
	
	public WarehouseController() {
		// TODO Auto-generated constructor stub
	}
    public Warehouse findWarehouse(String wName) {
        return wdbif.findWarehouse(wName);
    }
	
}
