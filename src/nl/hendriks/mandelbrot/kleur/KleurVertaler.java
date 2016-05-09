package nl.hendriks.mandelbrot.kleur;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KleurVertaler {

	private Integer[] kleuren;

	public KleurVertaler(List<KleurOvergang> overgangen) {
		super();
		List<Color> kleurenList = new ArrayList<>();
		for (KleurOvergang kleurOvergang : overgangen) {
			kleurenList.addAll(Arrays.asList(kleurOvergang.getColors()));
		}
		kleuren = new Integer[kleurenList.size()];
		int i = 0;
		for (Color color : kleurenList) {
			kleuren[i] = color.getRGB();
			i++;
		}
	}

	public Integer vanNummerNaarWaarde(Integer nummer) {
			if(kleuren.length > nummer) { 
				return kleuren[nummer];
			}
			return kleuren[kleuren.length - 1];
	}
	
	public int totaalAantalStappen() {
		return kleuren.length;
	}
}
