package nl.hendriks.mandelbrot.iteraties;

import java.util.ArrayList;
import java.util.List;


public class MandelbrotInvoer implements VerwerkBlokListener {
	
	private double zoomFactor;
	private double mx;
	private double my;
	private int maximaalAantalHerhalingen;
	private double detail;
	private final int[][] blok;
	public List<InvoerVerandertListener> invoerVerandertListeners = new ArrayList<>();

	public MandelbrotInvoer(double xParam,double yParam, int breedte, int hoogte, double zoomFactor, double detail) {
		super();
		this.mx = xParam;
		this.my = yParam;
		this.zoomFactor = zoomFactor;
		this.detail = detail;
		blok = new int[breedte][hoogte];
	}
	public double getZoomFactor() {
		return zoomFactor;
	}
	
	public double getX() {
		return mx;
	}

	public double getY() {
		return my;
	}
	
	public Integer getBreedte() {
		return blok.length;
	}
	
	public Integer getHoogte() {
		return blok[0].length;
	}
	
	public int getMaximaalAantalHerhalingen() {
		return maximaalAantalHerhalingen;
	}
	
	public void setMaximaalAantalHerhalingen(int maximaalAantalHerhalingen) {
		this.maximaalAantalHerhalingen = maximaalAantalHerhalingen;
		invoerVerandert();
	}
	
	public double getDetail() {
		return detail;
	}

	public void reset(double xParam,double yParam, double zoomFactor,  double detail) {
		mx = xParam;
		my = yParam;
		this.zoomFactor = zoomFactor;
		this.detail = detail;
		invoerVerandert();
		
	}
	
	
	public int[][] getBlok() {
		return blok;
	}

	
	public void addInvoerVerandertListeners(InvoerVerandertListener il) {
		invoerVerandertListeners.add(il);
	}
	
	private void invoerVerandert() {
		for (InvoerVerandertListener il : invoerVerandertListeners) {
			il.invoerVerandert();
		}
	}
	@Override
	public void verwerkBlok(CoordinatenBlok blok) {
		for (int x = 0; x < blok.getBreedte(); x++) {
			for (int y = 0; y < blok.getHoogte(); y++) {
				this.blok[blok.getLinkerBovenHoek().getX() + x][blok.getLinkerBovenHoek().getY() + y]=blok.getCoordinaat(x, y).getIteratie();
			}
		}
		
		
	}

}
