package it.ferroz.parcheggio;

public abstract class Posto {

	protected static Integer id = 0;

	private Integer idPosto;

	private Boolean libero;

	private Double prezzo;

	private TipoPosto tipo;
	
	private Boolean custodito;
	
	private TipoVeicolo tipoVeicolo;

	protected Posto(Integer id, Double prezzo, TipoPosto tipo, Boolean custodito, TipoVeicolo tipoVeicolo) {

		this.idPosto = getId();
		incrementaId();
		this.tipo = tipo;
		setPrezzo(prezzo);
		this.libero = true;
		this.custodito = custodito;
		this.tipoVeicolo = tipoVeicolo;

	}

	public Integer getIdPosto() {
		return idPosto;
	}

	private Integer getId() {
		return id;
	}
	
	private void incrementaId() {
		Posto.id++;
	}

	public Boolean isLibero() {
		return libero;
	}

	public void setLibero(Boolean libero) {
		this.libero = libero;
	}

	public Double getPrezzo() {
		return prezzo;
	}
	
	private void setPrezzo(Double prezzoBase) {
		this.prezzo = prezzoBase + prezzoBase * tipo.getMaggiorazione() / 100;
	}

	public TipoPosto getTipo() {
		return tipo;
	}

	public Boolean isCustodito() {
		return custodito;
	}

	public TipoVeicolo getTipoVeicolo() {
		return tipoVeicolo;
	}

}
