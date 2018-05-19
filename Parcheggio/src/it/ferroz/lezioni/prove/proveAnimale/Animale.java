package it.ferroz.lezioni.prove.proveAnimale;

public class Animale {

	protected int food;
	
	public Animale() {
		food = 0;
	}
	
	public Animale(int food) {
		this.food = food;
	}
	
	public void mangia() {
		food = food + 10;
	}
	
	public int getFood() {
		return food;
	}
	
	public void tipo() {
		System.out.println("Animale");
	}
	
}
