package it.ferroz.groceryshop;

import java.util.Date;

public class FoodProduct extends Product implements Perishable, Fragile {

	private Date expirationDate;

	/* Constructors */
	public FoodProduct(String barCode, Double price, Date expirationDate) {
		super(barCode, price);
		this.expirationDate = expirationDate;
	}

	public FoodProduct(String barCode, String name, Double price, Date expirationDate) {
		super(barCode, name, price);
		this.expirationDate = expirationDate;
	}

	public FoodProduct(String barCode, String name, String description, Double price, Date expirationDate) {
		super(barCode, name, description, price);
		this.expirationDate = expirationDate;
	}

	/* Methods */
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	@Override
	public Double maxWeightCarriable() {
		return 0.5;
	}

}
