package it.ferroz.parcheggio;

import java.util.ArrayList;
import java.util.List;

public class Parcheggio {

	private List<Posto> listaPosti = new ArrayList<Posto>();

	private Integer numPostiLiberi;

	public Parcheggio() {
		numPostiLiberi = 0;
	}

	public void addPosti(List<? extends Posto> listaPosti) {
		for (Posto posto : listaPosti) {
			this.listaPosti.add(posto);
			if (posto.isLibero()) {
				numPostiLiberi++;
			}
		}
	}

	public Integer getNumPostiLiberi() {
		return numPostiLiberi;
	}

	public Integer getNumPostiTotali() {
		return listaPosti.size();
	}

	public Integer getNumPosti(TipoVeicolo tipoVeicolo, TipoPosto tipoPosto, Boolean custodito) {
		int res = 0;
		for (Posto posto : listaPosti) {
			if (posto.isLibero()) {
				if (posto.isCustodito() == custodito && posto.getTipo().equals(tipoPosto)
						&& posto.getTipoVeicolo().equals(tipoVeicolo)) {
					res++;
				}
			}
		}
		return res;
	}

	public Posto occupaPosto(TipoVeicolo tipoVeicolo, TipoPosto tipoPosto, Boolean custodito) {
		if (getNumPosti(tipoVeicolo, tipoPosto, custodito) > 0) {
			for (Posto posto : listaPosti) {
				if (posto.isLibero()) {
					if (posto.isCustodito() == custodito && posto.getTipo().equals(tipoPosto)
							&& posto.getTipoVeicolo().equals(tipoVeicolo)) {
						toggleStatoPosto(posto);
						numPostiLiberi--;
						return posto;
					}
				}
			}
		}
		return null;

	}

	private void toggleStatoPosto(Posto posto) {
		try {
			posto.setLibero(!posto.isLibero());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Integer liberaPosto(Posto posto) {
		toggleStatoPosto(posto);
		return ++numPostiLiberi;
		
	}

}
