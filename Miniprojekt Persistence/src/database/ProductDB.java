package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;

public class ProductDB implements PDBIF {
	
	Connection dbCon;
	
    public ProductDB() {
       
    }

    public Product findProduct(String pName) {
        dbCon = DBCon.getInstance().getDBcon();
        Product foundProduct = null;

        String query = "SELECT * FROM product WHERE pName = ?";
        
        try {
        	PreparedStatement stmt = dbCon.prepareStatement(query);
            stmt.setString(1, pName);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            String foundPname = rs.getString("pName");
            int foundPurchasePrice = rs.getInt("purchasePrice");
            int foundSalesPrice = rs.getInt("salesPrice");
            int foundRentPrice = rs.getInt("rentPrice");
            String foundCountryOfOrigin = rs.getString("countryOfOrigin");
            int foundMinStock = rs.getInt("minStock");
            int foundSupplierID = rs.getInt("supplierId");
                
            foundProduct = new Product(foundPname, foundPurchasePrice, foundSalesPrice, foundRentPrice, foundCountryOfOrigin, foundMinStock, foundSupplierID);
              
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundProduct;
    }
}
