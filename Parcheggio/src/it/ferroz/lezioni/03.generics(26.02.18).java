//Lezione 26.02.18
public class C<T> {
	
	private T o;
	
	public T p(int x, float y){}
	
}

public class Node{
	
	public Object data; //tipo di dato
	public Node next; //puntatore al nodo successivo
}

public class List{
	
	private Node n;
	
	public int size(){ ... }
	
	public void append(Object e){
		Node m = new Node();
		n.next = m;
		m.data = e;
	}
	
	public Object getHead(){ //restituisce Object perchè la variab data è di tipo Object
		return n.data;       //l'idea è che questo metodo dovrebbe restituire la testa della lista
	}

	public static void main(String[] args){
		List l = new List();
		l.append(8); //l'int viene convertito in Integer che subsume Object
		l.append(new Gatto()); //subsume Object quindi posso scriverlo - Gatto è una sottoclasse di Object
		Cane o = (Cane)l.getHead();  //a runtime il cast fallisce perchè l'ultimo elemento che ho inserito è di tipo Gatto e voglio castarlo con Cane
	}
}

//con i GENERICS:

public class Node<T>{
	public T data;
	public Node next;
}

public class List<E>{
	
	private Node<E> n;
	
	//Metodo parametrico: (= metodo localmente polimorfo)
	public <T> void append(T e){ ... } //può essere chiamato con un tipo qualunque
	
	public E getHead(){ ... }
	
	public static void main(String[] args){
		List<Cane> l = new List<Cane>();
		l.append(8); // NON compila
		Cane o = l.getHead();
	}
}

//FIRST-CLASS POLYMORPHISM

public class Pair<A,B>{
	public A a;
	public B b;
}

public class Utils{ /*al posto di scrivere Utils<T,S>, scrivo <T,S> nel metodo in modo tale che
					swap possa essere chiamato con tutti i tipi che voglio*/
	
	public static <T,S> Pair<S,T> swap(Pair<T,S> p){
		return new Pair<S,T>(p.b, p.a); /*costruisco una coppia nuova con i tipi invertiti 
										e gli passo come parametri valori invertiti 
										che vengono poi passati al costruttore di Pair*/
	}
}
