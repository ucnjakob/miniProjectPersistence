package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Clothing;
import model.Equipment;
import model.GunReplica;
import model.Product;

public class ProductDB implements PDBIF {
	
	Connection dbCon;
	
    public ProductDB() {
       
    }

    public Product findProduct(String pName) {
        dbCon = DBCon.getInstance().getDBcon();
        Product foundProduct = null;

        String query = "SELECT * FROM product WHERE pName = ?";
        
        try (PreparedStatement stmt = dbCon.prepareStatement(query)) {
            stmt.setString(1, pName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String pType = rs.getString("pType");
                
                if ("pTypeA".equals(pType)) {
                    Clothing clothing = new Clothing(
                    	rs.getInt("purchasePrice"),
                        rs.getInt("salesPrice"),
                        rs.getInt("rentPrice"),
                        rs.getString("countryOfOrigin"),
                        rs.getInt("minStock"),
                        rs.getInt("size"),
                        rs.getString("colour"),
                        rs.getInt("supplierID")
                    );
                    foundProduct = clothing;
                } else if ("pTypeB".equals(pType)) {
                    Equipment equipment = new Equipment(
                        rs.getInt("purchasePrice"),
                        rs.getInt("salesPrice"),
                        rs.getInt("rentPrice"),
                        rs.getString("countryOfOrigin"),
                        rs.getInt("minStock"),
                        rs.getString("equipmentType"),
                        rs.getString("equipmentDescription"),
                        rs.getInt("supplierID")
                    );
                    foundProduct = equipment;
                } else if ("pTypeC".equals(pType)) {
                    GunReplica gunReplica = new GunReplica(
                        rs.getInt("purchasePrice"),
                        rs.getInt("salesPrice"),
                        rs.getInt("rentPrice"),
                        rs.getString("countryOfOrigin"),
                        rs.getInt("minStock"),
                        rs.getString("calibre"),
                        rs.getString("material"),
                        rs.getInt("supplierID")
                    );
                    foundProduct = gunReplica;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundProduct;
    }
}
