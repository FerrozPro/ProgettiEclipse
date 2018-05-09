package it.ferroz.lezioni.prove.proveAnimale;

public class Animale {

	protected int food = 0;
	
	public void mangia() {
		food = food + 10;
	}
	
	public int getFood() {
		return food;
	}
}
