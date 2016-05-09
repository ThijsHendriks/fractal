package nl.hendriks.ui;

import java.awt.BorderLayout;
import java.awt.Frame;

import nl.hendriks.mandelbrot.iteraties.CoordinatenBlok;
import nl.hendriks.mandelbrot.iteraties.MandelbrotInvoer;
import nl.hendriks.mandelbrot.iteraties.MandelbrotUitvoerderMaker;
import nl.hendriks.mandelbrot.iteraties.MandelbrotWerkgever;
import nl.hendriks.work.UitvoerManager;

// An AWT GUI program inherits the top-level container java.awt.Frame
public class MandelbrotFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5243740983649314728L;

	/** Constructor to setup GUI components */
	public MandelbrotFrame() {
		MandelbrotInvoer invoer = new MandelbrotInvoer(-2.0d, -1.0d, 600, 400, 200d, 50);
		MandelbrotInstellingenPanel mandelbrotInstellingenPanel = new MandelbrotInstellingenPanel(invoer);
		MandelbrotKleurenKiezerPanel kiezerPanel = new MandelbrotKleurenKiezerPanel();
		invoer.addInvoerVerandertListeners(mandelbrotInstellingenPanel);
		MandelbrotWerkgever werkgever = new MandelbrotWerkgever(invoer, 10);
		UitvoerManager<CoordinatenBlok, CoordinatenBlok> uitvoerManager = new UitvoerManager<CoordinatenBlok, CoordinatenBlok> (20, werkgever, new MandelbrotUitvoerderMaker(invoer));
		MandelbrotViewPanel viewPanel = new MandelbrotViewPanel(invoer, uitvoerManager);
		viewPanel.setKleurenVertaler(kiezerPanel.getKleurVertaler());
		werkgever.addKlaarListener(viewPanel);
		uitvoerManager.voerUit();
		add(viewPanel, BorderLayout.CENTER);
		add(mandelbrotInstellingenPanel, BorderLayout.SOUTH);
		setSize(600, 600);
		setTitle("Mandelbrot Viewer");
		setVisible(true);
		addWindowListener(new SluitVensterListener());
	}
}