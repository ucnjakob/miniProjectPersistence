package model;

public class GunReplica extends Product {
    private String calibre;
    private String material;

    public GunReplica(int purchasePrice, int salesPrice, int rentPrice, String countryOfOrigin, int minStock, String calibre, String material, int supplierID) {
        super(); 
        this.calibre = calibre;
        this.material = material;
        
    }
    


	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}
	
}
