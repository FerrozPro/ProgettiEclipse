package it.ferroz.groceryshop;

public class MaterialProduct extends Product {

	private MaterialType materialType;

	/* Constructor */
	public MaterialProduct(String barCode, Double price, MaterialType materialType) {
		super(barCode, price);
		this.materialType = materialType;
	}

	public MaterialProduct(String barCode, String name, Double price, MaterialType materialType) {
		super(barCode, name, price);
		this.materialType = materialType;
	}

	public MaterialProduct(String barCode, String name, String description, Double price, MaterialType materialType) {
		super(barCode, name, description, price);
		this.materialType = materialType;
	}
	
	/* Methods */
	public MaterialType getMaterialType() {
		return materialType;
	}	

}
