package it.ferroz.parcheggio;

import java.util.List;
import java.util.Random;

public class Utility {

	private static Random random = new Random();

	static void popolaAuto(List<PostoAuto> listaPostiAuto, TipoPosto tipo, Integer numeroPosti, Boolean custodito) {
		for (int i = 0; i < numeroPosti; i++) {
			listaPostiAuto.add(new PostoAuto(tipo, custodito));
		}
	}

	static void popolaMoto(List<PostoMoto> listaPostiMoto, TipoPosto tipo, Integer numeroPosti, Boolean custodito) {
		for (int i = 0; i < numeroPosti; i++) {
			try {
				listaPostiMoto.add(new PostoMoto(tipo, custodito));
			} catch (ParkTypeNotPermittedException e) {
				e.printStackTrace();
			}
		}
	}

	static void stampaPostiLiberi(Parcheggio parcheggio) {
		System.out.println(
				"Il numero di posti liberi per le " + TipoVeicolo.AUTO.getTipo() + ", " + TipoPosto.APERTO.getTipo()
						+ ", " + "custodito è: " + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.APERTO, true));
		System.out.println("Il numero di posti liberi per le " + TipoVeicolo.AUTO.getTipo() + ", "
				+ TipoPosto.APERTO.getTipo() + ", " + "non custodito è: "
				+ parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.APERTO, false));
		System.out.println(
				"Il numero di posti liberi per le " + TipoVeicolo.AUTO.getTipo() + ", " + TipoPosto.CHIUSO.getTipo()
						+ ", " + "custodito è: " + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.CHIUSO, true));
		System.out.println("Il numero di posti liberi per le " + TipoVeicolo.AUTO.getTipo() + ", "
				+ TipoPosto.CHIUSO.getTipo() + ", " + "non custodito è: "
				+ parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.CHIUSO, false));
		System.out.println(
				"Il numero di posti liberi per le " + TipoVeicolo.AUTO.getTipo() + ", " + TipoPosto.GARAGE.getTipo()
						+ ", " + "custodito è: " + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.GARAGE, true));
		System.out.println("Il numero di posti liberi per le " + TipoVeicolo.AUTO.getTipo() + ", "
				+ TipoPosto.GARAGE.getTipo() + ", " + "non custodito è: "
				+ parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.GARAGE, false));
		System.out.println(
				"Il numero di posti liberi per le " + TipoVeicolo.MOTO.getTipo() + ", " + TipoPosto.APERTO.getTipo()
						+ ", " + "custodito è: " + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.APERTO, true));
		System.out.println("Il numero di posti liberi per le " + TipoVeicolo.MOTO.getTipo() + ", "
				+ TipoPosto.APERTO.getTipo() + ", " + "non custodito è: "
				+ parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.APERTO, false));
		System.out.println(
				"Il numero di posti liberi per le " + TipoVeicolo.MOTO.getTipo() + ", " + TipoPosto.CHIUSO.getTipo()
						+ ", " + "custodito è: " + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.CHIUSO, true));
		System.out.println("Il numero di posti liberi per le " + TipoVeicolo.MOTO.getTipo() + ", "
				+ TipoPosto.CHIUSO.getTipo() + ", " + "non custodito è: "
				+ parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.CHIUSO, false));
		System.out.println(
				"Il numero di posti liberi per le " + TipoVeicolo.MOTO.getTipo() + ", " + TipoPosto.GARAGE.getTipo()
						+ ", " + "custodito è: " + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.GARAGE, true));
		System.out.println("Il numero di posti liberi per le " + TipoVeicolo.MOTO.getTipo() + ", "
				+ TipoPosto.GARAGE.getTipo() + ", " + "non custodito è: "
				+ parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.GARAGE, false));

		System.out.println("--------------------------------------------------------------");
	}

	static void stampaPostiLiberi(Parcheggio parcheggio, TipoVeicolo tipoVeicolo, TipoPosto tipoPosto,
			Boolean custodito) {
		System.out.println("Il numero di posti liberi per le " + tipoVeicolo.getTipo() + ", " + tipoPosto.getTipo()
				+ ", " + (custodito ? "" : "non") + "custodito è: "
				+ parcheggio.getNumPosti(tipoVeicolo, tipoPosto, custodito));
	}

	public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
		int x = random.nextInt(clazz.getEnumConstants().length);
		return clazz.getEnumConstants()[x];
	}

	static void stampaParcheggio(Parcheggio parcheggio) {
		System.out.println(TipoVeicolo.AUTO.getTipo() + " " + TipoPosto.APERTO.getTipo() + " " + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.APERTO, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.APERTO, false) + " " + TipoPosto.CHIUSO.getTipo() + " " + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.CHIUSO, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.CHIUSO, false) + " " + TipoPosto.GARAGE.getTipo() + " " + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.GARAGE, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.GARAGE, false));
		System.out.println(TipoVeicolo.MOTO.getTipo() + " " + TipoPosto.APERTO.getTipo() + " " + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.APERTO, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.APERTO, false) + " " + TipoPosto.CHIUSO.getTipo() + " " + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.CHIUSO, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.CHIUSO, false) + " " + TipoPosto.GARAGE.getTipo() + " " + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.GARAGE, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.GARAGE, false));
		System.out.println("--------------------------------------------------------------");
	}
	
	static void stampaParcheggioLinea(Parcheggio parcheggio) {
		System.out.println(parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.APERTO, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.APERTO, false) + " " + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.CHIUSO, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.CHIUSO, false) + " " + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.GARAGE, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.AUTO, TipoPosto.GARAGE, false) + " " +parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.APERTO, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.APERTO, false) + " " + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.CHIUSO, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.CHIUSO, false) + " " + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.GARAGE, true) + "-" + parcheggio.getNumPosti(TipoVeicolo.MOTO, TipoPosto.GARAGE, false));
	}
}
