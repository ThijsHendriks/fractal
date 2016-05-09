package nl.hendriks.mandelbrot.kleur;

import java.awt.Color;

public class KleurOvergang {
	private final Kleur van;
	private final Kleur naar;
	private final int aantalStappen;
	
	public KleurOvergang(Kleur van, Kleur naar, int aantalStappen) {
		super();
		this.van = van;
		this.naar = naar;
		this.aantalStappen = aantalStappen;
	}
	
	public Color[] getColors() {
		Color[] colors = new Color[aantalStappen];
		for (int i = 0; i < aantalStappen; i++) {
			colors[i] = new Color( berekenKleur(van.getRood(), naar.getRood(), i), berekenKleur(van.getGroen(), naar.getGroen(), i), berekenKleur(van.getBlauw(), naar.getBlauw(), i));
		}
		return colors;
	}
	
	private int berekenKleur(int van, int naar, int stapNr) {
		return van + (((naar - van) * stapNr)/ aantalStappen);
	}

}
