//OVERLOADING != OVERRIDDING

Cane fido = new Cane();
Labrador zoe = new Labrador();
fido = zoe; //lo posso fare perchè fido è supertipo di zoe
fido.mangia(); //a run time invoca il metodo mangia della classe Labrador --> DINAMIC DISPATCHING//

//Overloading

public class C{
	public void m(int n){ ... }
	
	@Overload
	public void m(int n, float x){ ... } //stesso nome, diversi parametri
}

public class D extends C{
	@Override
	public void m(int n){ ... } //implementazione diversa del metodo m del padre C
	
	@Overload
	public void m(int n, bool d){ ... } //overload di un metodo del padre C
}

//nel chiamante:
D d = new D();
d.m(5); /*a momento di compile time il compilatore controlla se il metodo m è presente in D --> OK 
		  a momento di run time viene eseguito il metodo m di D*/
d.m(5, true); //funziona perchè è un metodo della classe D --> compila ed esegue

//ma se scrivo nel chiamante:
C d = new D();
d.m(5); /*a momento di compile time il compilatore controlla se il metodo m è presente in C --> OK 
		  a momento di run time viene eseguito il metodo m di D*/
d.m(5, true); /*in compile time il compilatore vede che questo metodo non è presente nella classe C (= tipo della varibile d),
			  quindi non compila*/

/*Il dinamic dispatching funziona perchè:

     new D()                                  new C()
+------------------+                        +---------+
                   D                                 C
+------------------+                        +---------+
 campi dell'oggetto                            campi
+------------------+                        +---------+
m(int)                 <--- ha i puntatori    m(int)
m(int, bool)                ai suoi metodi  +---------+
+------------------+	
*/

//Overloading ambiguo

public class C{
	public void m(Animale a){ ... }
	public void m(Cane c){ ... }
}
//è ambiguo nella chiamata
C c = new C();
c.m(new Cane()); //è ambiguo in compile time perchè il compilatore non sa quale metodo chiamare (potrebbe andare bene sia il primo metodo perchè Animale è super tipo, che il secondo
c.m(new Labrador()); 
//In questo caso viene segnalata l'ambiguità, non viene risolta

//Se cambio il tipo di ritorno rimane ambiguo?

public int m(int x){ return x+1; }
public boolean m(int x){ return x > 10;}

/*Hanno lo stesso nome ma non c'è alcun modo per distinguerli --> non posso scrivere il secondo metodo

Java guarda solo i parametri per discriminare i metodi, non guarda il contesto in cui invoco i metodi:*/

C c = new C();
int a = c.m(8) + 3; //sarebbe ovvio per noi che intendiamo il primo metodo perchè abbiamo assegnato il suo valore di ritorno a una variabile a di tipo int e non bool
boolean b = c.m(8);

/*E se guandassi oltre alla firma e al tipo di ritorno le eccezioni? 
Ci sarebbe comunque ambiguità.

Se invece scrivessi un metodo:*/

public float m(float x){ ... }

//Quando faccio la chiamata ai metodi

c.m(8); //chiamarebbe il metodo con parametro e tipo ti ritorno int
c.m(2.3); //chiamerebbe il metodo con parametro e tipo di ritorno float

//Se avessi metodi con parametri che hanno tipo generico?

public int m(int x){ ... }
public T m(T x){ ... }

//Se chiamassi
c.m(8); //il compilatore non saprebbe quali dei due metodi usare perchè T potrebbe essere di tipo Integer 