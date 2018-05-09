package it.ferroz.lezioni.prove.proveAnimale;

public class MainAnimale {

	public static void main(String[] args) {
	
		Cane cane = new Cane();
		
		Animale animale = new Animale();
		
		Animale animaleCane = new Cane();
		
		UtilityPerAnimali.stampaFood(cane);
		UtilityPerAnimali.stampaFood(animale);
		UtilityPerAnimali.stampaFood(animaleCane);
		
		UtilityPerAnimali.faiStraMangiare(cane);
		UtilityPerAnimali.faiStraMangiare(animale);
		UtilityPerAnimali.faiStraMangiare(animaleCane);
		
		UtilityPerAnimali.stampaFood(cane);
		UtilityPerAnimali.stampaFood(animale);
		UtilityPerAnimali.stampaFood(animaleCane);

	}

}
