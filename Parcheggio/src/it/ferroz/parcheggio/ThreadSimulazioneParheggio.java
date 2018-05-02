package it.ferroz.parcheggio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadSimulazioneParheggio extends Thread implements Runnable {

	private Parcheggio parcheggio;
	private List<Posto> posto = new ArrayList<Posto>();
	private Map<Posto, Integer> listaPostiOccupati = new HashMap<Posto, Integer>();

	private Double cassa;
	private Integer numAccessi;
	private Integer numUscite;
	private DecimalFormat decimalFormat = new DecimalFormat("##.##");

	private Integer minutoInterno;

	public ThreadSimulazioneParheggio(Parcheggio parcheggio) {
		this.parcheggio = parcheggio;
		this.cassa = 0.0;
		this.numAccessi = 0;
		this.numUscite = 0;
		this.minutoInterno = 0;
	}

	private void addCassa(Double value) {
		cassa = cassa + value;
	}

	public Integer getMinutoInterno() {
		return minutoInterno;
	}

	public Integer getNumAccessi() {
		return numAccessi;
	}

	public Integer getNumUscite() {
		return numUscite;
	}

	public Double getCassa() {
		return cassa;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 100000) {
			posto.removeAll(Collections.singleton(null));
			if (Math.random() > 0.1) {
				Posto postoOccupato = parcheggio.occupaPosto(Utility.randomEnum(TipoVeicolo.class),
						Utility.randomEnum(TipoPosto.class), Math.random() > 0.5);
				if (postoOccupato != null) {
					posto.add(postoOccupato);
					// Utility.stampaParcheggioLinea(parcheggio);
					// System.out.println("Costo = " + postoOccupato.getPrezzo() + "€");
					// addCassa(postoOccupato.getPrezzo());
					// System.out.println(decimalFormat.format(cassa) + "€" + " Accessi = " +
					// (++numAccessi) + " Uscite = " + numUscite + " Posti Liberi = " +
					// parcheggio.getNumPostiLiberi());
					listaPostiOccupati.put(postoOccupato, getMinutoInterno());
					System.out.println("Nuovo accesso al minuto " + getMinutoInterno() + ". Totale numero accessi = "
							+ (++numAccessi) + " Posti Liberi Attuali = " + parcheggio.getNumPostiLiberi());
				}
			} else {
				// if (posto.size() > 0) {
				if (listaPostiOccupati.size() > 0) {
					int index = (int) (Math.random() * (posto.size() - 1));
					// System.out.println(decimalFormat.format(cassa) + "€" + " Accessi = " +
					// (++numAccessi) + " Uscite = " + (++numUscite) + " Posti Liberi = " +
					// parcheggio.getNumPostiLiberi());
					Posto key = posto.get(index);
					parcheggio.liberaPosto(key);
					Double scontrino = (getMinutoInterno() - listaPostiOccupati.get(key)) / 60d * key.getPrezzo();
					addCassa(scontrino);
					parcheggio.liberaPosto(key);
					listaPostiOccupati.remove(key);
					posto.remove(index);
					System.out.println("Nuova uscita al minuto " + getMinutoInterno() + " con prezzo = "
							+ decimalFormat.format(scontrino) + "€ e Totale = " + decimalFormat.format(cassa)
							+ " Uscite = " + (++numUscite) + " Posti Liberi = " + parcheggio.getNumPostiLiberi());

				}
			}

			try {
				sleep(0);
				minutoInterno = minutoInterno + (int)(Math.random()*10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}

}
