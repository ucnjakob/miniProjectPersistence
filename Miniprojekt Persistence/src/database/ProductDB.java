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

    public ProductDB() {
        // Constructor
    }

    public Product findProduct(String pName) {
        Connection dbCon = DBCon.getInstance().getDBcon();

        Product foundProduct = null;

        String query = "SELECT * FROM product WHERE pName = ?";
        
        try (PreparedStatement stmt = dbCon.prepareStatement(query)) {
            stmt.setString(1, pName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String pType = rs.getString("pType");

                // Check the product type and create the appropriate subclass
                if ("pTypeA".equals(pType)) {
                    foundProduct = new Clothing(
                        rs.getInt("purchasePrice"),
                        rs.getInt("salesPrice"),
                        rs.getInt("rentPrice"),
                        rs.getString("countryOfOrigin"),
                        rs.getInt("minStock"),
                        rs.getInt("size"),
                        rs.getString("colour"),
                        rs.getString("equipmentType"),
                        rs.getString("calibre"),
                        rs.getString("material"),
                        rs.getInt("supplierID")
                    );
                } else if ("pTypeB".equals(pType)) {
                    foundProduct = new Equipment(
                        rs.getInt("purchasePrice"),
                        rs.getInt("salesPrice"),
                        rs.getInt("rentPrice"),
                        rs.getString("countryOfOrigin"),
                        rs.getInt("minStock"),
                        rs.getInt("size"),
                        rs.getString("colour"),
                        rs.getString("calibre"),
                        rs.getString("material"),
                        rs.getInt("supplierID")
                    );
                } else if ("pTypeC".equals(pType)) {
                    foundProduct = new GunReplica(
                        rs.getInt("purchasePrice"),
                        rs.getInt("salesPrice"),
                        rs.getInt("rentPrice"),
                        rs.getString("countryOfOrigin"),
                        rs.getInt("minStock"),
                        rs.getInt("size"),
                        rs.getString("colour"),
                        rs.getString("equipmentType"),
                        rs.getString("calibre"),
                        rs.getString("material"),
                        rs.getInt("supplierID")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundProduct;
    }
}



