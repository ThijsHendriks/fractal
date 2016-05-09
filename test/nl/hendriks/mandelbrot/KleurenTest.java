package nl.hendriks.mandelbrot;

import java.util.ArrayList;
import java.util.List;

import nl.hendriks.mandelbrot.kleur.Kleur;
import nl.hendriks.mandelbrot.kleur.KleurOvergang;
import nl.hendriks.mandelbrot.kleur.KleurVertaler;

public class KleurenTest {

	public static void main(String[] args) {
		List<KleurOvergang> overgangen = new ArrayList<>();
		Kleur zwart = new Kleur(0, 0, 0);
		Kleur rood = new Kleur(255, 0, 0);
		Kleur groen = new Kleur(0, 255, 0);
		Kleur blauw = new Kleur(0, 0, 255);
		
		overgangen.add(new KleurOvergang(zwart, rood, 100));
		overgangen.add(new KleurOvergang(rood, groen, 100));
		overgangen.add(new KleurOvergang(groen, blauw, 100));
		overgangen.add(new KleurOvergang(blauw, zwart, 100));
		KleurVertaler vertaler = new KleurVertaler(overgangen);
		vertaler.vanNummerNaarWaarde(5);
	}
}
 