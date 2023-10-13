package database;

import java.sql.Connection;
import model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Warehouse;


public class WarehouseDB implements WDBIF{

	Connection dbCon;
	
	private  Warehouse foundWarehouse = null;
	private String wareHouse;
	
	public WarehouseDB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Warehouse findWarehouse(String wName) {
		dbCon = DBCon.getInstance().getDBcon();


		
		String query = "select * from warehouse where Wname = ?";
		try {
			PreparedStatement stmt = dbCon.prepareStatement(query);
			stmt.setString(1, wName);
			ResultSet rs = stmt.executeQuery();
			
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
	
	public boolean checkStock(Product product, String warehouseName, int qty)
	{
		//initiate variables
		boolean isOnStock = false;
		dbCon = DBCon.getInstance().getDBcon();
		int foundStock;
		String wName = warehouseName;
		String pName = product.getpName();
		
		//statement
		String query = ("select * from warehouseLine where productname = ? and warehouseName = ?");
		try {
			PreparedStatement stmt2 = dbCon.prepareStatement(query);
			stmt2.setString(1, pName);
			stmt2.setString(2, wName);
			ResultSet rs = stmt2.executeQuery();
			rs.next();
			foundStock = rs.getInt("qty");
			if(foundStock >= qty)
			{
				isOnStock = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOnStock;
	}
	
	public void updateStock(OrderLine ol, Connection dbCon)
	{	
	
		
		
		Product product = ol.getProduct();
		int qty = ol.getQty();
		String wName = ol.getWarehouseName();
		String pName = product.getpName();
		int newQty = 0;
		
		String query1 = ("select * from warehouseLine where productname = ? and warehouseName = ?");
		
		try 
		{	
			
			dbCon.setAutoCommit(false);
			PreparedStatement stmt1 = dbCon.prepareStatement(query1);
			stmt1.setString(1, pName);
			stmt1.setString(2, wName);
			ResultSet rs1 = stmt1.executeQuery();
			rs1.next();
			newQty = rs1.getInt("qty");
			newQty -= qty;
		}
		 catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		String query2 = ("UPDATE warehouseline SET qty = ? where productName = ? and warehouseName = ?");
		try 
		{	
			
			PreparedStatement stmt2 = dbCon.prepareStatement(query2);
			stmt2.setInt(1, newQty);
			stmt2.setString(2, pName);
			stmt2.setString(3, wName);
			ResultSet rs2 = stmt2.executeQuery();
			
			
		}
		 catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		
	}

}
