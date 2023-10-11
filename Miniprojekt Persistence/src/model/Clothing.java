package model;

public class Clothing extends Product {
    private int size;
    private String colour;

    public Clothing(int purchasePrice, int salesPrice, int rentPrice, String countryOfOrigin, int minStock, int size, String colour, int supplierID) {
        super(); // Call the default constructor in the super class
        this.size = size;
        this.colour = colour;
        
    }

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

}
