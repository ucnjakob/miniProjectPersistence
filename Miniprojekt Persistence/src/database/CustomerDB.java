package database;

import model.Customer;
import java.sql.*;

public class CustomerDB implements CDBIF{
	
	
	public CustomerDB() 
	{
		
	}

	//@Override
	public Customer findCustomer(int phoneNo) 
	{
		Connection dbCon = DBCon.getInstance().getDBcon();

		Customer foundCustomer = null;
		String foundFname;
		String foundLname;
		String foundCustomerAddress;
		String foundZipcode;
		String foundCity;
		int foundPhoneNo;
		boolean foundIsClub;
		int tempIsClub;
		
		String query = "select * from customer where phoneNo = " + phoneNo;
		
		try {
			Statement stmt = dbCon.createStatement();
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(query);
			
			//set varibles to found vlaues
			rs.next();
			foundPhoneNo = rs.getInt("phoneNo");
			foundFname = rs.getString("fname");
			foundLname = rs.getString("lname");
			foundCustomerAddress = rs.getString("customerAddress");
			foundZipcode = rs.getString("zipcode");
			foundCity = rs.getString("city");
			tempIsClub = rs.getInt("isClub");
			foundIsClub = (tempIsClub == 1);
				
			foundCustomer = new Customer(foundPhoneNo, foundFname, foundLname, foundCustomerAddress, foundZipcode, foundCity, foundIsClub);
			stmt.close();
		} 
		
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		return foundCustomer;
	}

}
