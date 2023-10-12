package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Staff;
public class StaffDB implements SDBIF {

	public StaffDB() {
		// TODO Auto-generated constructor stub
	}


//@Override
	public Staff findStaff(String LogInId)
	{
		Connection dbCon = DBCon.getInstance().getDBcon();

		Staff foundStaff = null;
		String foundFname;
		String foundLname;
		int foundPhoneNo;
		String foundEmail;
		String foundPw;
		String foundLogInId;
		boolean foundIsAdmin;
		int tempIsAdmin;
		
		String query = "SELECT * FROM staff WHERE logInID = ?";
		
		 try (PreparedStatement stmt = dbCon.prepareStatement(query)) {
	            stmt.setString(1, LogInId);
	            ResultSet rs = stmt.executeQuery();
			
			//set varibles to found vlaues
			rs.next();
			foundPhoneNo = rs.getInt("phoneNo");
			foundFname = rs.getString("fname");
			foundLname = rs.getString("lname");
			foundEmail = rs.getString("email");
			foundPw = rs.getString("pw");
			foundLogInId = rs.getString("logInID");
			tempIsAdmin = rs.getInt("isAdmin");
			foundIsAdmin = (tempIsAdmin == 1);
				
			foundStaff = new Staff(foundFname, foundLname, foundPhoneNo, foundEmail, foundPw, foundIsAdmin, foundLogInId);
			stmt.close();
		} 
		
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		return foundStaff;
	}

}