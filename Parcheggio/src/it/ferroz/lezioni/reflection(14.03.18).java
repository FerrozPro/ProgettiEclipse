/*per stampare una lista posso creare
-metodo statico, prendere l'oggetto come parametro e farci qualcosa
-metodo non statico e usare this*/

//Metodo non statico
public <T> void print(){ //metodo non statico --> lavora su this
	StringBuilder b = new StringBuilder();
        try {
            Class<?> cl = null;
            for (int i = 0; i < this.size(); i++) {
                E x = this.getAt(i);   // se voglio mettere l'elemento i-esimo in una variabile, devo metterlo in una variabile di tipo T
                cl = x.getClass();  // estraggo il tipo dell'elemento usando la reflection: lo faccio solo perché qui sotto stampiamo il tipo, altrimenti non servirebbe!
                b.append(String.format("%s ", x));    // la format string '%s' stampa l'elemento x di tipo T invocando il suo toString()
            }
            System.out.println(String.format("MyList:\n\ttype: %s\n\tsize: %d\n\tcontent: %s", cl == null ? "unknown" : cl.getName(), this.size(), b));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
	
/*Il tipo generico sulla firma del metodo serve per dire che 
è polimorfo all'interno del metodo

Stampare un tipo generico:
reflection: sottomodulo della libreria standard, che fa un'ispezione a runtime dei tipi degli oggetti.
Serve perchè esiste la subsumption. Con la subsumption si perde l'informazione a runtime. Il tipo originale è scritto all'interno dell'oggetto.
Ogni oggetto ha i suoi vari campi, un pointer alla virtual table e il suo tipo originale.

Cane c = new Cane();
Animale a = c; --> SUBSUMPTION
l'oggetto c ha il suo tipo originale: Cane
(A livello di compilazione, il compilatore vede il tipo Animale)

Un oggetto di tipo Class è un oggetto che rappresenta una classe a runtime

String.format funziona come la printf. %s - cl (oggetto Class).
Se cl è null scrivo la stringa "unknown" (=il tipo non lo conosco), sennò stampo il nome del tipo (cl.getName())

