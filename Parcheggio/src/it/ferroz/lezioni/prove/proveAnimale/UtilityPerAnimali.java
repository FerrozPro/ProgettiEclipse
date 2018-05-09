package it.ferroz.lezioni.prove.proveAnimale;

public class UtilityPerAnimali {

	public static void faiStraMangiare(Animale a) {

		a.mangia();
		a.mangia();
		a.mangia();
	}

	public static void stampaFood(Animale a) {
		System.out.println("Food = " + a.getFood());
	}
}
