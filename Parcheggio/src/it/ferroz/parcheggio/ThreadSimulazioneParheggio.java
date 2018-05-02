package it.ferroz.parcheggio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ThreadSimulazioneParheggio extends Thread implements Runnable {

	private Parcheggio parcheggio;
	private List<Posto> posto = new ArrayList<Posto>();
	
	private Double cassa;
	private Integer numAccessi;
	private Integer numUscite;
	private DecimalFormat decimalFormat =  new DecimalFormat("##.##");

	public ThreadSimulazioneParheggio(Parcheggio parcheggio) {
		this.parcheggio = parcheggio;
		this.cassa = 0.0;
		this.numAccessi = 0;
		this.numUscite = 0;
	}
	
	private void addCassa(Double value) {
		cassa = cassa + value;
	}

	@Override
	public void run() {
		while (true) {
			// posto.removeAll( Collections.singleton(null) );
			if (Math.random() > 0.0001) {
				Posto postoOccupato = parcheggio.occupaPosto(Utility.randomEnum(TipoVeicolo.class),
						Utility.randomEnum(TipoPosto.class), Math.random() > 0.5);
				if (postoOccupato != null) {
					posto.add(postoOccupato);
					//Utility.stampaParcheggioLinea(parcheggio);
					//System.out.println("Costo = " + postoOccupato.getPrezzo() + "€");
					addCassa(postoOccupato.getPrezzo());
					System.out.println(decimalFormat.format(cassa) + "€" + " Accessi = " + (++numAccessi) + " Uscite = " + numUscite + " Posti Liberi = " + parcheggio.getNumPostiLiberi());
				}
			} else {
				if (posto.size() > 0) {
					int index = (int) (Math.random() * (posto.size() - 1));
					parcheggio.liberaPosto(posto.get(index));
					posto.remove(index);
					System.out.println(decimalFormat.format(cassa) + "€" + " Accessi = " + (++numAccessi) + " Uscite = " + (++numUscite) + " Posti Liberi = " + parcheggio.getNumPostiLiberi());
				}
			} /*
				 * try { sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
				 */
		}
	}

}
