package it.ferroz.lezioni.prove.proveAnimale;

public class Cane extends Animale {
	
	@Override
	public void mangia() {
		food = food + 2;
	}

	public void abbaia() {
		food--;
	}
}
