package nl.hendriks.mandelbrot.iteraties;

public class CoordinatenBlok {
	private Coordinaat linkerBovenHoekBlok;

	private MandelbrotCoordinaat[][] blok;

	private int breedte;

	private int hoogte;

	private double detail;

	public CoordinatenBlok(Coordinaat linkerBovenHoekBlok, double mx, double my, int blokGrootte, double zoomFactor, double detail) {
		super();
		this.linkerBovenHoekBlok = linkerBovenHoekBlok;
		this.detail = detail;
		blok = new MandelbrotCoordinaat[blokGrootte][blokGrootte];
		this.breedte = blokGrootte;
		this.hoogte = blokGrootte;
		for (int x = 0; x < blokGrootte; x++) {
			for (int y = 0; y < blokGrootte; y++) {
				blok[x][y] = new MandelbrotCoordinaat(mx +  (linkerBovenHoekBlok.getX() + x) / zoomFactor, my + (linkerBovenHoekBlok.getY() + y )/ zoomFactor, detail);
			}
		}
	}

	private void internalReset(Coordinaat linkerBovenHoekBlok, double mx, double my, int breedte, int hoogte, double zoomFactor, double detail) {
		this.linkerBovenHoekBlok = linkerBovenHoekBlok;
		this.detail = detail;
		this.breedte = breedte;
		this.hoogte = hoogte;
		for (int x = 0; x < breedte; x++) {
			for (int y = 0; y < hoogte; y++) {
				blok[x][y].reset(mx +  (linkerBovenHoekBlok.getX() + x) / zoomFactor, my + (linkerBovenHoekBlok.getY() + y )/ zoomFactor, detail);
			}
		}		
	}
	
	public void reset(Coordinaat linkerBovenHoekBlok, double mx, double my, int breedte, int hoogte, double zoomFactor, double detail){
		internalReset(linkerBovenHoekBlok, mx, my, breedte, hoogte, zoomFactor, detail);
	}
	
	public Coordinaat getLinkerBovenHoek() {
		return linkerBovenHoekBlok;
	}
	
	public void doeAantalIteraties(int aantalIteraties) {
		for (int x = 0; x < breedte; x++) {
			for (int y = 0; y < hoogte; y++) {
				blok[x][y].doeIteraties(aantalIteraties);
			}
		}
	}
	
	public MandelbrotCoordinaat getCoordinaat(int x, int y) {
		return blok[x][y];
	}
	
	public Coordinaat getLinkerBovenHoekBlok() {
		return linkerBovenHoekBlok;
	}

	public int getBreedte() {
		return breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	public double getDetail() {
		return detail;
	}
}
