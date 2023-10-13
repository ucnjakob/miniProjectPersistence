package database;
import java.sql.Connection;

import model.*;

public interface WDBIF {
	
	public  Warehouse findWarehouse(String Wname);
	public boolean checkStock(Product product, String warehouseName, int qty);
	public void updateStock(OrderLine ol, Connection dbCon);
}

