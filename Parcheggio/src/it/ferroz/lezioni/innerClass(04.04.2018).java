/*Costruire classe con oggetti non costruibili:
- classe abstract
- costruttore della classe dichiarato privato (= può essere utilizzato solo all'interno di metodi della classe)

Se in un'altra classe creo un oggetto di una classe che ha costruttore privato --> ERRORE
Allora posso, nella classe con costruttore privato, creare un metodo statico che restituisce un oggetto.
Invoco poi questo metodo in un altra classe e riesco a farmi restituire l'oggetto creato dal costruttore privato
Es.:*/
public class Prova{
	
	private Prova(){
		//costruttore privato
	}
	public static Prova m(){ //metodo statico che restituisce un oggetto creato col costruttore privato
		return new Prova;
	}
}
//In una classe diversa chiamata Main provo a creare un oggetto di tipo Prova

public class Main{
	Prova p1 = new Prova(); //ERRORE perchè costruttore è privato
	Prova p2 = m(); //OK
}

/*Come trasformare un oggetto anonimo in un oggetto vero:
- creo una classe
- copio e incollo i metodi dichiarati dentro l'oggetto anonimo
(in questo caso vengono usati anche i metodi dichiarati in MyNodeList (es.: size() e getAt) --> ERRORE di compilazione
=> creo un oggetto MyNodeList così i metodi funzionano

oppure
- inner class*/

public MyIterator<E> iterator() {
        return new MyIterator<E>() { //Oggetto anonimo
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size();
            }

            @Override
            public E next() {
                try {
                    return getAt(pos++);
                } catch (NotFoundException e) {
                    e.printStackTrace();
                    throw new RuntimeException("iterator.next() failed");
                }
            }
        }
    }
	
//Creo la classe Iteratore
public class Iterator<E> implements MyIterator<E>{

    private int pos = 0;
    private MyNodeList<E> l; //creo oggetto MyNodeList così funzionano i metodi size() e getAt

    public Iterator(MyNodeList<E> l){
        this.l = l;
    }
    public boolean hasNext() {
        return pos < l.size();
    }
    public E next() {
        try {
            return l.getAt(pos++);
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("iterator.next() failed");
        }
    }
}

/*Se creo la inner class Iteratore2 all'interno di MyNodeList, non serve che creo l'oggetto MyNodeList. I metodi size() e gatAt
funzionano perchè lavorano su this (= oggetto della classe MyNodeList, in cui viene creata la inner class).
Se dichiaro la inner class come static dovrei ricreare un oggetto MyNodeList, perchè una classe statica non ha this e avrebbe bisogno di un oggetto
su cui far funzionare i metodi size() e getAt.

inner class può essere:
- static: slegata dalla classe che la include --> devo creare un oggetto della classe che la ospita
- non static
*/

public class Outer{
	public class InnerNotStatic{
	}
	public static class InnerStatic{ //devo creare un oggetto Outer
	}
	public static void m(){
		InnerNotStatic l1 = new InnerNotStatic; //ERRORE. un oggetto non statico dichiarato in un metodo statico. se m() fosse non statico allora ok
		InnerStatic l2 = new InnerStatic; //OK
	}
}
/*Affichè funzioni la prima riga del metodo m, bisogna creare un'istanza della classe che contiene InnerNotStatic:*/
public static void m(){
	Outer k = new Outer();
	InnerNotStatic l = k.new InnerNotStatic();
	InnerStatic l2 = new InnerStatic();
}

#####################################################################################################################################################

