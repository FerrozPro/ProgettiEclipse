//Lezione 19.02.18
public class UtilityPerAnimali{
	
	//Metodo polimorfo: prende un animale, ma può prendere anche un suo sottotipo
	public static void faiStraMangiare(Animale a){

		a.mangia();
		a.mangia();
		a.mangia();
	}
	
	public static void main(String[] args){
		
		UtilityPerAnimali.faiStraMangiare(new Dalmata()); //INLINED: passo direttamente l'argomento senza assegnarlo a una variabile
		
		//SUBSUNZIONE 1: mettere in una variabile di tipo più alto (Animale) un oggetto di tipo più basso (Dalmata)
		Animale a = new Dalmata(); //BINDING: dare un nome a un'entità -> 1) per leggibilità 2) per riusabilità
		faiStraMangiare(a);
		
		//SUBSUNZIONE 2: tipo Gatto passato come argomento che in realtà richiede un tipo più alto (Animale)
		UtilityPerAnimali(new Gatto());
		
		/*La classe Dalmata è in relazione di sottoclasse con la classe Animale.
		In fase di compilazione, il compilatore vede metodo con a Animale, 
		non come Dalmata -> guarda tipo APPARENTE: tipo con cui la variabile è dichiarata*/
		
		Animale a = new Cane(); 
		a.abbaia(); //non è compatibile. a è di tipo Animale e "abbaia()" è un metodo di Cane --> ERRORE in compiletime
		
		Animale a;
		if(...){
			a = new Cane();
		}else{
			a = new Gatto();
		}
		UtilityPerAnimali.faiStraMangiare(a); //OK --> metodo è ereditato sia da Cane che da Gatto
		a.abbaia(); //NO --> metodo solo di Cane 
	}
	
	public class Animale{
		public void mangia(){ ... }
	}
	
	public class Cane extends Animale{
		@Override
		public void mangia(){ ... }
	}
