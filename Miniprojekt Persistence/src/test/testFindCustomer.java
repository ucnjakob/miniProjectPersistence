package test;
import database.*;
import model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class testFindCustomer {

	@Test
	void test()  
	{
		//Arrange and //Act
		CustomerDB SUT = new CustomerDB();
		Customer c = SUT.findCustomer(1401);
		
		//Assert
		assertNotEquals(c, null);
		assertEquals(c.getPhoneNo(), 1401);
	}	

}


