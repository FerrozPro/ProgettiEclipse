/*GENERICS CONSTRAINTS - VINCOLI dei GENERICS.
Generics di classe - TYPE PARAMETERS*/
public class C<T>{
	esiste T
}
//Generics di metodi - FIRST CLASS POLYMORPHISM
public class C{
	...<T> (tipo di ritorno) f(A e, ...){
		esiste T
	}
}

public class C{
	
	public <T> void m(){
		T x; //che cosa ci posso fare? assegnarlo a un'altra variabile:
		T y = x;
	}
	/*T sarà sempre polimorfo. Non sarà mai sostituibile con un tipo vero (es.: Integer)
	Se invece prendo un parametro di tipo T: */
	
	public <T> void m(T a){
		T x;
		T y = x;
	}
	//nel main potrei scrivere:
	C c = new C();
	c.m(3);
	c.m(true); //metodo m è polimorfo, quindi lo posso usare con argomenti diversi
}
	
/*All'interno di m posso usare i metodi di Object perchè T è tipo qlss, ma sicuramente è almeno figlio di Object.
Quando uso variabili di tipo generico posso usare metodi di Object, ocme:
-equals
-hashCode
-toString
Se voglio, però, estendere i generics per usare metodi anche di altre classi posso scrivere: <T extends C'>
T può usare i metodi della classe C', che deve essere conosciuta.*/

/*In tempo run T viene sostituito con il tipo che viene dichiarato nel momento della new*/

public class MyList<T>{
	
	public T getHead(){...} //se la uso in l mi restituisce un Integer
	
	//nel main:
	MyList<Integer> l = new MyList<Integer>(); //tipo compatibile con il tipo della variabile l
}

public class MyList<T extends Animale>{//l non compilerebbe perchè Integer non estende Animale
	
	public T getHead(){
		T x = h.data;
		x.mangia(); //lo posso scrivere perchè x è tipo T, che estende Animale
		return x;
	}
	
	//nel main:
	MyList<Gatto> l = new MyList<Gatto>();
	Gatto g = l.getHead(); //OK
	Animale a = l.getHead(); //OK. l.getHead() restituisce un Gatto
	a.miagola(); //NO, perchè è un metodo di Gatto non di Animale
	g.miagola(); //OK
}

##########################################################################
//Una coppia

public class Pair<T,S>{
	private T a;
	private S b;
	
	public T getFirst(){ return a;}
	public S getSecond(){ return b;}
	
	public Pair(T x, S y){
		a = x;
		b = y;
	}
	
	//nel main:
	Pair<Integer, String> p = new Pair<Integer,String>();
}

//Una tripla

public class Tripla<T,S,R>{
	...
	private R c;
	
	...
	public R getThird(){ return c;}
	
	public Tripla(T x, S y, R z){
		...
		c = z;
	}
}

/*Non possiamo creare una classe "Tuple" generica per creare fino a un'ennesima tupla.
Ci tocca creare sempre una classe diversa per ogni tupla.

Definisco la classe Tripla usando la classe Pair:*/

public class Tripla<A,B,C> extends Pair<A,B>{ //ho esteso un tipo, non una classe. tripla è sottotipo di coppia
	private C c;
	
	public C getThird(){ return c;}
	
	//nel main:
	Pair<Integer, String> p = new Tripla<Integer, String, Double>(); //non posso mettere sottotipi di tipi dichiarati in Pair:
	Pair<Animale,...> p = new Tripla<Gatto,...> //NO
	
	/*si può subsumere solo sui tipi più esterni (Pair, Tripla), ma non a livello più interno (dentro le parentesi <>)*/
}