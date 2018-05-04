package it.ferroz.groceryshop;

public enum MaterialType {

	GLASS("Glass"), PAPER("Paper"), PLASTIC("Plastic");

	private String description;

	MaterialType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
