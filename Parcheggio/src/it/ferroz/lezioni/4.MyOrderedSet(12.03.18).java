/*Set != List. Nel Set non ho duplicati, mentre nella List sì. 
Se creo una mia classe MySet, il metodo "insert" dovrà  controllare se il numero che devo inserire esiste già  nell'insieme. 
Ma se invece devo inserire un generics?*/

public class MySet<T> implements MyList<T>{
	...
	void insertAt(int i, T data){
		while(...){ //finchè ci sono nodi
			if(n.data == data){...} /*sto confrontanto i puntatori e non sto guardando cosa contengono.
									es.: se ho due Integer, entrambi uguali a 8, vedo che puntano allo stesso oggetto,
									ma non vedo che entrambi sono uguali a 8.
			Quindi dovrei scrivere:*/
			if(n.data.equals(data){...} /*se data è di tipo Integer va bene, perchè equals è un metodo di Object. 
										Ma se data ha un tipo diverso, di una classe che ho inventato io, in quella classe devo implementare "equals".
										Se voglio che sia un insieme di elementi ordinati, quando inserisco, inserisco gli elementi in modo che siano ordinati:
										controllo l'elemento prima e l'elemento dopo.
			Quindi dovrei scrivere:*/
			if(n.data < n.next.data && ...){...} /* "<" funziona solo con i numeri. Devo inventarmi un metodo che confronta.*/
		}
	}
}

//Quindi posso scrivere:

public class MyOrderedSet<T extends MyComparable> implements MyList<T>{
	...
	void insertAt(int i, T data){
		while(...){
			if(n.data.compare(data) && ...){...} /*Mi invento questo metodo "compare" che confronta. il tipo T deve rispettare l'interfaccia MyComparable*/
		}
	}
}

public interface MyComparable{
	boolean compare(MyComparable o); //confronta un altro parametro che ha lo stesso tipo dell'ogg che devo confrontare
}

//Quindi se scrivo:

MyOrderedSet<Cane> a = new MyOrderedSet<Cane>();

//Avrò che la classe Cane sarà :

public class Cane implements MyComparable{ //T deve estendere MyComparable
	String name;
	int peso, età ;
	
	boolean compare(MyComparable o){
		return this.peso < o.peso;
	}
}

/*Però MyComparable non ha il campo "peso", quindi non posso scrivere il metodo "compare" così --> dovrei fare un cast (o diventa di tipo Cane)
Quindi scrivo:*/

public interface MyComparable<S>{
	boolean compare(S o);
}

//Riscrivo le classi MyOrderedSet e Cane:

public class MyOrderedSet<T extends MyComparable<T>>{
	...
}
 public class Cane implements MyComparable<Cane>{
	...
	boolean compare(Cane o){
		return this.peso < o.peso;
	}
 }
 
 //Adesso il confronto funziona