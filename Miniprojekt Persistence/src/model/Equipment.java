package model;

public class Equipment extends Product {
    private String equipmentType;
    private String equipmentDescription;

    public Equipment(int purchasePrice, int salesPrice, int rentPrice, String countryOfOrigin, int minStock, String equipmentType, String equipmentDescription, int supplierID) {
        super(); 
        this.equipmentType = equipmentType;
        this.equipmentDescription = equipmentDescription;
        
    }
   


	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getEquipmentDescription() {
		return equipmentDescription;
	}

	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

}
