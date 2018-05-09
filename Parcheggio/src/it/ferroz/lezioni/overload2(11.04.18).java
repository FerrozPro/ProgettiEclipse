public class Test1{
	public void m(int n) {}
	
	@Overload
	
	/*Costruttore di default inizializza i campi con i valori di default.
	Costruttore di dafault è pubblico, non ha parametri e ha corpo vuoto. 
	Mette a valori di dafault i campi non inizializzati. Come inizializza i campi?
	'null'? Ma che tipo ha 'null'? Ha un tipo più basso di tutta la gerarchia, ha un tipo che si chiama bottom-type --> in questo modo subsume a qualsiasi cosa
	Il tipo bottom-type non lo possiamo nominare. 
	'null' è assegnabile ai tipi che sono in gerarchia (= sotto tipi di Object)
	
	bool, int, ... non fanno parte di questa gerarchia e non sono soggetti al subtiping, quindi non verrebbero inizializzati a null.
	
	Il costruttore di default inizializza tutto ciò che è oggetto a 'null' e ciò che non lo è lo inizializza a 0*/
	public Test1(){ }
	
	public static void prova(){
		Test1 t = new Test1(); //bisogna sempre inizializzare le cose 
	
		t.m(8); //chiama il metodo con parametro int
	}
	
	//Se ho anche:
	public int m(double b){ ... }
	/*(commentando il metodo m con parametro int) funziona lo stesso perchè converte automaticamente un int in un double
	Se tolgo il commento al metodo, il compilatore chiama la versione con int --> cerca il best match, cerca la corrispondenza più vicina
*/
	int n = t.m(8); //ERRORE perchè il compilatore non guarda il tipo di ritorno. potrebbe scagliere m con il double che è l'unico metodo che restituisce un int
	
	//Overloading con i tipi generici
	public <T> T m(T x){ //è localmente polimorfo. quindi ogni invocazion di questo metodo può avvenire con tipi diversi
		return x;
	}
	//t.m(8); --> chiama comunque il metodo con int perchè fa il best match
	
	public <T extends Animale> T m(T x){ 
		return x;
	}
	
	t.m(new Cane()); //chiama la versione con extends Animale
	t.m(new Pianta()); //chiama la versione polimorfa con solo T
	
	public <T extends Cane> T m(T x){ return x;}
	//t.m(new Cane()); //chiama la versione con extends Cane
	
	public <T extends MyList<?>> T m(T x){ return x;} //con ? posso mettere qualsiasi cosa
	//é come scrivere:
	public <A, T extends MyList<A>> T m(T x){ return x;}
	
	//Se scrivo:
	public Animale m(Animale x){ return x;}
	/*il metodo con extends Animale va in errore: m(T) clashes with 'm(Animale)'; both methods have same erasure (=cancellazione)
	Overloading deve essere risolvibile anche dopo l'erasure*/

