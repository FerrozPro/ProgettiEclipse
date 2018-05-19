package it.ferroz.lezioni.prove.proveAnimale;

public final class UtilityPerAnimali {
	
	private UtilityPerAnimali() {
		
	}

	public static void faiStraMangiare(Animale a) {
		a.mangia();
		a.mangia();
		a.mangia();
	}

	public static void stampaFood(Animale a) {
		System.out.println("Food = " + a.getFood());
	}
	
	public static void a(Animale a) {
		a.tipo();
	}


}
