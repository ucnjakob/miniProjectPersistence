package database;
import model.*;

public interface WDBIF {
	
	public  Warehouse findWarehouse(String Wname);
	public boolean checkStock(Product product, String warehouseName, int qty);

}