//SPIEGAZIONE DEL PROF
    // Seguono diverse implementazioni del metodo iterator() che restituisce un iteratore.
    // Ognuna di esse è equivalente alle altre, sono varianti della stessa cosa che usano aspetti diversi del linguaggio per ottenere lo stesso risultato.
    // Definiamo alcuni termini prima di proseguire:
    //    * si dice "nested class" oppure "inner class" (o anche "classe annidata" in italiano) una classe definita DENTRO un'altra, come se fosse un suo membro;
    //    * si dice "enclosing class" la classe che CONTIENE quella annidata;
    //    * si dice "enclosing instance" l'istanza della enclosing class.
    // Nel nostro esempio, MyNodeList (cioè la classe che stiamo definendo ora in questo file) è la enclosing class della inner class MyInnerIterator, definita poco sotto.
    // Per maggiori info consultate il manuale di Java: https://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.1.3



    // Il metodo iterator() è quello che bisogna implementare per rispettare l'interfaccia MyIterable.
    // Ma invece di implementare qui le diverse varianti, facciamo uno stub alla vera implementazione che ci interessa tra le varie che abbiamo scritto.
    // Commentate/decommentate le chiamante qui dentro per provare le varie implementazioni diverse.
    @Override
    public MyIterator<E> iterator() {
//        return iterator__anonymous();
//        return iterator__inner();
        return iterator__staticInner();
//        return iterator__external();
    }

    // VARIANTE 1: anonymous object

    public MyIterator<E> iterator__anonymous() {
        return new MyIterator<E>() {    // costruiamo al volo un oggetto anonimo, senza fare una classe
            private int pos = 0;        // non c'è costruttore in un oggetto anonimo, quindi dobbiamo inizializzare i campi direttamente

            @Override
            public boolean hasNext() {
                return pos < size();    // size() è visibile e si può chiamare liberamente perché è un metodo definito dalla enclosing class MyNodeList
            }

            @Override
            public E next() {
                try {
                    return MyNodeList.this.getAt(pos++);    // anche getAt() è visibile, ma scrivo esplicitamente l'espressione dell'oggetto su cui lo invochiamo: MyNodeList.this
                } catch (NotFoundException e) {
                    e.printStackTrace();
                    throw new RuntimeException("MyIterator.next() failed");
                }
            }
        };

    }

    // VARIANTE 2: inner class non statica

    public MyIterator<E> iterator__inner() {
        return new MyInnerIterator();
    }

    // Essendo non-statica, questa nested class vede il generic E della enclosing class e non serve ri-generalizzare.
    private class MyInnerIterator implements MyIterator<E> {
        private int pos = 0;

        // Non servirebbe nessun costruttore qui dentro, perché è sufficiente quello di default (vuoto e senza parametri) generato automaticamente dal compilatore.
        // Ma definendolo noi possiamo specificare private come visibilità, vietando la costruzione a chiunque eccetto che all'enclosing class.
        private MyInnerIterator() {}

        @Override
        public boolean hasNext() {
            return pos < size();
        }

        @Override
        public E next() {
            try {
                return getAt(pos++);
            } catch (NotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("MyIterator.next() failed");
            }
        }
    }

    // VARIANTE 3: inner class statica

    public MyIterator<E> iterator__staticInner() {
        return new MyStaticInnerIterator<E>(this);  // passiamo l'enclosing instance al costruttore e passiamo anche il nostro generic E come type argument
    }

    // Essendo statica, questa inner class non vede il generic E definito dalla enclosing class MyNodeList.
    // Dobbiamo quindi renderla generica a sua volta su un tipo T, perché è come se fosse totalmente slegata dallo scope in cui apparentemente risiede.
    private static class MyStaticInnerIterator<T> implements MyIterator<T> {
        private int pos = 0;
        private MyNodeList<T> enclosing;

        // Occorre definire un costruttore a cui passare l'enclosing instance.
        // Un costruttore privato è invocabile solamente dai metodi della enclosing class, quindi non permettiamo a nessuno di costruire oggetti di questa classe.
        // Il motivo è che vogliamo obbligare l'utente a chiamare il metodo iterator() per avere un iteratore: non deve poterselo costruire esplicitamente.
        private MyStaticInnerIterator(MyNodeList<T> enclosing) {
            this.enclosing = enclosing;
        }

        @Override
        public boolean hasNext() {
            return pos < enclosing.size();
        }

        @Override
        public T next() {
            try {
                return enclosing.getAt(pos++);
            } catch (NotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("MyIterator.next() failed");
            }
        }
    }

    // VARIANTE 4: classe esterna definita in un altro file

    public MyIterator<E> iterator__external() {
        return new MyNodeListIterator<E>(this);
    }

}