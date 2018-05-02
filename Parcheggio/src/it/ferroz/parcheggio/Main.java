package it.ferroz.parcheggio;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Parcheggio parcheggio = new Parcheggio();

		List<PostoAuto> listaPostiAuto = new ArrayList<PostoAuto>();
		List<PostoMoto> listaPostiMoto = new ArrayList<PostoMoto>();

		Utility.popolaAuto(listaPostiAuto, TipoPosto.APERTO, 1123, true);
		Utility.popolaAuto(listaPostiAuto, TipoPosto.CHIUSO, 12, true);
		Utility.popolaAuto(listaPostiAuto, TipoPosto.GARAGE, 144, true);
		//Utility.popolaMoto(listaPostiMoto, TipoPosto.APERTO, 2000, true);
		Utility.popolaMoto(listaPostiMoto, TipoPosto.CHIUSO, 145, true);
		Utility.popolaMoto(listaPostiMoto, TipoPosto.GARAGE, 16, true);
		Utility.popolaAuto(listaPostiAuto, TipoPosto.APERTO, 18, false);
		Utility.popolaAuto(listaPostiAuto, TipoPosto.CHIUSO, 11, false);
		Utility.popolaAuto(listaPostiAuto, TipoPosto.GARAGE, 341, false);
		//Utility.popolaMoto(listaPostiMoto, TipoPosto.APERTO, 2000, false);
		Utility.popolaMoto(listaPostiMoto, TipoPosto.CHIUSO, 5461, false);
		Utility.popolaMoto(listaPostiMoto, TipoPosto.GARAGE, 541, false);

		parcheggio.addPosti(listaPostiAuto);
		parcheggio.addPosti(listaPostiMoto);
 
		/*
		System.out.println("Il numero di posti totali è : " + parcheggio.getNumPostiTotali());
		System.out.println("Il numero di posti liberi è : " + parcheggio.getNumPostiLiberi());

		Utility.stampaPostiLiberi(parcheggio);

		Utility.stampaPostiLiberi(parcheggio, TipoVeicolo.AUTO, TipoPosto.GARAGE, true);
		Posto res;
		res = parcheggio.occupaPosto(TipoVeicolo.AUTO, TipoPosto.GARAGE, true);
		System.out.println(
				"IL posto " + res.getIdPosto() + " è ora occupato. L'importo dovuto è: " + (res).getPrezzo());
		Utility.stampaPostiLiberi(parcheggio, TipoVeicolo.AUTO, TipoPosto.GARAGE, true);
		*/
		
		ThreadSimulazioneParheggio t = new ThreadSimulazioneParheggio(parcheggio);
		t.run();

	}

}
