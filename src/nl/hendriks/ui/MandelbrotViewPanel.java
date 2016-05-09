package nl.hendriks.ui;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import nl.hendriks.mandelbrot.iteraties.CoordinatenBlok;
import nl.hendriks.mandelbrot.iteraties.InvoerVerandertListener;
import nl.hendriks.mandelbrot.iteraties.MandelbrotInvoer;
import nl.hendriks.mandelbrot.kleur.Kleur;
import nl.hendriks.mandelbrot.kleur.KleurOvergang;
import nl.hendriks.mandelbrot.kleur.KleurVertaler;
import nl.hendriks.work.UitvoerManager;
import nl.hendriks.work.WerkKlaarListener;

public class MandelbrotViewPanel extends Panel implements WerkKlaarListener,
		InvoerVerandertListener, KleurenVerandertListener {

	boolean veranderingenVerwerkt = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3902782160990151358L;
	private KleurVertaler vertaler;
	private BufferedImage plaatje;
	private final MandelbrotInvoer invoer;
	private UitvoerManager<CoordinatenBlok, CoordinatenBlok> uitvoerManager;

	public MandelbrotViewPanel(MandelbrotInvoer invoerParam,
			UitvoerManager<CoordinatenBlok, CoordinatenBlok> uitvoerManager) {
		super();
		this.uitvoerManager = uitvoerManager;
		invoer = invoerParam;
		invoerParam.addInvoerVerandertListeners(this);
		setBounds(0, 0, invoer.getBreedte(), invoer.getHoogte());
		plaatje = new BufferedImage(invoer.getBreedte(), invoer.getHoogte(),
				BufferedImage.TYPE_4BYTE_ABGR);
		addMouseListener(new MouseZoomListener(invoer));
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(plaatje, 0, 0, null);
		super.paint(g);
	}

	@Override
	public void klaar() {
		if (!veranderingenVerwerkt) {
			synchronized (this) {
				if (!veranderingenVerwerkt) {
					kleurMandelbrot();
					veranderingenVerwerkt = true;
				}
			}
		}
		repaint();
	}

	private void kleurMandelbrot() {
		for (int x = 0; x < invoer.getBreedte(); x++) {
			for (int y = 0; y < invoer.getHoogte(); y++) {
				plaatje.setRGB(x, y, vertaler.vanNummerNaarWaarde(invoer
						.getBlok()[x][y]));
			}
		}
	}

	@Override
	public void invoerVerandert() {
		veranderingenVerwerkt = false;
		uitvoerManager.voerUit();
	}
	
	public void setKleurenVertaler(KleurVertaler vertaler) {
		this.vertaler = vertaler;
		invoer.setMaximaalAantalHerhalingen(vertaler.totaalAantalStappen());
	}

	@Override
	public void kleurenVerandert(KleurenVerandertListener nieuweKleurenVertaler) {
		// TODO Auto-generated method stub
		
	}

}
