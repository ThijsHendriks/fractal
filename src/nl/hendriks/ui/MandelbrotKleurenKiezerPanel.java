package nl.hendriks.ui;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

import nl.hendriks.mandelbrot.kleur.Kleur;
import nl.hendriks.mandelbrot.kleur.KleurOvergang;
import nl.hendriks.mandelbrot.kleur.KleurVertaler;

public class MandelbrotKleurenKiezerPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5517140959789411702L;
	private List<KleurOvergang> overgangen;
	private List<KleurenVerandertListener> kleurenVerandertListeners = new ArrayList<>();

	public MandelbrotKleurenKiezerPanel() {
		super();
		overgangen = new ArrayList<>();
		Kleur zwart = new Kleur(0, 0, 0);
		Kleur donkerblauw = new Kleur(0, 0, 128);
		Kleur blauw = new Kleur(0, 0, 255);
		Kleur blauwgroen = new Kleur(0, 255, 255);
		Kleur groen = new Kleur(0, 255, 0);
		Kleur geel = new Kleur(255, 255, 0);
		Kleur rood = new Kleur(255, 0, 0);
		Kleur paars = new Kleur(255, 0, 255);

//		overgangen.add(new KleurOvergang(donkerblauw, blauw, 1024));
//		overgangen.add(new KleurOvergang(blauw, paars, 7096));
//		overgangen.add(new KleurOvergang(paars, zwart, 4096));
		
		
		int aantalStappen = 255;
		overgangen.add(new KleurOvergang(donkerblauw, blauw, aantalStappen));
		overgangen.add(new KleurOvergang(blauw, blauwgroen, aantalStappen));
		overgangen.add(new KleurOvergang(blauwgroen, groen, aantalStappen));
		overgangen.add(new KleurOvergang(groen, geel, aantalStappen));
		overgangen.add(new KleurOvergang(geel, rood, aantalStappen));
		overgangen.add(new KleurOvergang(rood, paars, aantalStappen));
		overgangen.add(new KleurOvergang(paars, blauw, aantalStappen));
		overgangen.add(new KleurOvergang(blauw, zwart, aantalStappen));
	}

	public KleurVertaler getKleurVertaler() {
		return new KleurVertaler(overgangen);
	}

	public void addKleurenVerandertListener(KleurenVerandertListener listener) {
		if (!kleurenVerandertListeners.contains(listener)) {
			kleurenVerandertListeners.add(listener);
		}
	}
}
