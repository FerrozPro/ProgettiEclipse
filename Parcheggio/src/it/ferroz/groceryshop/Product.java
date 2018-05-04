package it.ferroz.groceryshop;

public abstract class Product {

	private String barCode;

	private String name;

	private String description;

	private Double price;

	/* Constructors */
	public Product(String barCode, Double price) {
		this.barCode = barCode;
		this.price = price;
	}

	public Product(String barCode, String name, Double price) {
		this.barCode = barCode;
		this.name = name;
		this.price = price;
	}

	public Product(String barCode, String name, String description, Double price) {
		this.barCode = barCode;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/* Methods */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBarCode() {
		return barCode;
	}

	public Double getPrice() {
		return price;
	}

}
