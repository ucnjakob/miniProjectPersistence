package database;
import java.sql.*;
import java.util.ArrayList;

import controller.OCIF;
import controller.OrderController;
import controller.WCIF;
import controller.WarehouseController;
import model.*;

public class SalesOrderDB implements SODBIF{

	
	Connection dbCon;
	WCIF wcif;
	
	public SalesOrderDB() 
	{
	wcif = new WarehouseController();
	}

	@Override
	public void insertOrder(SalesOrder order) {
		 
		//Initiate variables
		String orderDate = order.getOrderDate();
		String deliveryStatus = order.getDeliveryStatus();
		boolean isrentalProduct = order.getIsRentalProduct();
		int bitIsRental;
		if(isrentalProduct)
		{
			bitIsRental = 1;
		}
		else
		{
			bitIsRental = 0;
		}
		String staffLoginId = order.getStaff().getLoginId();
		int customerPhoneNo = order.getCustomer().getPhoneNo();
		dbCon = DBCon.getInstance().getDBcon();
		
		
		//Statement
		try {
			dbCon.setAutoCommit(false); // starting transaction
			PreparedStatement stmt = dbCon.prepareStatement("INSERT INTO salesOrder(orderDate, deliveryStatus, isrentalProduct, staffLoginId, customerPhoneNo) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, orderDate);
			stmt.setString(2, deliveryStatus);
			stmt.setInt(3, bitIsRental);
			stmt.setString(4, staffLoginId);
			stmt.setInt(5, customerPhoneNo);
			
			stmt.executeUpdate();
			
			//find order ID
			int orderId;
			PreparedStatement stmt2 = dbCon.prepareStatement("select max(id) as id from salesOrder where StaffloginId = ?");
			stmt2.setString(1, staffLoginId);
			ResultSet rs = stmt2.executeQuery();
			rs.next();
			orderId = rs.getInt("ID");
			
			
			//Insert orderlines
		
			//initialise variables
			ArrayList<OrderLine> orderLines = order.getOrderLines();
			
			
			//Statement
			PreparedStatement stmt3 = dbCon.prepareStatement("INSERT INTO OrderLine(salesOrderID, productName, qty, priceSoldAt) VALUES (?, ?, ?, ?)");
			stmt3.setInt(1, orderId);
			
			for(OrderLine ol : orderLines)
			{	
				Product product1 = ol.getProduct();
				String wName1 = ol.getWarehouseName();
				int qty1 = ol.getQty();
				
				if(wcif.checkStock(product1, wName1, qty1)) 
				{
				String productName = ol.getProduct().getpName();
				int qty = ol.getQty();
				int priceSoldAt = ol.getPriceSoldAt();
				stmt3.setString(2, productName);
				stmt3.setInt(3, qty);
				stmt3.setInt(4, priceSoldAt);
				
				stmt3.executeUpdate();
				wcif.updateStock(ol, dbCon);
			    }
				else
				{
					dbCon.rollback();
					dbCon.setAutoCommit(true);
				}
			}
			dbCon.commit();
			dbCon.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(dbCon != null) {
			try {
				dbCon.rollback();
				dbCon.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	}
}
