/*CONSOLE APPLICATION: programma con un main che prende i parametri dal terminale. E' lanciato da shell.
Il s.o. passa i parametri, che vengono scritti dall'utente nel terminale, direttamente all'eseguibile.
Shell:
$> MyProgr.exe <arg1> <arg2>... <--- argomenti che passo come parametri per il mio programma

Es.: 
$> rm ./*
la shell chiama l'eseguibile "rm" che è nel path del sistema. "./*" è il parametro passato dall'utente per l'eseguibile "rm"

$> gcc MyFile.c -o myfile.exe -O3 -Wall ... 
Al gcc viene passato un array di stringhe che rappresenta tutti i parametri scritti dopo di lui ("MyFile.c" "-o" ...)

WINDOW APPLICATION: programma a finestre. Applicazione a cui non si passa nulla: non ha il main.
Es.: Chrome. Quando viene eseguito, viene aperta un finestra che aspetta l'input dell'utente (= aspetta un evento dell'utente).
E' una programmazione ad eventi --> CALLBACK

Creiamo, ad esempio, un API per un Menu: abbiamo una classe Menu costruibile con un costruttore e un metodo che imposta il testo per ogni
voce del menu + una callback (= cosa fare quando viene premuta quella determinata voce del menu)*/

interface Callback{
	public void apply();
}

//CALLEE (= chiamato)
public class Menu{
	public Menu(){ ... } //costruttore
	public void setEntry(String txt, Callback c){ ... } 
}

//CALLER (= chiamante)
Menu m = new Menu();
m.setEntry("Esci", new Callback(){ //ANONYMOUS OBJECT
	public void apply(){
		/*scrivo qui quello che succede quando viene premuta la voce "Esci" nel menu.
		Di solito si chiama la systemcall:*/
		System.exit(0); //se exit restituisce 0 al s.o. --> tutto ok. se restituisce >0 --> viene passato un codice di errore al s.o.
	}
});
