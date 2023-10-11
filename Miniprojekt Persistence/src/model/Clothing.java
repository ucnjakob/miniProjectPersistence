package model;

public class Clothing extends Product{
	
	int size;
	String colour;

	public Clothing(int size, int i, int j, String colour, int k, int l, String string, String string2, String string3, String string4, int m) {
		super();
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
