package it.ferroz.parcheggio;

public enum TipoPosto {

	APERTO("Aperto", 0.0), CHIUSO("Chiuso", 10.0), GARAGE("Garage", 40.0);

	private String tipo;

	private Double maggiorazione;

	private TipoPosto(String tipo, Double maggiorazione) {

		this.tipo = tipo;
		this.maggiorazione = maggiorazione;

	}

	public String getTipo() {
		return tipo;
	}

	public Double getMaggiorazione() {
		return maggiorazione;
	}

}
