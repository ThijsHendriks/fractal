package nl.hendriks.mandelbrot.kleur;

public class Kleur {
	private final int rood;
	private final int groen;
	private final int blauw;

	public Kleur(int rood, int groen, int blauw) {
		super();
		this.rood = kleur(rood);
		this.groen = kleur(groen);
		this.blauw = kleur(blauw);
	}
	
	private static final int kleur(int kleur) {
		if (kleur > 255) {
			return 255;
		} else if (kleur < 0) {
			return 0;
		}
		return kleur;
	}
	
	public int getRood() {
		return rood;
	}
	
	public int getGroen() {
		return groen;
	}
	
	public int getBlauw() {
		return blauw;
	}
}
