package it.ferroz.parcheggio;

public enum TipoVeicolo {

	AUTO("Auto"), MOTO("Moto");

	private String tipo;

	private TipoVeicolo(String tipo) {

		this.tipo = tipo;

	}

	public String getTipo() {
		return tipo;
	}

	public String toString() {
		return getTipo();
	}
}
