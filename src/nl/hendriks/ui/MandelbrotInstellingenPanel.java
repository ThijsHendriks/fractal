package nl.hendriks.ui;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import nl.hendriks.mandelbrot.iteraties.InvoerVerandertListener;
import nl.hendriks.mandelbrot.iteraties.MandelbrotInvoer;

public class MandelbrotInstellingenPanel extends Panel implements InvoerVerandertListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5362953599133713581L;
	private MandelbrotInvoer invoer;
	private Label iteraties;
	private Label details;
	private Label x;
	private Label hoogte;
	private Label y;
	private Label breedte;
	private Label zoomfactor;

	public MandelbrotInstellingenPanel(MandelbrotInvoer invoer) {
		super(new GridLayout(8, 2));
		this.invoer = invoer;
		add(new Label("maximum aantal iteraties :"));
		iteraties = new Label("" + invoer.getMaximaalAantalHerhalingen());
		add(iteraties);
		add(new Label("details :"));
		details = new Label(invoer.getDetail() + "");
		add(details);
		add(new Label("x :"));
		x = new Label(invoer.getX() + "");
		add(x);
		add(new Label("y :"));
		y = new Label("" + invoer.getY());
		add(y);
		add(new Label("hoogte :"));
		hoogte = new Label("" + invoer.getHoogte());
		add(hoogte);
		add(new Label("breedte :"));
		breedte = new Label(invoer.getBreedte() + "");
		add(breedte);
		add(new Label("zoomFactor :" ));
		zoomfactor = new Label("" + invoer.getZoomFactor());
		add(zoomfactor);
		Button comp = new Button("test");
		comp.addActionListener(new OpslaanListener());
		add(comp);
		
	}
	
	@Override
	public void repaint() {
		super.repaint();
		update();
	}

	public void update() {
		iteraties.setText(""+invoer.getMaximaalAantalHerhalingen());
		details.setText(""+invoer.getDetail());
		x.setText(""+invoer.getX());
		hoogte.setText(""+invoer.getHoogte());
		y.setText(""+invoer.getY());
		breedte.setText(""+invoer.getBreedte());
		zoomfactor.setText(""+invoer.getZoomFactor());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		update();
	}

	@Override
	public void invoerVerandert() {
		repaint();
		
	}
}
