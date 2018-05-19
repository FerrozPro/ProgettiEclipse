package it.ferroz.lezioni.prove.proveAnimale;

public class MainAnimale {

	public static void main(String[] args) {
	
		Animale animale = new Animale();
		Animale animaleDue = new Animale(10);
		
		Cane cane = new Cane();
		
		Animale animaleCane = new Cane();
		
		cane.abbaia();
		animaleCane.mangia();
		
		animale.tipo();
		cane.tipo();
		animaleCane.tipo();
		
		UtilityPerAnimali.a(animale);
		UtilityPerAnimali.a(cane);
		UtilityPerAnimali.a(animaleCane);
		
//		public static void a(Animale a) {
//			a.tipo();
//		}

		
		
		
 		UtilityPerAnimali.stampaFood(cane);
		UtilityPerAnimali.stampaFood(animale);
		UtilityPerAnimali.stampaFood(animaleDue);
		UtilityPerAnimali.stampaFood(animaleCane);
		
		UtilityPerAnimali.faiStraMangiare(cane);
		UtilityPerAnimali.faiStraMangiare(animale);
		UtilityPerAnimali.faiStraMangiare(animaleCane);
		
		UtilityPerAnimali.stampaFood(cane);
		UtilityPerAnimali.stampaFood(animale);
		UtilityPerAnimali.stampaFood(animaleCane);

	}

}
