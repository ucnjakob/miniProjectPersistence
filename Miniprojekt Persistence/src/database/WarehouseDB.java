package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Warehouse;


public class WarehouseDB implements WDBIF{

	private  Warehouse foundWarehouse = null;
	private String wareHouse;
	
	public WarehouseDB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Warehouse foudWarehouseByName(String wName) {
		Connection dbCon = DBCon.getInstance().getDBcon();


		
		String query = "select * from warehouse where Wname = ?";
		try {
			PreparedStatement stmt = dbCon.prepareStatement(query);
			stmt.setString(1, wName);
			ResultSet rs = stmt.executeQuery(query);
			
			//set varibles to found vlaues
			rs.next();
			wareHouse = rs.getString(wName);				
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
