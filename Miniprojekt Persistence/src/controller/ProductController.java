package controller;
import database.*;
import model.Product;

public class ProductController implements PCIF{
	ProductDB pdbif = new ProductDB();

	public ProductController() {
		// TODO Auto-generated constructor stub
	}

    public Product findSProduct(String pName) {
        return pdbif.findProduct(pName);
    }
}


