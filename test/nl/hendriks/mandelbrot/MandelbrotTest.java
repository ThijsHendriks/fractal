package nl.hendriks.mandelbrot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import nl.hendriks.mandelbrot.iteraties.CoordinatenBlok;
import nl.hendriks.mandelbrot.iteraties.MandelbrotInvoer;
import nl.hendriks.mandelbrot.iteraties.MandelbrotUitvoerderMaker;
import nl.hendriks.mandelbrot.iteraties.MandelbrotWerkgever;
import nl.hendriks.mandelbrot.kleur.Kleur;
import nl.hendriks.mandelbrot.kleur.KleurOvergang;
import nl.hendriks.mandelbrot.kleur.KleurVertaler;
import nl.hendriks.work.UitvoerManager;
import nl.hendriks.work.WerkKlaarListener;

public class MandelbrotTest implements WerkKlaarListener {

	private final MandelbrotInvoer mandelbrotInvoer;

	private final KleurVertaler vertaler;

	private final MandelbrotWerkgever werkgever;

	private final UitvoerManager<CoordinatenBlok, CoordinatenBlok> uitvoerManager;

	private boolean verwerkt = false;

	private int aantal;
	
	private int vergroting;

	public MandelbrotTest() {
		super();
		aantal = 1;
		
		vergroting = 4;
		mandelbrotInvoer = new MandelbrotInvoer(-0.126875d, -0.90046875d, aantal * vergroting *600,
				aantal* vergroting * 400, aantal* vergroting * 25600d, 50d);
		List<KleurOvergang> overgangen = new ArrayList<>();
		Kleur zwart = new Kleur(0, 0, 0);
		Kleur blauw = new Kleur(0, 0, 255);
		Kleur blauwgroen = new Kleur(0, 255, 255);
		overgangen.add(new KleurOvergang(zwart, blauw, 255));
		overgangen.add(new KleurOvergang(blauw, blauwgroen, 255));
		overgangen.add(new KleurOvergang(blauwgroen, zwart, 255));
		vertaler = new KleurVertaler(overgangen);
		mandelbrotInvoer.setMaximaalAantalHerhalingen(vertaler
				.totaalAantalStappen());
		werkgever = new MandelbrotWerkgever(mandelbrotInvoer, 10);
		werkgever.addKlaarListener(this);
		uitvoerManager = new UitvoerManager<>(20, werkgever,
				new MandelbrotUitvoerderMaker(mandelbrotInvoer));

	}

	public static void main(String[] args) {
		MandelbrotTest mandelbrotTest = new MandelbrotTest();
		mandelbrotTest.uitvoerManager.voerUit();

	}

	@Override
	public void klaar() {
		if (!verwerkt) {
			synchronized (this) {
				if (!verwerkt) {
					verwerkt = true;
					BufferedImage image = new BufferedImage(
							mandelbrotInvoer.getBreedte() / aantal,
							mandelbrotInvoer.getHoogte() / aantal,
							BufferedImage.TYPE_4BYTE_ABGR);

					for (int x = 0; x < mandelbrotInvoer.getBreedte()/ aantal; x++) {
						for (int y = 0; y < mandelbrotInvoer.getHoogte() / aantal; y++) {
							
							int iteratie = 0;  
							for (int i = 0; i < aantal; i++) {
								for (int j = 0; j < aantal; j++) {
									iteratie += mandelbrotInvoer.getBlok()[x * aantal + i][y * aantal + j];
								}
							}		
				
							
							Integer kleur = vertaler
									.vanNummerNaarWaarde(iteratie / (aantal * aantal));
							image.setRGB(x, y, kleur);
						}
					}

					try {
						// retrieve image

						File outputfile = new File(
								"/home/thijs/background4.png");
						ImageIO.write(image, "png", outputfile);
					} catch (IOException e) {

					}
				}

			}
		}
		uitvoerManager.stop();
	}
}
