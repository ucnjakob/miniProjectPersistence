package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Customer;
import model.Warehouse;
import model.Warehouseline;

public class WarehouseDB implements WDBIF{

	private  Warehouse foundWarehouse = null;
	private String wareHouse;
	
	public WarehouseDB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Warehouse foudWarehouseByName(String Wname) {
		Connection dbCon = DBCon.getInstance().getDBcon();

		
		
		String query = "select * from warehouse where Wname = " + Wname;
		try {
			Statement stmt = dbCon.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(query);
			
			//set varibles to found vlaues
			rs.next();
			wareHouse = rs.getString(Wname);				
			foundWarehouse = new Warehouse(wareHouse);
			stmt.close();
		} 
		
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return foundWarehouse;
	}

}
