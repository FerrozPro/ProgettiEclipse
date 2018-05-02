package it.ferroz.parcheggio;

public class PostoAuto extends Posto {

	private static final Double PREZZO_AUTO_BASE = 3.0;
	
	public PostoAuto(TipoPosto tipo, Boolean custodito) {
		super(id, PREZZO_AUTO_BASE, tipo, custodito, TipoVeicolo.AUTO);
	}
	
}
