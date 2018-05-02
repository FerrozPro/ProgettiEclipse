package it.ferroz.parcheggio;

public class PostoMoto extends Posto {

	private static final Double PREZZO_MOTO_BASE = 2.0;

	public PostoMoto(TipoPosto tipo, Boolean custodito) throws ParkTypeNotPermittedException {

		super(id, PREZZO_MOTO_BASE, tipo, custodito, TipoVeicolo.MOTO);
		if (tipo.equals(TipoPosto.APERTO)) {
			throw new ParkTypeNotPermittedException();
		} 
	}

}
