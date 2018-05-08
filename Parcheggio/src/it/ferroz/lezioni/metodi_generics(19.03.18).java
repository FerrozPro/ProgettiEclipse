public class List<T>{
	
	public void appendMultiple(T x, int n){ ... } //la T corrisponde a quella dichiarata nella firma della classe List
	
	//Metodo localmente polimorfo: il tipo S posso cambiarlo ogni volta che invoco il metodo
	public <S> void addFirsts(List<Pair<T,S>> l){ ... } //la T corrisponde a quella dichiarata nella firma della classe List
	
}

//Nel chiamante:
List<string> l = new List<String>();
l.addFirsts(List<Pair<String, ...>>); /*nei "..." posso scegliere io che tipo mettere
									  Ho una lista di coppie con T = String (sennò non compila, perchè l'abbiamo creata così la lista l
									  T è bloccato sull'oggetto, S è libero --> posso sceglierlo io il tipo S ogni volta che invoco il metodo*/

/*Quando decido i generics? in instantiation time (= quando faccio una new)
Lo scope di T è la CLASSE: il tipo T è deciso nel momento di istanziazione (= momento in cui costruisco con una new)
Lo scope di S è il METODO: il tipo S è deciso nel momento dell'invocazione del metodo (es.: deciso il tipo S nel momento in cui
invoco il metodo addFirsts.*/

################################################################################################################################

/*GRAFO
Nel nodo ci saranno:
- il dato (con tipo generics)
- una collection di puntatori agli altri nodi (n pointers)*/

public class GNode{ //Grafo con solo numeri interi
	private int data;
	private Collection<GNode> edges;
	//oppure
	private GNode[] edges; //array di puntatori
}

//Versione migliore:
public class GNode<T>{
	private T data;
	private Collection<GNode<T>> edges; /*Se al posto di T scrivessi String, avrei un grafo che punta a nodi di stringhe e basta --> errore di design
										Se metto T è perchè il nodo punta a elementi del nostro stesso tipo T*/
}

/*Se voglio rappresentare anche un'informazione sugli archi,
creo un nuovo tipo "arco":*/

public class GEdge<E>{
	private E info;
	private GNode<E> rear, front; //nodi a cui è connesso l'arco
}

//Modifico, allora, GNode:

public class GNode<T>{
	private T data;
	private Collection<GEdge<T>> edges;
}

/*Non voglio, però, che l'informazione dell'arco sia la stessa del nodo (nella Collection GEdge ha tipo T e GNode ha "private T data")
Quindi scrivo:*/

public class GNode<T,E>{
	private T data;
	private Collection<GEdge<E,T> edges;
}

public class GEdge<A,B>{
	private A info;
	private GNode<B,A>
}

/*Generics sui metodi:
se voglio lavorare sui nodi --> es.: trasformare i nodi da un tipo a un altro (da Integer a Boolean a esempio)
credo un metodo map.
Uso un design pattern:*/

public interface Function<A,B>{
	B apply(A a);
}

/*Anonymous object:
new nomeInterfaccia(){
	credo un oggetto che implementi l'interfaccia
}
Es.:*/

Function<Integer, Boolean> f = new Function<Integer, Boolean>(){ //è un oggetto anonimo perchè non ha una classe ma ha un'interfaccia
	//implemento metodi dell'interfaccia Function
	public Boolean apply(Integer x){
		...
	}
}; //il ";" chiude lo statement

//Metodo map:

public <R> GNode<R,E> map(Function<T,R> f){ ... } //voglio trasformare i nodi di tipo T in tipo R 
/*E è il tipo delle info sugli archi
<R>: significa che è un metodo localmente polimorfo*/